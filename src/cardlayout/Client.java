package cardlayout;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Client {
	ByteBuffer writeBuffer = ByteBuffer.allocate(1024);
	ByteBuffer readBuffer = ByteBuffer.allocate(1024);
	SelectionKey key;
	String Ip;
	int port;
	Selector selector;
	SocketChannel sc;
	Iterator<SelectionKey> keyIterator;
	public boolean start(String Ip, int port) throws IOException {
		// ��socketͨ��
		
		 sc = SocketChannel.open();
		// ����Ϊ������
		sc.configureBlocking(false);
		// ���ӷ�������ַ�Ͷ˿�
		sc.connect(new InetSocketAddress(Ip, port));
		// ��ѡ����
		selector = Selector.open();
		// ע�����ӷ�����socket�Ķ���
		sc.register(selector, SelectionKey.OP_CONNECT);
		// ѡ��һ���������Ӧ��ͨ����Ϊ I/O ����׼��������
		// �˷���ִ�д�������ģʽ��ѡ�������
		selector.select();
		// ���ش�ѡ��������ѡ�������
		 keyIterator = selector.selectedKeys().iterator();
		key = keyIterator.next();
		keyIterator.remove();
		// �жϴ�ͨ�����Ƿ����ڽ������Ӳ�����
		if (key.isConnectable()) {
			try {
				sc.finishConnect();
			} catch (Exception e) {
				return false;
			}
			return true;
		} else {
			return false;
		}
	}

	public boolean send(String data) {

		String message = data;
		writeBuffer.clear();
		writeBuffer.put(message.getBytes());
		// ������������־��λ,��Ϊ������put�����ݱ�־���ı�Ҫ����ж�ȡ���ݷ��������,��Ҫ��λ
		writeBuffer.flip();
		try {
	
			sc.write(writeBuffer);
			sc.register(selector, SelectionKey.OP_READ);
			selector.select();
			keyIterator = selector.selectedKeys().iterator();
			key = keyIterator.next();
			keyIterator.remove();
			System.out.print("receive message:");
			SocketChannel client = (SocketChannel) key.channel();
			// ������������Ա��´ζ�ȡ
			readBuffer.clear();
			int num = client.read(readBuffer);
			System.out.println(new String(readBuffer.array(), 0, num));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return false;
		}
		return true;
		// ע�����������һ�ζ�ȡ
	}

	public static void main(String[] args) throws IOException {
		Client client=new Client();
		if (client.start("localhost", 8001)) {
			client.send("hah");
		}
		client.send("shima");
		
	}
}
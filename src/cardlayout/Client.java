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
		// 打开socket通道
		
		 sc = SocketChannel.open();
		// 设置为非阻塞
		sc.configureBlocking(false);
		// 连接服务器地址和端口
		sc.connect(new InetSocketAddress(Ip, port));
		// 打开选择器
		selector = Selector.open();
		// 注册连接服务器socket的动作
		sc.register(selector, SelectionKey.OP_CONNECT);
		// 选择一组键，其相应的通道已为 I/O 操作准备就绪。
		// 此方法执行处于阻塞模式的选择操作。
		selector.select();
		// 返回此选择器的已选择键集。
		 keyIterator = selector.selectedKeys().iterator();
		key = keyIterator.next();
		keyIterator.remove();
		// 判断此通道上是否正在进行连接操作。
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
		// 将缓冲区各标志复位,因为向里面put了数据标志被改变要想从中读取数据发向服务器,就要复位
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
			// 将缓冲区清空以备下次读取
			readBuffer.clear();
			int num = client.read(readBuffer);
			System.out.println(new String(readBuffer.array(), 0, num));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return false;
		}
		return true;
		// 注册读操作，下一次读取
	}

	public static void main(String[] args) throws IOException {
		Client client=new Client();
		if (client.start("localhost", 8001)) {
			client.send("hah");
		}
		client.send("shima");
		
	}
}
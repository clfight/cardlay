  

package cardlayout;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
//����CardLayout���ֵ�ʹ��
public class cardlayout extends JFrame implements ActionListener{
	  final JPanel mainJPanel = new JPanel(); // Ĭ�ϲ����� ������
	  final CardLayout cardLayout = new CardLayout(); // ������Ƭ���ֵĶ���
	  Client client=new Client();
	  login j=new login();
	  band b=new band();
	  Data d=new Data();
	  ran r=null;
 public cardlayout() {
  this.setSize(400, 400);// ���ô����С
  this.setLocationRelativeTo(null);// ���ô��������ʾ
  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// ���������رհ�ť��ʱ�򣬾��˳�����
  Container c = this.getContentPane();// �������ȡ�������

  
  
  mainJPanel.setLayout(cardLayout);// �����������Ĳ��� Ϊ��Ƭ����
  mainJPanel.add(j,"first");
  mainJPanel.add(b,"second");
  mainJPanel.add(d,"third");
  cardLayout.last(mainJPanel);
  cardLayout.first(mainJPanel);
  //��Ӱ󶨼���
 j.getlinkbutton().addActionListener(this);
 b.getreturnbutton().addActionListener(this);
 b.getsubmitButton().addActionListener(this);
 d.getreturnbutton().addActionListener(this);
 d.getsubmitButton().addActionListener(this);
  d.getstopbutton().addActionListener(this);
 
  
  c.add(mainJPanel, BorderLayout.CENTER); //����������ӵ��������м䲿��
  // Ĭ����ʾ��������
  this.setVisible(true);// ���ô���ɼ�
 }
 public static void main(String[] args) {
  new cardlayout();
 }
public void connect(String Ip,String port) throws UnknownHostException, IOException{
	Socket client=new Socket(Ip, Integer.valueOf(port));
	PrintWriter pw_=new PrintWriter(client.getOutputStream());
	InputStreamReader bf_=new InputStreamReader(client.getInputStream());
	BufferedReader br_=new BufferedReader(bf_);
		Scanner scanner=new Scanner(System.in);
		String s_=scanner.nextLine();
		pw_.println(s_);
		pw_.flush();
		String string=null;
		string=br_.readLine();
		System.out.println(string);
}
@Override
public void actionPerformed(ActionEvent e) {
	
	// TODO Auto-generated method stub
	String com=e.getActionCommand();
	if("����".equals(com)){
		cardLayout.previous(mainJPanel);
	}else  if("����".equals(com)){
		try {
			if(client.start(j.getip().getText(), Integer.parseInt(j.getport().getText()))){
				cardLayout.next(mainJPanel);
			}
		} catch (NumberFormatException | IOException e1) {
			 JOptionPane  
             .showMessageDialog(  
                 null,  
                 "<html><font color=\"red\"  style=\"font-weight:bold;" +  
                 "background-color:white\" >"  
                     + "���Ӵ��󣡣�" + "</font></html>", "����",  
                 JOptionPane.ERROR_MESSAGE);  
		}
		
	}else  if("��".equals(com)){
		try {
			if(client.send(b.getBand().getText())){
				cardLayout.next(mainJPanel);
				 r=new ran(client);
			}
		} catch (Exception e1) {
			 JOptionPane  
             .showMessageDialog(  
                 null,  
                 "<html><font color=\"red\"  style=\"font-weight:bold;" +  
                 "background-color:white\" >"  
                     + "���ʹ��󣡣�" + "</font></html>", "����",  
                 JOptionPane.ERROR_MESSAGE);  
		}
		
	}else  if("����".equals(com)){
		try {
			SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
			String time=df.format(new Date());
			if(client.send(d.getHigh().getText()+d.getLow().getText()+d.getHeart().getText()+time)){
				 JOptionPane  
	             .showMessageDialog(  
	                 null,  
	                 "<html><font color=\"red\"  style=\"font-weight:bold;" +  
	                 "background-color:white\" >"  
	                     + "���ͳɹ�" + "</font></html>", "��ʾ",  
	                 JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (Exception e1) {
			 JOptionPane  
             .showMessageDialog(  
                 null,  
                 "<html><font color=\"red\"  style=\"font-weight:bold;" +  
                 "background-color:white\" >"  
                     + "���ʹ��󣡣�" + "</font></html>", "����",  
                 JOptionPane.ERROR_MESSAGE);  
		}
		
	}else if ("ֹͣ����".equals(com)) {
		r.stop();
	}
}
}


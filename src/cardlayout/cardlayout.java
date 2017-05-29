  

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
//讲解CardLayout布局的使用
public class cardlayout extends JFrame implements ActionListener{
	  final JPanel mainJPanel = new JPanel(); // 默认布局是 流布局
	  final CardLayout cardLayout = new CardLayout(); // 创建卡片布局的对象
	  Client client=new Client();
	  login j=new login();
	  band b=new band();
	  Data d=new Data();
	  ran r=null;
 public cardlayout() {
  this.setSize(400, 400);// 设置窗体大小
  this.setLocationRelativeTo(null);// 设置窗体居中显示
  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 当点击窗体关闭按钮的时候，就退出程序
  Container c = this.getContentPane();// 在这里获取容器面板

  
  
  mainJPanel.setLayout(cardLayout);// 重新设置面板的布局 为卡片布局
  mainJPanel.add(j,"first");
  mainJPanel.add(b,"second");
  mainJPanel.add(d,"third");
  cardLayout.last(mainJPanel);
  cardLayout.first(mainJPanel);
  //添加绑定监听
 j.getlinkbutton().addActionListener(this);
 b.getreturnbutton().addActionListener(this);
 b.getsubmitButton().addActionListener(this);
 d.getreturnbutton().addActionListener(this);
 d.getsubmitButton().addActionListener(this);
  d.getstopbutton().addActionListener(this);
 
  
  c.add(mainJPanel, BorderLayout.CENTER); //把面板对象，添加到容器的中间部分
  // 默认显示三国演义
  this.setVisible(true);// 设置窗体可见
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
	if("返回".equals(com)){
		cardLayout.previous(mainJPanel);
	}else  if("连接".equals(com)){
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
                     + "连接错误！！" + "</font></html>", "警告",  
                 JOptionPane.ERROR_MESSAGE);  
		}
		
	}else  if("绑定".equals(com)){
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
                     + "发送错误！！" + "</font></html>", "警告",  
                 JOptionPane.ERROR_MESSAGE);  
		}
		
	}else  if("发送".equals(com)){
		try {
			SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
			String time=df.format(new Date());
			if(client.send(d.getHigh().getText()+d.getLow().getText()+d.getHeart().getText()+time)){
				 JOptionPane  
	             .showMessageDialog(  
	                 null,  
	                 "<html><font color=\"red\"  style=\"font-weight:bold;" +  
	                 "background-color:white\" >"  
	                     + "发送成功" + "</font></html>", "提示",  
	                 JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (Exception e1) {
			 JOptionPane  
             .showMessageDialog(  
                 null,  
                 "<html><font color=\"red\"  style=\"font-weight:bold;" +  
                 "background-color:white\" >"  
                     + "发送错误！！" + "</font></html>", "警告",  
                 JOptionPane.ERROR_MESSAGE);  
		}
		
	}else if ("停止发送".equals(com)) {
		r.stop();
	}
}
}


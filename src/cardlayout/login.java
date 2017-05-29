package cardlayout;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class login extends JPanel {
	private static final long serialVersionUID = -4655235896173916415L;
	private JPanel contentPane;
	private JTextField IP;
	private JTextField port;
	JButton submitButton;
	
	public login(){
	    contentPane=this;
	    contentPane.setLayout(new BoxLayout(contentPane,BoxLayout.PAGE_AXIS));
	    /*
	     * ip:
	     */
	    JPanel usernamePanel=new JPanel();
	    contentPane.add(usernamePanel);                                                                                                                                                                                                                                
	    JLabel usernameLable=new JLabel("ip£º");
	    usernameLable.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
	    usernamePanel.add(usernameLable);                                                                                                                                                                                                                                                                 
	    IP=new JTextField();
	    IP.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
	    usernamePanel.add(IP);
	    IP.setColumns(10);
	     /*
	      * port:                                                                                                                                                                                                                                                                   
	      */
	     JPanel passwordPanel = new JPanel();
	     contentPane.add(passwordPanel);
	     JLabel passwordLabel = new JLabel("¶Ë¿Ú£º");
	     passwordLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
	     passwordPanel.add(passwordLabel);
	     port = new JTextField();
	     port.setColumns(10);
	     port.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
	     passwordPanel.add(port);  
	     
	     /*
	      * Á¬½Ó_button
	      */
	    JPanel buttonPanel=new JPanel();
	    contentPane.add(buttonPanel);                                                                                                                                                                                                                                  
	     submitButton=new JButton("Á¬½Ó");
	     submitButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
	    
	     buttonPanel.add(submitButton);  
	     
	    
	}
	public JButton getlinkbutton(){
		return submitButton;
		
	}
	public JTextField getip(){
		return IP;
		
	}
	public JTextField getport(){
		return port;
		
	}
}

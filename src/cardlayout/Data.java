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

public class Data extends JPanel {
	private static final long serialVersionUID = -4655235896173916415L;
	private JPanel contentPane;
	private JTextField high;
	private JTextField low;
	private JTextField heart;
	JButton submitButton;
	JButton returnButton;
	JButton stopButton;
	public Data(){
	    contentPane=this;
	    contentPane.setLayout(new BoxLayout(contentPane,BoxLayout.PAGE_AXIS));
	    /*
	     * high:
	     */
	    JPanel usernamePanel=new JPanel();
	    contentPane.add(usernamePanel);                                                                                                                                                                                                                                
	    JLabel usernameLable=new JLabel("¸ßÑ¹£º");
	    usernameLable.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
	    usernamePanel.add(usernameLable);                                                                                                                                                                                                                                                                 
	    high=new JTextField();
	    high.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
	    usernamePanel.add(high);
	    high.setColumns(10);
	     /*
	      * low:                                                                                                                                                                                                                                                                   
	      */
	     JPanel passwordPanel = new JPanel();
	     contentPane.add(passwordPanel);
	     JLabel passwordLabel = new JLabel("µÍÑ¹£º");
	     passwordLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
	     passwordPanel.add(passwordLabel);
	     low = new JTextField();
	     low.setColumns(10);
	     low.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
	     passwordPanel.add(low);  
	     /*
	      * heart:                                                                                                                                                                                                                                                                   
	      */
	     JPanel heartPanel = new JPanel();
	     contentPane.add(heartPanel);
	     JLabel heartLabel = new JLabel("ÐÄÂÊ£º");
	     heartLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
	     heartPanel.add(heartLabel);
	     heart = new JTextField();
	     heart.setColumns(10);
	     heart.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
	     heartPanel.add(heart);  
	     
	     /*
	      * button
	      */
	    JPanel buttonPanel=new JPanel();
	    contentPane.add(buttonPanel);                                                                                                                                                                                                                                  
	     submitButton=new JButton("·¢ËÍ");
	     submitButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
	     returnButton=new JButton("·µ»Ø");
	     returnButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
	     stopButton=new JButton("Í£Ö¹·¢ËÍ");
	     stopButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
	     buttonPanel.add(returnButton);     
	     buttonPanel.add(submitButton);   
	     buttonPanel.add(stopButton);  
	     
	    
	}
	
	public JButton getsubmitButton(){
		return submitButton;
		
	}
	public JButton getreturnbutton(){
		return returnButton;
		
	}
	public JButton getstopbutton(){
		return stopButton;
		
	}
	public JTextField getip(){
		return high;
		
	}
	public JTextField getport(){
		return low;
		
	}
	public JTextField getHigh() {
		return high;
	}
	public void setHigh(JTextField high) {
		this.high = high;
	}
	public JTextField getLow() {
		return low;
	}
	public void setLow(JTextField low) {
		this.low = low;
	}
	public JTextField getHeart() {
		return heart;
	}
	public void setHeart(JTextField heart) {
		this.heart = heart;
	}
}
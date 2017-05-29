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

public class band extends JPanel {
	private static final long serialVersionUID = -4655235896173916415L;
	private JPanel contentPane;
	private JTextField Band;
	JButton submitButton;
	JButton returnButton;
	public band(){
	    contentPane=this;
	    contentPane.setLayout(new BoxLayout(contentPane,BoxLayout.PAGE_AXIS));
	    /*
	     * ”√ªßID:
	     */
	    JPanel usernamePanel=new JPanel();
	    contentPane.add(usernamePanel);                                                                                                                                                                                                                                
	    JLabel usernameLable=new JLabel("”√ªßid:");
	    usernameLable.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 15));
	    usernamePanel.add(usernameLable);                                                                                                                                                                                                                                                                 
	    Band=new JTextField();
	    Band.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 15));
	    usernamePanel.add(Band);
	    Band.setColumns(10);
	  
	     /*
	      * button
	      */
	    JPanel buttonPanel=new JPanel();
	    contentPane.add(buttonPanel);                                                                                                                                                                                                                                  
	     submitButton=new JButton("∞Û∂®");
	     submitButton.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 15));
	     returnButton=new JButton("∑µªÿ");
	     returnButton.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 15));
	     buttonPanel.add(returnButton);     
	     buttonPanel.add(submitButton);     
	}
	public JButton getsubmitButton(){
		return submitButton;
		
	}
	public JButton getreturnbutton(){
		return returnButton;
		
	}
	public JTextField getBand(){
		return Band;
		
	}
	public void setBand(JTextField band) {
		Band = band;
	}
	
}
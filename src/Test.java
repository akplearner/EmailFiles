//version 11
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
//test will later ba changed to Email
public class Test extends JFrame {
	private JPanel contentPane;
	private JButton loginButton;
	private JButton creatButton;

	public Test() {
		    setTitle("Register for new account");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 500, 400);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			getContentPane().setBackground(new Color(181, 196, 252));
			
			JLabel lblWelcome = new JLabel(" EMAIL CLIENT ");
			lblWelcome.setFont(new Font("Papyrus", Font.PLAIN, 25));
			lblWelcome.setBounds(100, 35, 274, 39);
			contentPane.add(lblWelcome);
			
			creatButton = new JButton("Register");
			creatButton.setFont(new Font("Times New Roman",1,20));
			creatButton.setBounds(130, 110, 200, 55);
			contentPane.add(creatButton);
			creatButton.addActionListener(new newAccButtonListener());
			
			loginButton = new JButton("Log in");
			loginButton.setFont(new Font("Times New Roman",1,20));
			loginButton.setBounds(130, 180, 200, 55);
			contentPane.add(loginButton);
			loginButton.addActionListener(new loginButtonListener());
			
			setVisible(true);
	  }
	  

	  private class newAccButtonListener implements ActionListener{
		  public void actionPerformed(ActionEvent e) {
			  NewUser n = new NewUser();
		  }  
	  }
	  
	  
	  private class loginButtonListener implements ActionListener{
		  public void actionPerformed(ActionEvent e) {
			  Login l = new Login();
		   }	 
	  }
	  
	  
	  public static void main(String[] args){
		  Test t = new Test();
	  }
}



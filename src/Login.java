//version 7
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

public class Login extends JFrame {
	private JPanel contentPane;
	private JLabel idLabel;
	private JLabel passwordLabel;
	private JButton loginButton;
	private JTextField idField;
	private JPasswordField passwordtField;
	
	private JLabel showLabel1;
	private JLabel showLabel2;
	
	private JRadioButton radio1;
	private JRadioButton radio2;
	private JRadioButton radio3;
	private ButtonGroup radioButtonGroup;
    private String input4;
	
	
	public Login() {
		setTitle("Login");
		
		setBounds(100, 100, 580, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		getContentPane().setBackground(new Color(181, 196, 252));
		contentPane.setLayout(null);
		
		
		  
		  idLabel = new JLabel("User Name:");
		  idLabel.setFont(new Font("Times New Roman",1,18));
		  idField = new JTextField(20);
		  
		  idLabel.setBounds(82, 100, 186, 45);
		  idField.setBounds(180, 105, 186, 30);
		  contentPane.add(idLabel);
		  contentPane.add(idField);
		  
		  radio1 = new JRadioButton("@yg.com");
		  radio2 = new JRadioButton("@qc.edu");
		  radio3 = new JRadioButton("@lnb.gov");
		  radio1.setFont(new Font("Times New Roman",1,18));
		  radio2.setFont(new Font("Times New Roman",1,18));
		  radio3.setFont(new Font("Times New Roman",1,18));
		  radio1.setBounds(380, 105, 120, 25);
		  radio2.setBounds(380, 130, 120, 25);
		  radio3.setBounds(380, 155, 120, 25);
		  radioButtonGroup =  new ButtonGroup();
		  radioButtonGroup.add(radio1);
		  radioButtonGroup.add(radio2);
		  radioButtonGroup.add(radio3);
		
		  contentPane.add(radio1);
		  contentPane.add(radio2);
		  contentPane.add(radio3);
		  
		
		  
		  passwordLabel = new JLabel("Password:");
		  passwordLabel.setFont(new Font("Times New Roman",1,18));
		  
		  passwordtField = new JPasswordField(20);
		  passwordLabel.setBounds(82, 180, 186, 45);
		  passwordtField.setBounds(180, 185, 186, 30);
		  contentPane.add(passwordLabel);
		  contentPane.add(passwordtField);
		  
		  showLabel1  = new JLabel("Congrats, you have logged in!");
		  showLabel1.setFont(new Font("Times New Roman",1,20));
		  showLabel1.setForeground(Color.red);
		  showLabel1.setBounds(140, 240, 286, 45);
		  contentPane.add(showLabel1);
		  showLabel1.setVisible(false);
		  
		  showLabel2  = new JLabel("Wrong user name or password!");
		  showLabel2.setFont(new Font("Times New Roman",1,20));
		  showLabel2.setForeground(Color.red);
		  showLabel2.setBounds(140, 240, 286, 45);
		  contentPane.add(showLabel2);
		  showLabel2.setVisible(false);
		  
		
		  
		    
		  loginButton = new JButton("Login");
		  loginButton.setFont(new Font("Times New Roman",1,20));  
		  loginButton.setBounds(180, 300, 200, 45);
		  contentPane.add(loginButton);
  
		  loginButton.addActionListener(new loginButtonListener());
		  radio1.addActionListener(new RadioButtonListener());
		  radio2.addActionListener(new RadioButtonListener());
		  radio3.addActionListener(new RadioButtonListener());
		  setVisible(true);
	}
	

	private class RadioButtonListener implements ActionListener{
	      public void actionPerformed(ActionEvent e) {
	    	  if(e.getSource() == radio1)
				  input4 = "@yg.com";
			  else if(e.getSource() == radio2)
				  input4 = "@qc.edu";
			  else
				  input4 = "@lnb.gov";
	    	  
	      }
	}
	
	private class loginButtonListener implements ActionListener{
		  public void actionPerformed(ActionEvent e) {
			
			  
			  String input1 =  idField.getText();
			  input1 += input4;
			  String input2 =  passwordtField.getText();
			  String concast;
			  Connection conn =null;
			  Statement st  =null;
			  ResultSet re =null;
			  try {
				    conn = getConnection();
				    st = conn.createStatement();
				    re = st.executeQuery("SELECT * FROM user.info");
					 while(re.next()) {
						 concast = re.getString("userName") +re.getString("domain");
					
						 if(input1.equals(concast)  && input2.equals(re.getString("password"))) {
							 HomePage hp = new HomePage(input1);
							 setVisible(false);
							 conn.close();
							 return;
							   
						 }	
					 }
						 //showLabel2.setVisible(true);
					 JOptionPane.showMessageDialog(null, "Wrong user name or password, please try again!");

					  }	
					  catch(Exception ex)
					  {
					  System.out.println("ERROR: " + ex.getMessage());
					  }	
			  finally {
				    
				    if (st != null) {
				        try {
				            st.close();
				        } catch (SQLException e1) { /* ignored */}
				    }
				    if (re != null) {
				        try {
				            re.close();
				        } catch (SQLException e2) { /* ignored */}
				    }
				    if (conn != null) {
				        try {
				            conn.close();
				        } catch (SQLException e3) { /* ignored */}
				    }
				}
			 
			  
			  
		  }
	}
	public static Connection getConnection() {
		  try
		  {
			  Class.forName("com.mysql.jdbc.Driver");
				 Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/user?serverTimezone=UTC","root","Maitian123"); 
				 return conn;
		 }
		  catch(Exception ex)
		  {
		  System.out.println("ERROR: " + ex.getMessage());
		  }
		  return null;
	
	    }
	    
		
   }		




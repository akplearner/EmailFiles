//version 11.2
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;

public class NewUser extends JFrame {
//instant variables
	private JPanel contentPane;
	private JLabel firstNameLabel;
	private JLabel lastNameLabel;
	private JLabel idLabel; //user name with
	private JLabel passwordLabel;
	private JButton creAccButton;	
	private JTextField firstNameField;
	private JTextField lastNameField;
	private JTextField idField;
	private JPasswordField passwordtField;
	
	private JLabel showLabel1;
	private JLabel showLabel2;
	
	private JRadioButton radio1;
	private JRadioButton radio2;
	private ButtonGroup radioButtonGroup;
	String input4 ;

//constructor
	public NewUser() {
		setTitle("Register for new account");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		getContentPane().setBackground(new Color(181, 196, 252));
		contentPane.setLayout(null);
		
		  firstNameLabel = new JLabel("First Name:");
		  firstNameLabel.setFont(new Font("Times New Roman",1,18));
		  firstNameField = new JTextField(20);
		  
		  firstNameLabel.setBounds(82, 30, 180, 45);
		  firstNameField.setBounds(180, 35, 180, 30);
		  contentPane.add(firstNameLabel);
		  contentPane.add(firstNameField);
		  
		  lastNameLabel = new JLabel("Last Name:");
		  lastNameLabel.setFont(new Font("Times New Roman",1,18));
		  lastNameField = new JTextField(20);
		  
		  lastNameLabel.setBounds(82, 90, 180, 45);
		  lastNameField.setBounds(180, 95, 180, 30);
		  contentPane.add(lastNameLabel);
		  contentPane.add(lastNameField);
		  
		  idLabel = new JLabel("User Name:");
		  idLabel.setFont(new Font("Times New Roman",1,18));
		  idField = new JTextField(25);
		  
		 
		 
		  
		  idLabel.setBounds(82, 150, 175, 30);
		  idField.setBounds(180, 150, 175, 30);
		  contentPane.add(idLabel);
		  contentPane.add(idField);
		  
		  radio1 = new JRadioButton("@yg.com");
		  radio2 = new JRadioButton("@qc.edu");
		  radio1.setFont(new Font("Times New Roman",1,16));
		  radio2.setFont(new Font("Times New Roman",1,16));
		  radio1.setBounds(360, 145, 100, 30);
		  radio2.setBounds(360, 175, 100, 30);
		  radioButtonGroup =  new ButtonGroup();
		  radioButtonGroup.add(radio1);
		  radioButtonGroup.add(radio2);
		
		  contentPane.add(radio1);
		  contentPane.add(radio2);
		  
		  passwordLabel = new JLabel("Password:");
		  passwordLabel.setFont(new Font("Times New Roman",1,18));
		  passwordtField = new JPasswordField(20);
		  
		  passwordLabel.setBounds(82, 210, 180, 30);
		  passwordtField.setBounds(180, 215, 180, 30);
		  contentPane.add(passwordLabel);
		  contentPane.add(passwordtField);
		  
		  showLabel1  = new JLabel("Congrats, you registered it!");
		  showLabel1.setFont(new Font("Times New Roman",1,20));
		  showLabel1.setForeground(Color.red);
		  showLabel1.setBounds(120, 260, 286, 45);
		  contentPane.add(showLabel1);
		  showLabel1.setVisible(false);
		  
		  showLabel2  = new JLabel("The user name is taken!");
		  showLabel2.setFont(new Font("Times New Roman",1,20));
		  showLabel2.setForeground(Color.red);
		  showLabel2.setBounds(120, 260, 286, 45);
		  contentPane.add(showLabel2);
		  showLabel2.setVisible(false);

		  creAccButton = new JButton("create a account");
		  creAccButton.setFont(new Font("Times New Roman",1,20));
		  
		  creAccButton.setBounds(160, 320, 186, 45);
		  contentPane.add(creAccButton);
  
		  creAccButton.addActionListener(new newAccButtonListener());
		  radio1.addActionListener(new RadioButtonListener());
		  radio2.addActionListener(new RadioButtonListener());
		 setVisible(true);
	}
	
//methods	
	private class RadioButtonListener implements ActionListener{
	      public void actionPerformed(ActionEvent e) {
	    	  if(e.getSource() == radio1)
				  input4 = "@yg.com";
			  else
				  input4 = "@qc.edu";
	    	  
	      }
	}
	public String userName() {
		return idField.getText(); 
	}

	private class newAccButtonListener implements ActionListener{
		  public void actionPerformed(ActionEvent e) {
			  String input1 =  firstNameField.getText();
			  String input2 =  lastNameField.getText();
			  String input3 =  idField.getText(); 
			  String input5 =  passwordtField.getText();
			  try {
				    Connection conn = getConnection();
				    Statement st = conn.createStatement();
					 ResultSet re = st.executeQuery("SELECT * FROM user.info");
					 while(re.next()) {
					
						 if(input3.equals(re.getString("userName"))) {
							 showLabel2.setVisible(true);
							 return;
							   
						 }
						 
					
					 }
				    
				    String query = " insert into info (firstName,lastName,userName,domain,password)"
					        + " values (?, ?, ?, ?, ?)";		  
					      PreparedStatement preparedStmt = conn.prepareStatement(query);
					      preparedStmt.setString (1, input1);
					      preparedStmt.setString (2, input2);	
					      preparedStmt.setString (3, input3);
					      preparedStmt.setString (4, input4);
					      preparedStmt.setString (5, input5);	
					      preparedStmt.execute();
					 
					  }	
					  catch(Exception ex)
					  {
					  System.out.println("ERROR: " + ex.getMessage());
					  }	
			  
			 
			  
			  showLabel1.setVisible(true);
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
		
	public static void main(String[] args) {
		NewUser testN=new NewUser();
		testN.userName();
	}
}		



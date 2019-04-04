import java.awt.Color;
import java.awt.Font;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import NewUser.RadioButtonListener;

public class Compose extends JFrame {
	private String userName;
	private JPanel contentPane;
	private JLabel subjectLabel;
	private JLabel toLabel;
	private JTextField subjectField;
	private JTextField toField;
	private JTextArea textArea;
	private JButton discardButton;
	private JButton sentB;
	private JButton sentBdraft;
	
	private JRadioButton radio1;
	private JRadioButton radio2;
	private ButtonGroup radioButtonGroup;
	String input4 ;
	
	public Compose(String usr) {
		this.userName =usr;
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setTitle("New email");
		setBounds(100, 100, 680, 520);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		  
		  toLabel = new JLabel("To:");
		  toLabel.setFont(new Font("Times New Roman",1,18));
		  toField = new JTextField(80);
		  toLabel.setBounds(82, 50, 300, 45);
		  toField.setBounds(180, 52, 300, 30);
		  contentPane.add(toLabel);
		  contentPane.add(toField);

		  //radio botton
		  radio1 = new JRadioButton("@yg.com");
		  radio2 = new JRadioButton("@qc.edu");
		  radio1.setFont(new Font("Times New Roman",1,16));
		  radio2.setFont(new Font("Times New Roman",1,16));
		  radio1.setBounds(500, 65, 100, 30);
		  radio2.setBounds(500, 95, 100, 30);
		  radioButtonGroup =  new ButtonGroup();
		  radioButtonGroup.add(radio1);
		  radioButtonGroup.add(radio2);
		
		  contentPane.add(radio1);
		  contentPane.add(radio2);
		  
		  //label
		  subjectLabel = new JLabel("Subject:");
		  subjectLabel.setFont(new Font("Times New Roman",1,18));
		  subjectField = new JTextField(80);
		  subjectLabel.setBounds(82, 85, 300, 45);
		  subjectField.setBounds(180, 90, 300, 30);
		  contentPane.add(subjectLabel);
		  contentPane.add(subjectField);
		  
		  textArea = new JTextArea(10, 40);
		  textArea.setBounds(180, 140, 300, 250);
		  contentPane.add(textArea);
		
		sentB = new JButton("Send");
		sentB.setFont(new Font("Times New Roman",1,20));
		sentB.setBounds(120, 420, 120, 45);
		contentPane.add(sentB);
		sentB.addActionListener(new sentBButtonListener());
		
		//draft botton
		sentBdraft = new JButton("Save as Draft");
		sentBdraft.setFont(new Font("Times New Roman",1,20));
		sentBdraft.setBounds(260, 420, 170, 45);
		contentPane.add(sentBdraft);
		sentBdraft.addActionListener(new sentBdraftButtonListener());
		
		discardButton = new JButton("Discard");
		discardButton.setFont(new Font("Times New Roman",1,20));
		discardButton.setBounds(500, 420, 120, 45);
		contentPane.add(discardButton);
		discardButton.addActionListener(new discardButtonListener());
		getContentPane().setBackground(new Color(181, 196, 252));
		
		
		//radio 
		radio1.addActionListener(new RadioButtonListener());
		  radio2.addActionListener(new RadioButtonListener());
		setVisible(true);
	}
	
	private class RadioButtonListener implements ActionListener{
	      public void actionPerformed(ActionEvent e) {
	    	  if(e.getSource() == radio1)
				  input4 = "@yg.com";
			  else
				  input4 = "@qc.edu";
	    	  
	      }
	}
	private class sentBButtonListener implements ActionListener{
		  public void actionPerformed(ActionEvent e) {
		
			  String subject = subjectField.getText();
			  String to = toField.getText();
			  String content = textArea.getText();
			  try {
				  	Connection conn = getConnection();
					
				    String query = "INSERT INTO `user`.`info2` (`sender`, `receiver`, `subject`, `content`) VALUES (?, ?, ?, ?)";//"insert into info (from,to,subject,content)"+ " values (?, ?, ?, ?)";
					      PreparedStatement preparedStmt = conn.prepareStatement(query);
					      preparedStmt.setString (1, userName);
					      preparedStmt.setString (2, to+input4);	
					      preparedStmt.setString (3, subject);
					      preparedStmt.setString (4, content);
					      preparedStmt.execute();
					  }	
					  catch(Exception ex)
					  {
					  System.out.println("ERROR: " + ex.getMessage());
					  }	
			 
			  
		  }
	}
	private class sentBdraftButtonListener implements ActionListener{
		  public void actionPerformed(ActionEvent e) {
		
			  String subject = subjectField.getText();
			  String to = toField.getText();
			  String content = textArea.getText();
			  try {
				  	Connection conn = getConnection();
					
				    String query = "INSERT INTO `user`.`draft` (`sender`, `receiver`, `subject`, `content`) VALUES (?, ?, ?, ?)";//"insert into info (from,to,subject,content)"+ " values (?, ?, ?, ?)";
					      PreparedStatement preparedStmt = conn.prepareStatement(query);
					      preparedStmt.setString (1, userName);
					      preparedStmt.setString (2, to+input4);	
					      preparedStmt.setString (3, subject);
					      preparedStmt.setString (4, content);
					      preparedStmt.execute();
					  }	
					  catch(Exception ex)
					  {
					  System.out.println("ERROR: " + ex.getMessage());
					  }	
			 
			  
		  }
	}
	private class discardButtonListener implements ActionListener{
		  public void actionPerformed(ActionEvent e) {
			 
			  
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
	
		Compose testC = new Compose("akp@yg.com");
		//testC.textALEmails();
		
	}
	

}

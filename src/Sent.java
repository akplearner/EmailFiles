import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.DropMode;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class Sent extends JFrame {
	private String user;
	private JPanel contentPane;
	private JList emailList;
	//chose which data structure!!
	public String[] arrayEmails= {"0"};
	public ArrayList <String> emailArrayList;
//constructor
	public Sent(String user){
		this.user=user;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JList scroll;
		this.emailArrayList=emailOnSent();
		scroll= new JList(this.arrayEmails);
		JScrollPane jsp= new JScrollPane(scroll, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		contentPane.add(jsp);
		setContentPane(contentPane);
		setVisible(true);
	}	
//methods
	//ONLY FOR TEMPORARY FUNCTIONALITY, NEED TO PASS THE JList
	//need to fix the HomePage.java GUI in order to display the JList instead of the text
	public String textEmails() {
		String emails="";
		for(int i=0; i<=arrayEmails.length-1;i++ ) {
			if(arrayEmails[i]==null) {
				//emails=emails+ i+"null\n";
			}
			emails=emails+arrayEmails[i]+"\n";
		}
		return emails;
	}
	public String textALEmails() {
		String emails="";
		System.out.println("Size: "+emailArrayList.size());
		for(String str:emailArrayList) {
			emails=emails+str;
			System.out.println(emails);
		}
		return emails;
	}
	
	//it retuns array with each element as an email text.
	private ArrayList<String> emailOnSent() {
		//String a[]= {"1","2","3","4","5","6","7","8","9","10",};
		String emailLines[] =new String[100];
		ArrayList <String> emailAL= new ArrayList<String>();
		//get emails
		try {
		    Connection conn = getConnection();
		    Statement stmt = null;
		    String query =
		        "SELECT receiver, sender, subject, " +
		        "content " +
		        "from " + " user" + ".info2";		  
			    stmt = conn.createStatement();
		        ResultSet rs = stmt.executeQuery(query);
		       
		        int i=0;
		        
		        while (rs.next()) {
		            String receiver = rs.getString("receiver");
		            String sender = rs.getString("sender");
		            String subject = rs.getString("subject");
		            String content = rs.getString("content");
		            
		            //THIS NEEDS TO BE CHANGED SO IT CAN BE DISPLAYED AND SELECTED IN GUI
		            if(sender.equalsIgnoreCase(user)) {
		            	//THIS NEEDS TO BE CHANGED SO IT CAN BE DISPLAYED AND SELECTED IN GUI
			            //System.out.println(emailLines[i]+" line#: "+i);
			            //emailLines[i]="RECEIVER:"+receiver + " | SENDER:" + sender +" | SUBJECT:" + subject + " | CONTENT:" + content;
			            emailAL.add(" {SENDER:" + sender +" | RECEIVER:"+receiver +" | SUBJECT:" + subject + " | CONTENT:" + content+"} ");
		            }
		            i++;
		        }
		        conn.close();
			  }	
			  catch(Exception ex)
			  {
			  System.out.println("ERROR: " + ex.getMessage());
			  }
		return emailAL;	
	}
	
	//create connection
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
	


/**
 * Launch the application.
 */

	public static void main(String[] args) {
		/*
		EventQueue.invokeLater(new Runnable() {
			public void run() {
			}
		});
		*/
		Sent testI = new Sent("akp");
		testI.textALEmails();
		
	}
}

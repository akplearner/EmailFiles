import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.TextField;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JProgressBar;
import javax.swing.JMenuBar;
import javax.swing.JToggleButton;
import java.awt.List;
import java.awt.CardLayout;
import javax.swing.JList;
import javax.swing.JScrollPane;
import java.awt.Choice;

import javax.swing.JTextPane;
import javax.swing.DropMode;

public class HomePage extends JFrame {

	private JPanel contentPane;
	private String user;
	
	/**
	 * Create the frame.
	 */
	public HomePage(String user) {
		this.user=user;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 581, 354);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(181, 196, 252));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWelcome = new JLabel("Welcome! "+this.user);
		lblWelcome.setFont(new Font("Papyrus", Font.PLAIN, 25));
		lblWelcome.setBounds(18, 20, 174, 39);
		contentPane.add(lblWelcome);
		
		JTextPane txtpn = new JTextPane();
		txtpn.setDropMode(DropMode.INSERT);
		txtpn.setBounds(137, 60, 400, 188);
		contentPane.add(txtpn);
		
		//arrayEmails IS TEMP, IT NEEDS TO BE AS JList
		Inbox arrayInbox= new Inbox(this.user);
		
		JButton btnInbox = new JButton("Inbox");
		btnInbox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtpn.copy();
				txtpn.cut();
				txtpn.getText();
				txtpn.getDocument();
				
				//USE INBOX METHODS TO PASS INFORMATION AS(JList) INTO THIS TXTPN
				txtpn.setText(arrayInbox.textALEmails());
			}
		});
		
		btnInbox.setBounds(10, 61, 117, 29);
		contentPane.add(btnInbox);
	
		Sent arraySent= new Sent(this.user);
		JButton btnSentMail = new JButton("Sent Items");
		btnSentMail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtpn.copy();
				txtpn.cut();
				txtpn.getText();
				txtpn.getDocument();
								
				//USE INBOX METHODS TO PASS INFORMATION AS(JList) INTO THIS TXTPN
				
				//txtpn.add(arraySent);
				txtpn.setText(arraySent.textALEmails());
			}
		});
	
		btnSentMail.setBounds(10, 101, 117, 29);
		contentPane.add(btnSentMail);
		
		Draft arrayDraft= new Draft(this.user);
		JButton btnDraft = new JButton("Drafts");
		btnDraft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtpn.copy();
				txtpn.cut();
				txtpn.getText();
				txtpn.getDocument();
				txtpn.setText(arrayDraft.textALEmails());
			}
		});
		btnDraft.setBounds(10, 141, 117, 29);
		contentPane.add(btnDraft);
		
		
		Delete arrayDelete= new Delete(this.user);
		JButton btnDelete = new JButton("Deleted Items");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtpn.copy();
				txtpn.cut();
				txtpn.getText();
				txtpn.getDocument();
				txtpn.setText(arrayDelete.textALEmails());
			}
		});
		btnDelete.setBounds(10, 221, 117, 29);
		contentPane.add(btnDelete);
		
		JButton btnLogOut = new JButton("Log out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Test t= new Test();
				
			}
		});
		btnLogOut.setBounds(294, 24, 117, 29);
		contentPane.add(btnLogOut);
		
		JButton btnCompose = new JButton("Compose");
		btnCompose.addActionListener(new ActionListener() {
			 
			public void actionPerformed(ActionEvent e) {
				Compose email = new Compose(user);
			}
		});

		btnCompose.setBounds(10, 181, 117, 29);
		contentPane.add(btnCompose);
		
		setVisible(true);
	}
	public String userName() {
		return user; 
	}
	
	/**
	 * Launch the application Test
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage frame = new HomePage("akp");
					frame.setVisible(true);
					
					System.out.println(frame.userName());
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}


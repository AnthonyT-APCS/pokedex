package ui_control;
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;


import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import ui_control.*;
import javax.swing.JTextArea;

public class login extends JFrame{
	private JTextField txtLogin;
	private JTextField Username;
	private JPasswordField Password;
	private JTextField User1;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIMainMenu frame = new UIMainMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	//
	//
	
	public login() {
		
	
		setBounds(100, 100, 650, 563);
		setBackground(Color.LIGHT_GRAY);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 650, 100);
		panel.setBackground(new Color(30, 144, 255));
		getContentPane().add(panel);
		panel.setLayout(null);
		
		txtLogin = new JTextField();
		txtLogin.setEditable(false);
		txtLogin.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 83));
		txtLogin.setForeground(new Color(255, 255, 0));
		txtLogin.setBackground(new Color(30, 144, 255));
		txtLogin.setText("LOGIN ");
		txtLogin.setBounds(22, 6, 314, 73);
		panel.add(txtLogin);
		txtLogin.setColumns(10);
		
		JTextField User1 = new JTextField();
		User1.setEditable(false);
		User1.setText("Guest");
		User1.setForeground(new Color(255, 255, 255));
		User1.setBackground(new Color(30, 144, 255));
		User1.setBounds(532, 6, 96, 20);
		panel.add(User1);
		User1.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblUsername.setBounds(18, 155, 159, 40);
		getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblPassword.setBounds(18, 266, 159, 40);
		getContentPane().add(lblPassword);
		
		Username = new JTextField();
		Username.setColumns(10);
		Username.setBounds(189, 161, 406, 40);
		getContentPane().add(Username);
		
		JTextArea Confirm = new JTextArea();
		Confirm.setBounds(26, 345, 240, 123);
		getContentPane().add(Confirm);
		
		JButton Enter = new JButton("Enter");
		Enter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String uname=Username.getText();
				String pswd=Password.getText();
				
				if(uname.equals("JMort") && pswd.equals("1234"))
				{
				//shows user logged in in top right corner instead of guest account on login page
				User1.setText("John Mortensen"); 
				//shows user logged in at the top instead of guest account on main page
				UIMainMenu.Usernames.setText("John Mortensen");
				
				Confirm.setText("Welcome back Pokemon Trainer John Mortensen!");
				}
				else 
				{
			    Confirm.setText("Error: Wrong Username or Password.");
				}
			}
		});
		Enter.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		Enter.setBounds(331, 389, 240, 79);
		getContentPane().add(Enter);
		
		Password = new JPasswordField();
		Password.setHorizontalAlignment(SwingConstants.LEFT);
		Password.setBounds(189, 272, 406, 40);
		getContentPane().add(Password);
		
				
		
		
	
	}	
}
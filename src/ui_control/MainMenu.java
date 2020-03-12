package ui_control;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;

public class MainMenu extends JFrame {
	public MainMenu() {
		getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(383, 216, 117, 29);
		getContentPane().add(btnNewButton);
		setBounds(100, 100, 800, 600);
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu frame = new MainMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} 
		});
	}
}

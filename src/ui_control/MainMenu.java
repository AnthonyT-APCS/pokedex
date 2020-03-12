package ui_control;
import java.awt.EventQueue;

import javax.swing.JFrame;

public class MainMenu extends JFrame {
	public MainMenu() {
		getContentPane().setLayout(null);
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

package ui_control;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import javax.swing.JButton;

public class LeftMainMenu extends JFrame {
	public LeftMainMenu() {
		setBounds(100,100,450,600);
		getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		/*btnNewButton.setOpaque(false);
		btnNewButton.setFocusPainted(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorder(BorderFactory.createEmptyBorder(0,0,0,0)); */
		getContentPane().add(btnNewButton);
	}

	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					LeftMainMenu frame = new LeftMainMenu();
					frame.setVisible(true);
				} catch (Exception e) 
				{
					e.printStackTrace();
				}
			} 
		});
	}
}

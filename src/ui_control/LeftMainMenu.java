package ui_control;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class LeftMainMenu extends JFrame {
	public LeftMainMenu() {
		getContentPane().setBackground(new Color(255, 0, 0));
		getContentPane().setEnabled(false);
		setBounds(100,100,450,600);
		getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("round");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(6, 6, 117, 81);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("red");
		btnNewButton_1.setBounds(128, 6, 34, 29);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("yel");
		btnNewButton_1_1.setBounds(165, 6, 34, 29);
		getContentPane().add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton("gre");
		btnNewButton_1_2.setBounds(202, 6, 34, 29);
		getContentPane().add(btnNewButton_1_2);
		
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

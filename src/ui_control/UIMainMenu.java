package ui_control;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import model.CircleQueueDriver;
import model.Pokemon;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Container;

public class UIMainMenu extends JFrame {
	public UIMainMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1162, 806);
        java.awt.Image image = new ImageIcon("img/background.PNG").getImage();
        java.awt.Image image2 = new ImageIcon("img/button.JPG").getImage();
        
        // Content Panel to add Label and Image
        //https://docs.oracle.com/javase/tutorial/uiswing/components/rootpane.html
        Container content = getContentPane();
        content.setBackground(Color.LIGHT_GRAY);
        getContentPane().setLayout(null);
      
        // display area
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(140, 262, 284, 218);
        getContentPane().add(scrollPane);
        
        JTextPane display = new JTextPane();
        scrollPane.setViewportView(display);
        display.setBackground(Color.BLACK);
        display.setFont(new Font("Tahoma", Font.PLAIN, 15));
        display.setForeground(Color.WHITE);
        display.setEditable(false);
        
        // start button
        JButton text = new JButton("POKEMON");
      
        text.setForeground(Color.WHITE);
        text.setBackground(new Color(0, 128, 0));
        text.setFont(new Font("Tahoma", Font.PLAIN, 22));
        text.setBounds(180, 663, 159, 61);
        getContentPane().add(text);
        
        // power button
        JButton power = new JButton("");
        //power.setEnabled(false);
        //power.setForeground(new Color(255, 255, 255));
        power.setIcon(new ImageIcon(image2));
        power.setBounds(27, 48, 119, 115);
        getContentPane().add(power);
        power.setVisible(false);
        
        JLabel lblNewLabel = new JLabel("APCS: POKEDEX PROJECT");
        lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
        lblNewLabel.setBounds(790, 31, 307, 45);
        getContentPane().add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("APCS: POKEDEX PROJECT");
        lblNewLabel_1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
        lblNewLabel_1.setBounds(790, 74, 307, 45);
        getContentPane().add(lblNewLabel_1);
        //power.setHorizontalTextPosition(SwingConstants.CENTER);
        
        	
        
        // JLabel with image  
        JLabel pic = new JLabel("");
        pic.setBackground(Color.WHITE);
        pic.setIcon(new ImageIcon(image));
        pic.setBounds(0, 0, 1148, 769);
        content.add(pic);
        
        text.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		ArrayList<Pokemon> pokemonl = new ArrayList<Pokemon>();
        		pokemonl = Pokemon.pokemonData();
        		String pokemons = "";
        		int x;
        		for(x = 0; x < pokemonl.size(); x++)
        		{
        			pokemons = pokemons + "\n" + pokemonl.get(x);
        		}
        		display.setText(pokemons);
        		power.setVisible(true);
        		//power.setIcon(new ImageIcon(image2));
        	}
        });
	}
// 
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					UIMainMenu frame = new UIMainMenu();
					frame.setVisible(true);
				} catch (Exception e) 
				{
					e.printStackTrace();
				}
			} 
		});
	}
}

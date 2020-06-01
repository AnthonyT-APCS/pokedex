package ui_control;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import UI.loginUI;
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
	 public static JTextField Usernames = new JTextField();
	 
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
        
        //added just now Anthony Chin
       
        
        Usernames.setText("Guest");
		Usernames.setBounds(510, 11, 120, 20);
		Usernames.setEditable(false);
		content.add(Usernames);
		Usernames.setColumns(10);
        
        //
        
        JLabel lblNewLabel = new JLabel("APCS PERIOD 3: POKEDEX PROJECT");
        lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
        lblNewLabel.setBounds(811, 0, 327, 45);
        getContentPane().add(lblNewLabel);
        
        JLabel lblGroupMembers = new JLabel("GROUP MEMBERS: Anthony Chin, Lucy Gao,");
        lblGroupMembers.setHorizontalAlignment(SwingConstants.RIGHT);
        lblGroupMembers.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 15));
        lblGroupMembers.setBounds(821, 35, 307, 45);
        getContentPane().add(lblGroupMembers);
        
        JLabel lblAnthonyTsengJosh = new JLabel("Anthony Tseng, Josh Trost, Phoenix Dimagiba,");
        lblAnthonyTsengJosh.setHorizontalAlignment(SwingConstants.RIGHT);
        lblAnthonyTsengJosh.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 15));
        lblAnthonyTsengJosh.setBounds(821, 55, 307, 45);
        getContentPane().add(lblAnthonyTsengJosh);
        
        JLabel lblAnthonyTsengJosh_1 = new JLabel("Kevin Shihora, Leo Liang, Clay Castronovo,");
        lblAnthonyTsengJosh_1.setHorizontalAlignment(SwingConstants.RIGHT);
        lblAnthonyTsengJosh_1.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 15));
        lblAnthonyTsengJosh_1.setBounds(821, 75, 307, 45);
        getContentPane().add(lblAnthonyTsengJosh_1);
        
        JLabel lblAnthonyTsengJosh_1_1 = new JLabel("Andrew Stratton, Serena Xie, ");
        lblAnthonyTsengJosh_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
        lblAnthonyTsengJosh_1_1.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 15));
        lblAnthonyTsengJosh_1_1.setBounds(835, 95, 292, 45);
        getContentPane().add(lblAnthonyTsengJosh_1_1);
        
        JLabel lblAnthonyTsengJosh_1_1_1 = new JLabel("Adhith Guntur ");
        lblAnthonyTsengJosh_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
        lblAnthonyTsengJosh_1_1_1.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 15));
        lblAnthonyTsengJosh_1_1_1.setBounds(837, 115, 292, 45);
        getContentPane().add(lblAnthonyTsengJosh_1_1_1);
        
        JButton fireButton = new JButton("Fire");
        fireButton.setMargin(new Insets(1,1,1,1));
        fireButton.setForeground(new Color(0, 0, 0));
        fireButton.setBackground(new Color(0, 0, 255));
        fireButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
        fireButton.setBounds(663, 350, 50, 49);
        getContentPane().add(fireButton);
        
        fireButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		ArrayList<Pokemon> pokemon1 = new ArrayList<Pokemon>();
        		pokemon1 = Pokemon.pokemonData();
        		ArrayList<Pokemon> pokemonFire = new ArrayList<Pokemon>();
        		int x;
        		for(x = 0; x < pokemon1.size(); x++) {
        			if((pokemon1.get(x)).getType() == "fire") {
        				pokemonFire.add(pokemon1.get(x));
        			}
        		}
        		String pokemons = "";
        		for(x = 0; x < pokemonFire.size(); x++)
        		{
        			pokemons = pokemons + "\n" + pokemonFire.get(x);
        		}
        		display.setText(pokemons);
        		power.setVisible(true);
        		//power.setIcon(new ImageIcon(image2));
        	}
        });
        
        JButton waterButton = new JButton("Water");
        waterButton.setMargin(new Insets(1,1,1,1));
        waterButton.setForeground(new Color(0, 0, 0));
        waterButton.setBackground(new Color(0, 0, 255));
        waterButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
        waterButton.setBounds(717, 350, 52, 49);
        getContentPane().add(waterButton);
        
        waterButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		ArrayList<Pokemon> pokemon1 = new ArrayList<Pokemon>();
        		pokemon1 = Pokemon.pokemonData();
        		ArrayList<Pokemon> pokemon2 = new ArrayList<Pokemon>();
        		int x;
        		for(x = 0; x < pokemon1.size(); x++) {
        			if((pokemon1.get(x)).getType() == "water") {
        				pokemon2.add(pokemon1.get(x));
        			}
        		}
        		String pokemons = "";
        		for(x = 0; x < pokemon2.size(); x++)
        		{
        			pokemons = pokemons + "\n" + pokemon2.get(x);
        		}
        		display.setText(pokemons);
        		power.setVisible(true);
        		//power.setIcon(new ImageIcon(image2));
        	}
        });
        
        JButton grassButton = new JButton("Grass");
        grassButton.setMargin(new Insets(1,1,1,1));
        grassButton.setForeground(new Color(0, 0, 0));
        grassButton.setBackground(new Color(0, 0, 255));
        grassButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
        grassButton.setBounds(774, 350, 58, 49);
        getContentPane().add(grassButton);
        
        grassButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		ArrayList<Pokemon> pokemon1 = new ArrayList<Pokemon>();
        		pokemon1 = Pokemon.pokemonData();
        		ArrayList<Pokemon> pokemon2 = new ArrayList<Pokemon>();
        		int x;
        		for(x = 0; x < pokemon1.size(); x++) {
        			if((pokemon1.get(x)).getType() == "grass") {
        				pokemon2.add(pokemon1.get(x));
        			}
        		}
        		String pokemons = "";
        		for(x = 0; x < pokemon2.size(); x++)
        		{
        			pokemons = pokemons + "\n" + pokemon2.get(x);
        		}
        		display.setText(pokemons);
        		power.setVisible(true);
        		//power.setIcon(new ImageIcon(image2));
        	}
        });
        
        JButton normalButton = new JButton("Normal");
        normalButton.setMargin(new Insets(1,1,1,1));
        normalButton.setForeground(new Color(0, 0, 0));
        normalButton.setBackground(new Color(0, 0, 255));
        normalButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
        normalButton.setBounds(836, 350, 55, 49);
        getContentPane().add(normalButton);
        
        normalButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		ArrayList<Pokemon> pokemon1 = new ArrayList<Pokemon>();
        		pokemon1 = Pokemon.pokemonData();
        		ArrayList<Pokemon> pokemon2 = new ArrayList<Pokemon>();
        		int x;
        		for(x = 0; x < pokemon1.size(); x++) {
        			if((pokemon1.get(x)).getType() == "normal") {
        				pokemon2.add(pokemon1.get(x));
        			}
        		}
        		String pokemons = "";
        		for(x = 0; x < pokemon2.size(); x++)
        		{
        			pokemons = pokemons + "\n" + pokemon2.get(x);
        		}
        		display.setText(pokemons);
        		power.setVisible(true);
        		//power.setIcon(new ImageIcon(image2));
        	}
        });
        
        JButton bugButton = new JButton("Bug");
        bugButton.setMargin(new Insets(1,1,1,1));
        bugButton.setForeground(new Color(0, 0, 0));
        bugButton.setBackground(new Color(0, 0, 255));
        bugButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
        bugButton.setBounds(894, 350, 61, 49);
        getContentPane().add(bugButton);
        
        bugButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		ArrayList<Pokemon> pokemon1 = new ArrayList<Pokemon>();
        		pokemon1 = Pokemon.pokemonData();
        		ArrayList<Pokemon> pokemon2 = new ArrayList<Pokemon>();
        		int x;
        		for(x = 0; x < pokemon1.size(); x++) {
        			if((pokemon1.get(x)).getType() == "bug") {
        				pokemon2.add(pokemon1.get(x));
        			}
        		}
        		String pokemons = "";
        		for(x = 0; x < pokemon2.size(); x++)
        		{
        			pokemons = pokemons + "\n" + pokemon2.get(x);
        		}
        		display.setText(pokemons);
        		power.setVisible(true);
        		//power.setIcon(new ImageIcon(image2));
        	}
        });
        
        JButton poisonButton = new JButton("Poison");
        poisonButton.setMargin(new Insets(1,1,1,1));
        poisonButton.setForeground(new Color(0, 0, 0));
        poisonButton.setBackground(new Color(0, 0, 255));
        poisonButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
        poisonButton.setBounds(958, 350, 55, 49);
        getContentPane().add(poisonButton);
        
        poisonButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		ArrayList<Pokemon> pokemon1 = new ArrayList<Pokemon>();
        		pokemon1 = Pokemon.pokemonData();
        		ArrayList<Pokemon> pokemon2 = new ArrayList<Pokemon>();
        		int x;
        		for(x = 0; x < pokemon1.size(); x++) {
        			if((pokemon1.get(x)).getType() == "poison") {
        				pokemon2.add(pokemon1.get(x));
        			}
        		}
        		String pokemons = "";
        		for(x = 0; x < pokemon2.size(); x++)
        		{
        			pokemons = pokemons + "\n" + pokemon2.get(x);
        		}
        		display.setText(pokemons);
        		power.setVisible(true);
        		//power.setIcon(new ImageIcon(image2));
        	}
        });
        
        JButton groundButton = new JButton("Ground");
        groundButton.setMargin(new Insets(1,1,1,1));
        groundButton.setForeground(new Color(0, 0, 0));
        groundButton.setBackground(new Color(0, 0, 255));
        groundButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
        groundButton.setBounds(1016, 350, 52, 49);
        getContentPane().add(groundButton);
        
        groundButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		ArrayList<Pokemon> pokemon1 = new ArrayList<Pokemon>();
        		pokemon1 = Pokemon.pokemonData();
        		ArrayList<Pokemon> pokemon2 = new ArrayList<Pokemon>();
        		int x;
        		for(x = 0; x < pokemon1.size(); x++) {
        			if((pokemon1.get(x)).getType() == "ground") {
        				pokemon2.add(pokemon1.get(x));
        			}
        		}
        		String pokemons = "";
        		for(x = 0; x < pokemon2.size(); x++)
        		{
        			pokemons = pokemons + "\n" + pokemon2.get(x);
        		}
        		display.setText(pokemons);
        		power.setVisible(true);
        		//power.setIcon(new ImageIcon(image2));
        	}
        });
        
        JButton electricButton = new JButton("Electric");
        electricButton.setMargin(new Insets(1,1,1,1));
        electricButton.setForeground(new Color(0, 0, 0));
        electricButton.setBackground(new Color(0, 0, 255));
        electricButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
        electricButton.setBounds(663, 402, 50, 49);
        getContentPane().add(electricButton);
        
        electricButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		ArrayList<Pokemon> pokemon1 = new ArrayList<Pokemon>();
        		pokemon1 = Pokemon.pokemonData();
        		ArrayList<Pokemon> pokemon2 = new ArrayList<Pokemon>();
        		int x;
        		for(x = 0; x < pokemon1.size(); x++) {
        			if((pokemon1.get(x)).getType() == "electric") {
        				pokemon2.add(pokemon1.get(x));
        			}
        		}
        		String pokemons = "";
        		for(x = 0; x < pokemon2.size(); x++)
        		{
        			pokemons = pokemons + "\n" + pokemon2.get(x);
        		}
        		display.setText(pokemons);
        		power.setVisible(true);
        		//power.setIcon(new ImageIcon(image2));
        	}
        });
        
        JButton IceButton = new JButton("Ice");
        IceButton.setMargin(new Insets(1,1,1,1));
        IceButton.setForeground(new Color(0, 0, 0));
        IceButton.setBackground(new Color(0, 0, 255));
        IceButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
        IceButton.setBounds(717, 402, 52, 49);
        getContentPane().add(IceButton);
        
        IceButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		ArrayList<Pokemon> pokemon1 = new ArrayList<Pokemon>();
        		pokemon1 = Pokemon.pokemonData();
        		ArrayList<Pokemon> pokemon2 = new ArrayList<Pokemon>();
        		int x;
        		for(x = 0; x < pokemon1.size(); x++) {
        			if((pokemon1.get(x)).getType() == "ice") {
        				pokemon2.add(pokemon1.get(x));
        			}
        		}
        		String pokemons = "";
        		for(x = 0; x < pokemon2.size(); x++)
        		{
        			pokemons = pokemons + "\n" + pokemon2.get(x);
        		}
        		display.setText(pokemons);
        		power.setVisible(true);
        		//power.setIcon(new ImageIcon(image2));
        	}
        });
        
        JButton rockButton = new JButton("Rock");
        rockButton.setMargin(new Insets(1,1,1,1));
        rockButton.setForeground(new Color(0, 0, 0));
        rockButton.setBackground(new Color(0, 0, 255));
        rockButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
        rockButton.setBounds(774, 402, 58, 49);
        getContentPane().add(rockButton);
        
        rockButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		ArrayList<Pokemon> pokemon1 = new ArrayList<Pokemon>();
        		pokemon1 = Pokemon.pokemonData();
        		ArrayList<Pokemon> pokemon2 = new ArrayList<Pokemon>();
        		int x;
        		for(x = 0; x < pokemon1.size(); x++) {
        			if((pokemon1.get(x)).getType() == "rock") {
        				pokemon2.add(pokemon1.get(x));
        			}
        		}
        		String pokemons = "";
        		for(x = 0; x < pokemon2.size(); x++)
        		{
        			pokemons = pokemons + "\n" + pokemon2.get(x);
        		}
        		display.setText(pokemons);
        		power.setVisible(true);
        		//power.setIcon(new ImageIcon(image2));
        	}
        });
        
        JButton dragonButton = new JButton("Dragon");
        dragonButton.setMargin(new Insets(1,1,1,1));
        dragonButton.setForeground(new Color(0, 0, 0));
        dragonButton.setBackground(new Color(0, 0, 255));
        dragonButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
        dragonButton.setBounds(836, 402, 55, 49);
        getContentPane().add(dragonButton);
        
        dragonButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		ArrayList<Pokemon> pokemon1 = new ArrayList<Pokemon>();
        		pokemon1 = Pokemon.pokemonData();
        		ArrayList<Pokemon> pokemon2 = new ArrayList<Pokemon>();
        		int x;
        		for(x = 0; x < pokemon1.size(); x++) {
        			if((pokemon1.get(x)).getType() == "dragon") {
        				pokemon2.add(pokemon1.get(x));
        			}
        		}
        		String pokemons = "";
        		for(x = 0; x < pokemon2.size(); x++)
        		{
        			pokemons = pokemons + "\n" + pokemon2.get(x);
        		}
        		display.setText(pokemons);
        		power.setVisible(true);
        		//power.setIcon(new ImageIcon(image2));
        	}
        });
        
        JButton flyingButton = new JButton("Flying");
        flyingButton.setMargin(new Insets(1,1,1,1));
        flyingButton.setForeground(new Color(0, 0, 0));
        flyingButton.setBackground(new Color(0, 0, 255));
        flyingButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
        flyingButton.setBounds(894, 402, 61, 49);
        getContentPane().add(flyingButton);
        
        flyingButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		ArrayList<Pokemon> pokemon1 = new ArrayList<Pokemon>();
        		pokemon1 = Pokemon.pokemonData();
        		ArrayList<Pokemon> pokemon2 = new ArrayList<Pokemon>();
        		int x;
        		for(x = 0; x < pokemon1.size(); x++) {
        			if((pokemon1.get(x)).getType() == "flying") {
        				pokemon2.add(pokemon1.get(x));
        			}
        		}
        		String pokemons = "";
        		for(x = 0; x < pokemon2.size(); x++)
        		{
        			pokemons = pokemons + "\n" + pokemon2.get(x);
        		}
        		display.setText(pokemons);
        		power.setVisible(true);
        		//power.setIcon(new ImageIcon(image2));
        	}
        });
        
        JButton psychicButton = new JButton("Psychic");
        psychicButton.setMargin(new Insets(1,1,1,1));
        psychicButton.setForeground(new Color(0, 0, 0));
        psychicButton.setBackground(new Color(0, 0, 255));
        psychicButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
        psychicButton.setBounds(958, 402, 55, 49);
        getContentPane().add(psychicButton);
        
        psychicButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		ArrayList<Pokemon> pokemon1 = new ArrayList<Pokemon>();
        		pokemon1 = Pokemon.pokemonData();
        		ArrayList<Pokemon> pokemon2 = new ArrayList<Pokemon>();
        		int x;
        		for(x = 0; x < pokemon1.size(); x++) {
        			if((pokemon1.get(x)).getType() == "psychic") {
        				pokemon2.add(pokemon1.get(x));
        			}
        		}
        		String pokemons = "";
        		for(x = 0; x < pokemon2.size(); x++)
        		{
        			pokemons = pokemons + "\n" + pokemon2.get(x);
        		}
        		display.setText(pokemons);
        		power.setVisible(true);
        		//power.setIcon(new ImageIcon(image2));
        	}
        });
        
        JButton steelButton = new JButton("Steel");
        steelButton.setMargin(new Insets(1,1,1,1));
        steelButton.setForeground(new Color(0, 0, 0));
        steelButton.setBackground(new Color(0, 0, 255));
        steelButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
        steelButton.setBounds(1016, 402, 50, 49);
        getContentPane().add(steelButton);
        
        
       // login button 
        JButton loginButton = new JButton("LOGIN");
        loginButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	
        			new login().setVisible(true);
        		
        	}
        });
        loginButton.setBackground(Color.LIGHT_GRAY);
        loginButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
        loginButton.setBounds(671, 517, 159, 61);
        getContentPane().add(loginButton);
        //power.setHorizontalTextPosition(SwingConstants.CENTER);
        
        	
        
        // JLabel with image  
        JLabel pic = new JLabel("");
        pic.setBackground(Color.WHITE);
        pic.setIcon(new ImageIcon(image));
        pic.setBounds(0, 0, 1148, 769);
        content.add(pic);
        
        steelButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		ArrayList<Pokemon> pokemon1 = new ArrayList<Pokemon>();
        		pokemon1 = Pokemon.pokemonData();
        		ArrayList<Pokemon> pokemon2 = new ArrayList<Pokemon>();
        		int x;
        		for(x = 0; x < pokemon1.size(); x++) {
        			if((pokemon1.get(x)).getType() == "steel") {
        				pokemon2.add(pokemon1.get(x));
        			}
        		}
        		String pokemons = "";
        		for(x = 0; x < pokemon2.size(); x++)
        		{
        			pokemons = pokemons + "\n" + pokemon2.get(x);
        		}
        		display.setText(pokemons);
        		power.setVisible(true);
        		//power.setIcon(new ImageIcon(image2));
        	}
        });
        
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

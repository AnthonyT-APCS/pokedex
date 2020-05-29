package ui_control;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import com.amazonaws.services.dynamodbv2.document.Item;

import dynamoDB.SimplifiedDB;
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

public class dbUItest extends JFrame {
	public dbUItest() {
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
        //power.setHorizontalTextPosition(SwingConstants.CENTER);
        
        	
        
        // JLabel with image  
        JLabel pic = new JLabel("");
        pic.setBackground(Color.WHITE);
        pic.setIcon(new ImageIcon(image));
        pic.setBounds(0, 0, 1148, 769);
        content.add(pic);
        
        JButton fireButton = new JButton("Fire");
        fireButton.setForeground(new Color(0, 0, 0));
        fireButton.setBackground(new Color(0, 0, 255));
        fireButton.setFont(new Font("Tahoma", Font.PLAIN, 8));
        fireButton.setBounds(663, 350, 50, 49);
        getContentPane().add(fireButton);
        
        fireButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String pokemons = "";
        		for(Item i: Pokemon.pokemonFire)
        		{
        			pokemons += "\n " + i.getNumber("index") + ", " + i.getString("nameSK").substring(5, 6).toUpperCase() + i.getString("nameSK").substring(6);
        		}
        		display.setText(pokemons);
        		power.setVisible(true);
        		//power.setIcon(new ImageIcon(image2));
        	}
        });
        
        JButton waterButton = new JButton("Water");
        waterButton.setForeground(new Color(0, 0, 0));
        waterButton.setBackground(new Color(0, 0, 255));
        waterButton.setFont(new Font("Tahoma", Font.PLAIN, 8));
        waterButton.setBounds(717, 350, 52, 49);
        getContentPane().add(waterButton);
        
        waterButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String pokemons = "";
        		for(Item i: Pokemon.pokemonWater)
        		{
        			pokemons += "\n " + i.getNumber("index") + ", " + i.getString("nameSK").substring(5, 6).toUpperCase() + i.getString("nameSK").substring(6);
        		}
        		display.setText(pokemons);
        		power.setVisible(true);
        		//power.setIcon(new ImageIcon(image2));
        	}
        });
        
        JButton grassButton = new JButton("Grass");
        grassButton.setForeground(new Color(0, 0, 0));
        grassButton.setBackground(new Color(0, 0, 255));
        grassButton.setFont(new Font("Tahoma", Font.PLAIN, 8));
        grassButton.setBounds(774, 350, 58, 49);
        getContentPane().add(grassButton);
        
        grassButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String pokemons = "";
        		for(Item i: Pokemon.pokemonGrass)
        		{
        			pokemons += "\n " + i.getNumber("index") + ", " + i.getString("nameSK").substring(5, 6).toUpperCase() + i.getString("nameSK").substring(6);
        		}
        		display.setText(pokemons);
        		power.setVisible(true);
        		//power.setIcon(new ImageIcon(image2));
        	}
        });
        
        JButton normalButton = new JButton("Normal");
        normalButton.setForeground(new Color(0, 0, 0));
        normalButton.setBackground(new Color(0, 0, 255));
        normalButton.setFont(new Font("Tahoma", Font.PLAIN, 8));
        normalButton.setBounds(836, 350, 55, 49);
        getContentPane().add(normalButton);
        
        normalButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String pokemons = "";
        		for(Item i: Pokemon.pokemonNormal)
        		{
        			pokemons += "\n " + i.getNumber("index") + ", " + i.getString("nameSK").substring(5, 6).toUpperCase() + i.getString("nameSK").substring(6);
        		}
        		display.setText(pokemons);
        		power.setVisible(true);
        		//power.setIcon(new ImageIcon(image2));
        	}
        });
        
        JButton bugButton = new JButton("Bug");
        bugButton.setForeground(new Color(0, 0, 0));
        bugButton.setBackground(new Color(0, 0, 255));
        bugButton.setFont(new Font("Tahoma", Font.PLAIN, 8));
        bugButton.setBounds(894, 350, 61, 49);
        getContentPane().add(bugButton);
        
        bugButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String pokemons = "";
        		for(Item i: Pokemon.pokemonBug)
        		{
        			pokemons += "\n " + i.getNumber("index") + ", " + i.getString("nameSK").substring(5, 6).toUpperCase() + i.getString("nameSK").substring(6);
        		}
        		display.setText(pokemons);
        		power.setVisible(true);
        		//power.setIcon(new ImageIcon(image2));
        	}
        });
        
        JButton poisonButton = new JButton("Poison");
        poisonButton.setForeground(new Color(0, 0, 0));
        poisonButton.setBackground(new Color(0, 0, 255));
        poisonButton.setFont(new Font("Tahoma", Font.PLAIN, 8));
        poisonButton.setBounds(958, 350, 55, 49);
        getContentPane().add(poisonButton);
        
        poisonButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String pokemons = "";
        		for(Item i: Pokemon.pokemonPoison)
        		{
        			pokemons += "\n " + i.getNumber("index") + ", " + i.getString("nameSK").substring(5, 6).toUpperCase() + i.getString("nameSK").substring(6);
        		}
        		display.setText(pokemons);
        		power.setVisible(true);
        		//power.setIcon(new ImageIcon(image2));
        	}
        });
        
        JButton groundButton = new JButton("Ground");
        groundButton.setForeground(new Color(0, 0, 0));
        groundButton.setBackground(new Color(0, 0, 255));
        groundButton.setFont(new Font("Tahoma", Font.PLAIN, 8));
        groundButton.setBounds(1016, 350, 52, 49);
        getContentPane().add(groundButton);
        
        groundButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String pokemons = "";
        		for(Item i: Pokemon.pokemonGround)
        		{
        			pokemons += "\n " + i.getNumber("index") + ", " + i.getString("nameSK").substring(5, 6).toUpperCase() + i.getString("nameSK").substring(6);
        		}
        		display.setText(pokemons);
        		power.setVisible(true);
        		//power.setIcon(new ImageIcon(image2));
        	}
        });
        
        JButton electricButton = new JButton("Electric");
        electricButton.setForeground(new Color(0, 0, 0));
        electricButton.setBackground(new Color(0, 0, 255));
        electricButton.setFont(new Font("Tahoma", Font.PLAIN, 8));
        electricButton.setBounds(663, 402, 50, 49);
        getContentPane().add(electricButton);
        
        electricButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String pokemons = "";
        		for(Item i: Pokemon.pokemonElectric)
        		{
        			pokemons += "\n " + i.getNumber("index") + ", " + i.getString("nameSK").substring(5, 6).toUpperCase() + i.getString("nameSK").substring(6);
        		}
        		display.setText(pokemons);
        		power.setVisible(true);
        		//power.setIcon(new ImageIcon(image2));
        	}
        });
        
        JButton IceButton = new JButton("Ice");
        IceButton.setForeground(new Color(0, 0, 0));
        IceButton.setBackground(new Color(0, 0, 255));
        IceButton.setFont(new Font("Tahoma", Font.PLAIN, 8));
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
        rockButton.setForeground(new Color(0, 0, 0));
        rockButton.setBackground(new Color(0, 0, 255));
        rockButton.setFont(new Font("Tahoma", Font.PLAIN, 8));
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
        dragonButton.setForeground(new Color(0, 0, 0));
        dragonButton.setBackground(new Color(0, 0, 255));
        dragonButton.setFont(new Font("Tahoma", Font.PLAIN, 8));
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
        flyingButton.setForeground(new Color(0, 0, 0));
        flyingButton.setBackground(new Color(0, 0, 255));
        flyingButton.setFont(new Font("Tahoma", Font.PLAIN, 8));
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
        psychicButton.setForeground(new Color(0, 0, 0));
        psychicButton.setBackground(new Color(0, 0, 255));
        psychicButton.setFont(new Font("Tahoma", Font.PLAIN, 8));
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
        steelButton.setForeground(new Color(0, 0, 0));
        steelButton.setBackground(new Color(0, 0, 255));
        steelButton.setFont(new Font("Tahoma", Font.PLAIN, 8));
        steelButton.setBounds(1016, 402, 50, 49);
        getContentPane().add(steelButton);
        
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
					dbUItest frame = new dbUItest();
					frame.setVisible(true);
				} catch (Exception e) 
				{
					e.printStackTrace();
				}
			} 
		});
	}
}

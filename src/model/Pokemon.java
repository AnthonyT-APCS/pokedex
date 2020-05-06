package model;

import java.util.ArrayList;

import model.Extension;
import model.Pokemon;
import model.Pokemon.KeyType;

public class Pokemon extends Extension{
	
	//declaring variables
	public static final String type = "Pokemon";
	public enum KeyType {combination, name, pokedexnum};
	public static KeyType key = KeyType.combination;
	public String name;
	public int pokeDexNum;
	public static ArrayList<Pokemon> pokeArray; //use this for tester
	
	//public class for creating object
	public Pokemon(String name, int pokedexnum)
	{
		this.setType(type);
		this.name = name; 
		this.pokeDexNum = pokedexnum; 
	}

	//Creating the object together. Adding all the characteristics to the object.
	public String toString()
	{
		String output="";
		switch(key) {
		case name:
			output += this.name;
			break;
		case pokedexnum:
			output += this.pokeDexNum;
			break;
		case combination:
		default:
			output += type + ": " + this.name  + ", " + this.pokeDexNum; 
		}
		return output;
		
	}
	
	public static ArrayList<Pokemon> pokemonData() {
		
		ArrayList<Pokemon> temp = new ArrayList<Pokemon>();
		
		Pokemon[] pok = {
				new Pokemon(""),
				new Pokemon("Squirtle", 7),
				new Pokemon("Psyduck", 54),
				new Pokemon("Poliwag", 60),
				new Pokemon("Golduck", 55),
				new Pokemon("Poliwhirl", 61),
				new Pokemon("Seadra", 117),
				new Pokemon("Slowpoke", 79),
				new Pokemon("Slowbro", 80),
				new Pokemon("Seel", 86),
				new Pokemon("Shellder", 90),
				new Pokemon("Krabby", 98),
				new Pokemon("Kingler", 99),
				new Pokemon("Horsea", 116),
				new Pokemon("Seadra", 117),
				new Pokemon("Goldeen", 118),
				new Pokemon("Seaking", 119),
				new Pokemon("Staryu", 120),
				new Pokemon("Magikarp", 129),
				new Pokemon("Vaporeon", 134)
		};
		
		for(Pokemon x : pok)
		{
			temp.add(x);
		}
		return temp;
	}
	
	public static void main(String[] args)
	{
		System.out.println(pokemonData()); //populating pokeArray with the pokemons.
		
		//for(Generics p : pok)
		//System.out.println(p);
	}
}

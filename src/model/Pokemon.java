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
	public Pokemon(String name, int pokedexnum, String type)
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
			while (output.length() < 4)
			{
				output = "0" + output;
			}
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
				new Pokemon("Bulbasaur", 1, "grass"),
				new Pokemon("Ivysaur", 2, "grass"),
				new Pokemon("Venusaur", 3, "grass"),
				new Pokemon("Charmander", 4, "fire"),
				new Pokemon("Charmeleon", 5, "fire"),
				new Pokemon("Charizard", 6, "fire"),
				new Pokemon("Squirtle", 7, "water"),
				new Pokemon("Wartortle", 8, "water"),
				new Pokemon("Blastoise", 9, "water"),
				new Pokemon("Caterpie", 10, "bug"),
				new Pokemon("Metapod", 11, "bug"),
				new Pokemon("Butterfree", 12, "bug"),
				new Pokemon("Weedle", 13, "bug"),
				new Pokemon("Kakuna", 14, "bug"),
				new Pokemon("Beedrill", 15, "bug"),
				new Pokemon("Pidgey", 16, "normal"),
				new Pokemon("Pidgeotto", 17, "normal"),
				new Pokemon("Pidgeot", 18, "normal"),
				new Pokemon("Rattata", 18, "normal"),
				new Pokemon("Raticate", 20, "normal"),
				new Pokemon("Spearow", 21, "normal"),
				new Pokemon("Fearow", 22, "normal"),
				new Pokemon("Ekans", 23, "poison"),
				new Pokemon("Arbok", 24, "poison"),
				new Pokemon("Pikachu", 25, "electric"),
				new Pokemon("Raichu", 26, "electric"),
				new Pokemon("Sandshrew", 27, "ground"),
				new Pokemon("Sandslash", 28, "ground"),
				new Pokemon("Nidoran♀", 29, "poison"),
				new Pokemon("Nidorina", 30, "poison"),
				
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

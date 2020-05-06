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
				new Pokemon("Bulbasaur", 1),
				new Pokemon("Ivysaur", 2),
				new Pokemon("Venusaur", 3),
				new Pokemon("Charmander", 4),
				new Pokemon("Charmeleon", 5),
				new Pokemon("Charizard", 6),
				new Pokemon("Squirtle", 7),
				new Pokemon("Wartortle", 8),
				new Pokemon("Blastoise", 9),
				new Pokemon("Caterpie", 10),
				new Pokemon("Metapod", 11),
				new Pokemon("Butterfree", 12),
				new Pokemon("Weedle", 13),
				new Pokemon("Kakuna", 14),
				new Pokemon("Beedrill", 15),
				new Pokemon("Pidgey", 16),
				new Pokemon("Pidgeotto", 17),
				new Pokemon("Pidgeot", 18),
				new Pokemon("Rattata", 18),
				new Pokemon("Raticate", 20),
				new Pokemon("Spearow", 21),
				new Pokemon("Fearow", 22),
				new Pokemon("Ekans", 23),
				new Pokemon("Arbok", 24),
				new Pokemon("Pikachu", 25),
				new Pokemon("Raichu", 26),
				new Pokemon("Sandshrew", 27),
				new Pokemon("Sandslash", 28),
				new Pokemon("Nidoran♀", 29),
				new Pokemon("Nidorina", 30),
				new Pokemon("Nidoqueen", 31),
				new Pokemon("Nidoran♂", 32),
				new Pokemon("Nidorino", 33),
				new Pokemon("Nidoking", 34),
				new Pokemon("Clefairy", 35),
				new Pokemon("Clefable", 36),
				new Pokemon("Vulpix", 37),
				new Pokemon("Ninetales", 38),
				new Pokemon("Jigglypuff", 39),
				new Pokemon("Wigglytuff", 40),
				new Pokemon("Zubat", 41),
				new Pokemon("Golbat", 42),
				new Pokemon("Oddish", 43),
				new Pokemon("Gloom", 44),
				new Pokemon("Vileplume", 45),
				new Pokemon("Paras", 46),
				new Pokemon("Parasect", 47),
				new Pokemon("Venonat", 48),
				new Pokemon("Venomoth", 49),
				new Pokemon("Diglett", 50),
				new Pokemon("Dugtrio", 51),
				new Pokemon("Meowth", 52),
				new Pokemon("Persian", 53),
				new Pokemon("Psyduck", 54),
				new Pokemon("Golduck", 55),
				new Pokemon("Mankey", 56),
				new Pokemon("Primeape", 57),
				new Pokemon("Growlithe", 58),
				new Pokemon("Arcanine", 59),
				new Pokemon("Poliwag", 60),
				new Pokemon("Poliwhirl", 61),
				new Pokemon("Poliwrath", 62),
				new Pokemon("Abra", 63),
				new Pokemon("Kadabra", 64),
				new Pokemon("Alakazam", 65),
				new Pokemon("Machop", 66),
				new Pokemon("Machoke", 67),
				new Pokemon("Machamp", 68),
				new Pokemon("Bellsprout", 69),
				new Pokemon("Weepinbell", 70),
				new Pokemon("Victreebel", 71),
				new Pokemon("Tentacool", 72),
				new Pokemon("Tentacruel", 73),
				new Pokemon("Geodude", 74),
				new Pokemon("Graveler", 75),
				new Pokemon("Golem", 76),
				new Pokemon("Ponyta", 77),
				new Pokemon("Rapidash", 78),
				new Pokemon("Slowpoke", 79),
				new Pokemon("Slowbro", 80),
				new Pokemon("Magnemite", 81),
				new Pokemon("Magneton", 82),
				new Pokemon("Farfetch'd", 83),
				new Pokemon("Doduo", 84),
				new Pokemon("Dodrio", 85),
				new Pokemon("Seel", 86),
				new Pokemon("Dewgong", 87),
				new Pokemon("Grimer", 88),
				new Pokemon("Muk", 89),
				new Pokemon("Shellder", 90),
				new Pokemon("Cloyster", 91),
				new Pokemon("Gastly", 92),
				new Pokemon("Haunter", 93),
				new Pokemon("Gengar", 94),
				new Pokemon("Onix", 95),
				new Pokemon("Drowzee", 96),
				new Pokemon("Hypno", 97),
				new Pokemon("Krabby", 98),
				new Pokemon("Kingler", 99),
				new Pokemon ("Voltorb", 100),
				new Pokemon ("Electrode", 101),
				new Pokemon ("Exeggcute", 102),
				new Pokemon ("Exeggutor", 103),
				new Pokemon ("Cubone", 104),
				new Pokemon ("Marowak", 105),
				new Pokemon ("Hitmonlee", 106),
				new Pokemon ("Hitmonchan", 107),
				new Pokemon ("Lickitung", 108),
				new Pokemon ("Koffing", 109),
				new Pokemon ("Weezing", 110),
				new Pokemon ("Rhyhorn", 111),
				new Pokemon ("Rhydon", 112),
				new Pokemon ("Chansey", 113),
				new Pokemon ("Tangela", 114),
				new Pokemon ("Kangaskhan", 115),
				new Pokemon("Horsea", 116),
				new Pokemon("Seadra", 117),
				new Pokemon("Goldeen", 118),
				new Pokemon("Seaking", 119),
				new Pokemon("Staryu", 120),
				new Pokemon("Starmie", 121),
				new Pokemon("Mr. Mime", 122),
				new Pokemon("Scyther", 123),
				new Pokemon("Jynx", 124),
				new Pokemon("Electabuzz", 125),
				new Pokemon("Magmar", 126),
				new Pokemon("Pinsir", 127),
				new Pokemon("Tauros", 128),
				new Pokemon("Magikarp", 129),
				new Pokemon("Gyarados", 130),
				new Pokemon("Lapras", 131),
				new Pokemon("Ditto", 132),
				new Pokemon("Eevee", 133),
				new Pokemon("Vaporeon", 134),
				new Pokemon("Jolteon", 135),
				new Pokemon("Flareon", 136),
				new Pokemon("Porygon", 137),
				new Pokemon("Omanyte", 138),
				new Pokemon("Omastar", 139),
				new Pokemon("Kabuto", 140),
				new Pokemon("Kabutops", 141),
				new Pokemon("Aerodactyl", 142),
				new Pokemon("Snorlax", 143),
				new Pokemon("Articuno", 144),
				new Pokemon("Zapdos", 145),
				new Pokemon("Moltres", 146),
				new Pokemon("Dratini", 147),
				new Pokemon("Dragonair", 148),
				new Pokemon("Dragonite", 149),
				new Pokemon("Mewtwo", 150),
				new Pokemon("Mew", 151),
				new Pokemon("Meltan", 152),
				new Pokemon("Melmetal", 153),
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

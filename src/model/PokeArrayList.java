package model;

import java.util.ArrayList;

import model.Pokemon;

public class PokeArrayList {
	
	public static ArrayList<Pokemon> pokeArray;
	private static ArrayList<Integer> pokeDexNumArrayList;
	
	public static ArrayList<Integer> ArrayList()
	{
		pokeArray = Pokemon.pokemonData();
		pokeDexNumArrayList = new ArrayList<Integer>();
		
		for(Pokemon x : pokeArray)
		{
			pokeDexNumArrayList.add(x.pokeDexNum);
		}
		
		return pokeDexNumArrayList;
		
	}
	
	public static void addPokeArray(Pokemon temp)
	{
		pokeArray.add(temp);
	}
	
}
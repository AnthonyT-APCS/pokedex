package model;

import java.util.ArrayList;

import model.PokeArrayList;
import model.Pokemon;
import model.Sorts;
import model.Sorts.ListType;

/**
 * 
 *
 * @author Kevin Shihora
 * @version 1
 */
public class Sorts
{
    enum ListType {Standard, Bubble, Insert, Selection};
    ListType listType = ListType.Standard;
    
    private int size;
    private int[] list;
    private int[] blist; int bcompares = 0; int bswaps = 0;
    private static int[] ilist; int icompares = 0; int iswaps = 0;
    private static int[] slist; int scompares = 0; int sswaps = 0;
    private static ArrayList<Integer> sortedDexNum = new ArrayList<Integer>();
    private static ArrayList<Pokemon> finalArrayList = new ArrayList<Pokemon>();

    /**
     * Constructor for objects of class isort
     */
    public Sorts()
    {
    	size = PokeArrayList.ArrayList().size();
        list = new int[size];
        for (int i = 0; i < size; i++)
        {
            list[i] = PokeArrayList.ArrayList().get(i);
        }
            
        blist = list.clone();
        this.BubbleSort();
        ilist = list.clone();
        this.InsertionSort();
        slist = list.clone();
        this.SelectionSort();
    }
    
    public String toString() {
        int[] list;
        
        switch(listType) {
            case Standard:
                System.out.println("Original List");
                list = this.list;
                break;
            case Bubble:
                System.out.println("Bubble Sort -- "
                  + " Operations: " + (this.bcompares + this.bswaps)
                  + " Compares: " + this.bcompares
                  + " Swaps: " + this.bswaps);
                list = this.blist;
                break;
            case Insert:
                System.out.println("Insertions Sort -- "
                        + " Operations: " + (this.icompares + this.iswaps)
                        + " Compares: " + this.icompares
                        + " Swaps: " + this.iswaps);
                      list = this.ilist;
                      break;
            default:
                System.out.println("Selection Sort -- "
                        + " Operations: " + (this.scompares + this.sswaps)
                        + " Compares: " + this.scompares
                        + " Swaps: " + this.sswaps);
                      list = this.slist;
                      break;

        }
                
        String output = "[";
        for (int i = 0; i < list.length; i++)
            output += " " + list[i];
        return output +" ]";    
    }
    
    private int[] BubbleSort() { 
        
        // iterate list, one less than length
        for (int i = 0; i < blist.length - 1; i++) {
            
            // bubble sort key logic
            for (int k = 1; k < blist.length - i; k++) {
                
                // analytics
                this.bcompares++; // compare counter
                
                // bubble sort swap logic
                if (blist[k-1] > blist[k]) {
                    int swap = blist[k];
                    blist[k] = blist[k-1];
                    blist[k-1] = swap;
               
                    // analytics
                    this.bswaps++; // swap counter
                }
            
            }
            
        }
        return blist;
    }

    
    private int[] InsertionSort() {

        // iterate list, one less than length
        for (int i = 0; i < ilist.length - 1; i++) {
            
            // insertion sort key logic
            int k = i + 1;
            int swap = ilist[k];            
            while( k > 0 && swap < ilist[k-1]) {
                ilist[k] = ilist[k-1];
                k--;
                
                // analytics
                this.icompares++; // compare counter
                this.iswaps++; // shift counter
            }
            ilist[k] = swap;
            
            this.iswaps++;  // increment swap counter
            
        }
 
        return ilist;
        
     
    }
    
    //Add selection sort 
    
    private int[] SelectionSort() {
    	
    	for (int i = 0; i < slist.length - 1; i++) {
    		
            int k = i; 
            for (int j = i+1; j < slist.length; j++) 
                if (slist[j] < slist[k]) 
                    k = j; 
  
            // Swap the found minimum element with the first 
            // element 
            int swap = slist[k]; 
            slist[k] = slist[i]; 
            slist[i] = swap;
            
            this.icompares++; // compare counter
            this.iswaps++; // shift counter
    	}
            return slist;
    	
    	
    }
    
    public static ArrayList<Pokemon> convert(ArrayList<Integer> arr)
    {
		for(int j = 0; j < arr.size(); j++)
		{
			for(Pokemon x : PokeArrayList.pokeArray)
			{
				if(x.pokeDexNum == arr.get(j))
				{
					finalArrayList.add(x);
				}
			}
		}
		
		return finalArrayList;
    
    }


    /**
     *
     */
    public static void main(String[] args)
    {
        // Original List
        Sorts is = new Sorts(); //populates PokeArray in PokeArrayList
        System.out.println(is);
        
        // Bubble Sort
        is.listType = ListType.Bubble;
        System.out.println(is);
        
        // Insertion Sort
        is.listType = ListType.Insert;
        System.out.println(is);
        
        //Selection Sort
        is.listType = ListType.Selection;
        System.out.println(is);
        
        for (int i = 0; i < ilist.length; i++)
        {
        	sortedDexNum.add(ilist[i]);
        }
       
        finalArrayList = convert(sortedDexNum); //finalArrayList is the sorted Pokemon 
        System.out.print(finalArrayList); 
     
    }
}

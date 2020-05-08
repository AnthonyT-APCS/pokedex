package model;

import java.util.ArrayList;

public class CircleQueueAL {
	
	//Initializes an ArrayList and int for the index of the current object
	ArrayList<Object> arrayList = new ArrayList<Object>();
	int indexOfCurrentObject = 0;

	//Adds an object to the end of the ArrayList
	public void add(Object opaqueObject) {
		arrayList.add(opaqueObject);
	    }
	
	//Deletes an object from the front of the ArrayList
	public Object delete() {
		Object deletedObject = null;
		if(arrayList.size() != 0) {
			deletedObject = arrayList.get(0);
		}
		return deletedObject;
	}
	
	//Returns the current object
	public Object getObject()  {
	    if (arrayList.size() == 0) {
	  	  return null;
	    }
	  	else {
	  		  return arrayList.get(indexOfCurrentObject);
	  	}
	  }
	
	//Returns the first object
	public Object getFirstObject() {
			Object firstObject;
			if(arrayList.size() == 0) {
				firstObject = null;
			}
			else {
				firstObject = arrayList.get(0);
			}
	    	return firstObject;
	  }
	 
	// Returns the last object
	  public Object getLastObject() {
		  int indexOfLastObject = arrayList.size()-1;
		  Object lastObject;
		  if(arrayList.size() == 0) {
			  lastObject = null;
		  }
		  else {
			  lastObject = arrayList.get(indexOfLastObject);
		  }
		  return lastObject;
	  }
	  
	  //Moves to the next object in the list
	  public void setNext() {
		  int highestIndex = arrayList.size() - 1;
		  if(indexOfCurrentObject != highestIndex) {
			  indexOfCurrentObject++;
		  }
		  else {
			  indexOfCurrentObject = 0;
			  System.out.println("You have reached the end of the ArrayList. The current index has now returned to 0");
		  }
	  }
	  
	  //Moves to the previous object in the list
	  public void setPrevious() {
		  	if(indexOfCurrentObject != 0) {
		  		indexOfCurrentObject--;
		  	}
		  	else {
		  		indexOfCurrentObject = arrayList.size() - 1;
		  		System.out.println("You have reached the front of the arrayList. The current index is now " + indexOfCurrentObject);
		  	}
	  }
	  
	  //Prints the ArrayList
	  public String toString() {
		  String printAL = "";
		  for(int i = 0; i < arrayList.size(); i++) {
			  printAL = printAL + "arrayList.get(i)" + ", ";
		  }
		  return printAL;
	  }
	  
	  //Insertion sort
	  public void insertionSort() {
		  ArrayList<Object> aList = arrayList;
			 int i = aList.size(), ind = 1;
			 String hold = aList.get(0).toString();
			 int temp = ind - 1;
			  for(ind = 1; ind < i; ind++) {
				 hold = aList.get(ind).toString();
				 temp = ind - 1;
				 while(temp >= 0 && aList.get(temp).toString().compareTo(hold) > 0) {
					 aList.set(temp + 1, aList.get(temp));
					 temp--;
				 }
				 aList.set(temp+1, hold);
		    }
	  }
}


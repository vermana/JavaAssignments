package com.syne.assign;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ConcurrentModification {

	public static void main(String[] args) {

		List<String> listOfFruits = new ArrayList<String>(Arrays.asList( "Apple", "orange", "Banana", "grapes", "watermelon")); 
		System.out.println("list of fruits: " + listOfFruits); 
		// Iterating and removing objects from list // This is wrong way, will throw ConcurrentModificationException 
		
		for(String fruit : listOfFruits){ 
		if(fruit.startsWith("Ban"))
		
		{
			// If uncommented will throw exception 
			
	    //listOfFruits.remove(fruit);    
		}
		
		} 
			
		
		
		//********************** RIGHT WAY TO REMOVE 
		
		 for(Iterator<String> itr = listOfFruits.iterator(); itr.hasNext();) 
		 {
			 String phone = itr.next();   
			 if(phone.startsWith("iPhone")){
				 itr.remove(); // right way
			   }
	        }
			 
	     System.out.println("list after removal: " + listOfFruits);	 
			 
			 
		
		
		
		
		
		
		
		
		

	}

}

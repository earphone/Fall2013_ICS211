/*
 * Assignment:		Homework 3
 * File:		ArraySearch
 * Author:		Brandon Higashi
 * Date:		September 14, 2013
 * Mod:			September 17, 2013
 * Description:
 * 	This class provies methods in order to search for either an element
 * 	or the first duplicates in a given array.
 */

import java.util.*;

public class ArraySearch<E> {

	// Set debug to true to see all comparisions
	private boolean debug = false;

	// This method searches through an array (haystack) for an element
	// (needle) and returns the index of the first match
	public int find(E [] haystack, E needle) {
		boolean found = false;
		int index = 0;
		for(int i = 0; found == false && i < haystack.length; i++) {
			if(debug == true) System.out.println("Find:		Comparing '" + needle + "' with '" + haystack[i] + "'");
			if(needle.equals(haystack[i])) {
				index = i;
				found = true;
			}
		}
		if(found == false) {
			// Create a resource bundle that can be used to
			// throw a MissingResourceException
		    try {
			ResourceBundle bundle = ResourceBundle.getBundle("fake");
		    }
		    catch(MissingResourceException e) {
			    System.out.println("Threw MissingResourceException");
		    }
			return -1;
		}
		else {
			return index;
		}
	}

	// This method searches a given array for duplicate elements
	// If there are duplicates then returns the index of the first duplicate
	// If all elements are unique then returns -1
	public int first_duplicate (E [] data) {
		for(int i = 0; i < data.length; i++) {
			for(int j = 0; j < data.length; j++) {
				// Skip check if same index
				if(i != j) {
					if(debug == true) System.out.println("Duplicate:	Comparing '" + data[i] + "' with '" + data[j] + "'");
					if(data[i] == data[j]) {
						return i;
					}
				}
			}
		}
		// Return -1 if no duplicates found
		return -1;	
	}
}

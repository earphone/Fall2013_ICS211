/*
 * Assignment:		Homework 3
 * File:		hmwk3test
 * Author:		Brandon Higashi
 * Date:		September 14, 2013
 * Mod:			September 17, 2013
 * Description:
 * 	This is test class for homework 3 that includes the main method
 * 	which tests the ArraySearch clas
 */

public class hmwk3test {
	// Invoked when first run
	public static void main (String [] arguments) {
		// If there is a command line input then exit program
		if(arguments.length != 0) {
			System.out.println("Expecting no inputs, got " + arguments.length + " . . . Exiting");
			System.exit(1);
		}

		System.out.println("Beginning testing . . .");

		Integer numbers [] = {0,1,2,3,4,5,6};
		Integer numbersDupe [] = {0,1,2,3,4,5,5,6};
		String strings[] = {"Hello", "There", "Human"};
		String stringsDupe [] = {"This", "Has", "A", "Duplicate", "Duplicate"};
		ArraySearch<Integer> intSearch = new ArraySearch<Integer>();
		ArraySearch<String> stringSearch = new ArraySearch<String>();

		System.out.println("Test to find 1");
		int found1 = intSearch.find(numbers, 1);
		System.out.println("Found at " + found1);
		System.out.println("Test to find 5");
		int found2 = intSearch.find(numbers, 5);
		System.out.println("Found at " + found2);
		System.out.println("Test to find 'Human'");
		int foundA = stringSearch.find(strings, "Human");
		System.out.println("Found at " + foundA);
		System.out.println("Test to find duplicate where there isnt");
		int found3 = intSearch.first_duplicate(numbers);
		System.out.println("Found at " + found3);
		System.out.println("Test to find duplicate at indexes 5 and 6");
		int found4 = intSearch.first_duplicate(numbersDupe);
		System.out.println("Found at " + found4);
		System.out.println("Test to find duplicate at indexes 4 and 4");
		int foundB = stringSearch.first_duplicate(stringsDupe);
		System.out.println("Found at " + foundB);
		System.out.println("Test to throw MissingResourceException");
		int foundEx = intSearch.find(numbers, 69);
		System.out.println("Found at " + foundEx);
		System.out.println("Finished testing . . . Exiting");
		System.exit(1);
	}
}

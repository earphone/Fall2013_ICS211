/*
 * Assignment:		Homework 1
 * File:		higashiHelloJava
 * Author:		Brandon Higashi
 * Date:		August 29, 2013
 * Mod:			August 29, 2013
 * Description:
 * 	Reviews the basics of java as well as catching exceptions in order to 
 * 	get an integer from user that corresponds to a letter of the alphabet.
 * 	This letter is then printed followed by the alphabet then the number of
 * 	non-vowel strings.
 */

import java.util.*;
import java.io.*;
import java.util.Scanner;

public class higashiHelloJava {
	// Invoked when first run
	public static void main (String [] arguments) {
		// If there is a command line input then exit program.
		if(arguments.length != 0) {
			System.out.println("Expecting no command-line arguments, got " + arguments.length + " . . . Exiting");
			System.exit(1);
		}

		// Array of the alphabet in all lowercase
		final String alpha [] = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"}; 

		// Ask user to input a number	
		System.out.println("Please input the integer corresponding to a letter of the alphabet - 1");
		System.out.println("Ex. 0 is a, 1 is b etc.");

		// Use scanner to get number and assign it to userNum then print it
		Scanner sc = null;
		sc = new Scanner(System.in);
		int userNum = 0;
	    	try {
			userNum = sc.nextInt();
		} catch(InputMismatchException ex) {
			System.out.println("User input was not a number . . . Exiting");
			System.exit(1);
		}
		if(userNum > 25) {
			System.out.println("User input larger than alphabet . . . Exiting");
			System.exit(1);
		}
		if(userNum < 0) {
			System.out.println("User input less than 0 . . . Exiting");
			System.exit(1);
		}
		// Print the users choice
		System.out.print(alpha[userNum]);
		// Create a new 27 item array with a space in the first slot
		String newArray [] = new String[27];
		newArray[0] = " ";
		// Copy the alphabet from alpha to newArray starting from slot 1
		System.arraycopy(alpha, 0, newArray, 1, 26);
		// Print out the new array substituting all vowels for their uppercase
		// Also keep track of the number of non-vowels in count
		int  count = 0;
		if(userNum != 0 && userNum != 4 && userNum != 8 && userNum != 14 && userNum != 20) {
			count += 1;
		}
		for(int i = 0; i < newArray.length; i++) {
			switch (i) {
				case 1: 	System.out.print("A");
					  	break;
				case 5: 	System.out.print("E");
					  	break;
				case 9: 	System.out.print("I");
					  	break;
				case 15: 	System.out.print("O");
					  	break;
				case 21:	System.out.print("U");
					 	break;
				case 0:	System.out.print(" ");
						break;
				default:	System.out.print(newArray[i]);
						count += 1;
						break;
			}
		}
		// Print the number of non-vowels
		System.out.println(" " + count);
	}
}

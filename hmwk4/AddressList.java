/*
 * Assignment: 		Homework 4
 * File: 		AddressList
 * Author:		Brandon Higashi
 * Date:		September 24, 2013
 * Mod:			September 24, 2013
 * Description:
 * 	Testing only class that mimics an address book by command line
 * 	interaction.
 */

import java.io.*;
import java.util.*;

public class AddressList {
	// Invoked when first fun
	public static void main (String [] arguments) {
		if(arguments.length != 0) {
			System.out.println("Expecting no inputs, got " + arguments.length + " . . . Exiting");
			System.exit(1);
		}

		System.out.println("Starting program, empty address book.");

		boolean cont = true;
		Scanner sc = null;
		sc = new Scanner(System.in);
		String input;
		OrderedLinkedList<String> book = new OrderedLinkedList();

		while(cont) {
			// Ask for command
			System.out.print("What do you want to do? (add, find, print, quit): ");

			// Use scanner to get input of command
			input = sc.next();
			sc.nextLine();
			Commands command = Commands.valueOf(input.toUpperCase());
			switch(command) {
				case ADD:	System.out.print("Enter name to add. ");
						String key = sc.nextLine();
						//sc.nextLine();
						System.out.print("Enter telephone number for '" + key + "'. ");
						String value = sc.next();
						String succeed = book.add(key,value);
						if(succeed == null) {
							System.out.println("\n'" + key + "' added to telephone book, with number " + value + "\n");
						}
						else {
							System.out.println("\n'" + key + "' added to telephone book, with number " + value);
							System.out.println("Previous phone number for '" + key + "' was " + succeed + ".\n");
						}
						break;
				case FIND:	
						break;
				case PRINT:	
						break;
				case QUIT:	cont = false;
						return;
				default:	System.out.println(input + " is not recognized");
						break;
			}
			switch(book.size()) {
				case 0:		System.out.println("This address book is empty.");
						break;
				case 1:		System.out.println("This address book has one entry.");
						break;
				default:	System.out.println("This address book has " + book.size() + " entries.");
						break;
			}
		}
	}
	
	public enum Commands {
		ADD,
		FIND,
		PRINT,
		QUIT
	}
}	

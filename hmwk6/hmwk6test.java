/*
 * Assignment: 	Homework 6
 * File:	hmwk6test
 * Author:	Brandon Higashi
 * Date:	October 15, 2013
 * Mod:		October 15, 2013
 * Description:
 * 	This class provides an interfaces for the calculator class
 */

import java.util.*;

public class hmwk6test {
	public static void main(String [] arguments) {
		if(arguments.length != 0) {	
			System.out.println("Expecting no command-line arguments, got " + arguments.length + " . . . Exiting");
			System.exit(1);
		}

		System.out.println("Make sure to have spaces in between expressions");
		System.out.println("Ex: Calc 2 + 2");
		System.out.println("q to quit");
		Scanner scan = new Scanner(System.in);
		String input;
		Calculator calc = new Calculator();
		while(true) {
			System.out.print("Calc ");
			input = scan.nextLine();
			if(input.equals("q")) break;
			System.out.println(calc.calculate(input));
		}
	}
}


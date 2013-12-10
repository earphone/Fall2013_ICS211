/* 
 * Assignment:		Homework 5
 * File:		hmwk5test
 * Author:		Brandon Higashi
 * Date:		October 10, 2013
 * Mode:		October 10, 2013
 * Description:
 * 	This is the test class for homework 5
 */

import java.util.*;

public class hmwk5test {
	public static void main(String [] arguments) {
		System.out.println("Beginning testing . . .");
		Josephus<Integer> joe = new Josephus();
		LinkedList<Integer> deads = new LinkedList<Integer>();
		deads = joe.testList(10,4,6, true);
		System.out.println("Deads: " + deads.toString());
		System.out.print( "The last one is ");
		joe.view();

		System.out.println();

		Josephus<Integer> joe1 = new Josephus();
		LinkedList<Integer> deads1 = new LinkedList<Integer>();
		deads1 = joe1.testList(7,1,3, true);
		System.out.println("Deads1: " + deads1.toString());
		System.out.print( "The last one is ");
		joe1.view();

		System.out.println();

		Josephus<Integer> joe2 = new Josephus();
		LinkedList<Integer> deads2 = new LinkedList<Integer>();
		deads2 = joe2.testList(10,4,6, false);
		System.out.println("Deads2: " + deads2.toString());
		System.out.print( "The last one is ");
		joe2.view();

		System.out.println();
	}
}	

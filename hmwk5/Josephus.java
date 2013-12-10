/*
 * Assignment:		Homework 5
 * File:		Josephus
 * Author:		Brandon Higashi
 * Date:		October 10, 2013
 * Mod:			October 10, 2013
 * Description:
 * 	This class implements a CurcularDoubleLinkedList in order to provide a
 *	soluction to the Josephus problem.
 */

import java.util.*;
import java.lang.Integer;

public class Josephus<Integer> {
	private CircularDoubleLinkedList<Integer> jose = new CircularDoubleLinkedList();
	// Set debug to true for debugging
	private boolean debug = false;

	// Constructor
	public Josephus() {
		jose = new CircularDoubleLinkedList();
	}

	// This method add a person to the beginning of the group
	public void addPerson(Integer person) {
		jose.add(person);
	}

	// This method adds a person to place index in the group
	public void addPerson(int index, Integer person) {
		jose.add(index, person);
	}

	// This method views the entire group in format:
	// 	[P0,P1,P2,...,PN]
	public void view() {
	    if(debug) {
		System.out.println("Displaying initial group . . .");
	    }
		String out = jose.toString();
		System.out.println(out);
	}

	// This method returns a LinkedList of people in the order they were
	// 	removed from left to right.
	public LinkedList testList(int size, int start, int step, boolean isClockwise) {
		LinkedList<Integer> dead = new LinkedList<Integer>();
		int current = start;
		int count = step;
		if(isClockwise) {
			for(int i = 1;i < size+1;i++) {
			    if(debug) {
				System.out.println("testList adding: " + i);
			    }
			    	jose.add(i);
			}
		}
		if(!isClockwise) {
			for(int i = size;i > 0;i--) {
			    if(debug) {
				System.out.println("testList adding: " + i);
			    }
			    	jose.add(i);
			}
		}
		System.out.print("Initial group: ");
		view();
		while(true) {
			if(jose.size() == 1) break;
			for(count = step; count > 0; count--) {
			    if(debug) {
				System.out.println("Step: " + current + " Current count: " + count);
			    }
				if(current < jose.size()) {
					current++;
				}
				else {
					current = 1;
				}
			}
			current--;
		    if(debug) {
			System.out.println("Removing: " + (current-2));
		    }
		    	if(current-1 == -1) dead.add(jose.remove(jose.size()-1));
			else if(current-1 == -2) dead.add(jose.remove(jose.size()-2));
			else dead.add(jose.remove(current-1));
		}
		return dead;
	}
}

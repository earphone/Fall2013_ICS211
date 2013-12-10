/*
 * Assignment:	Homework 10
 * File:	heap
 * Author:	Brandon Higashi
 * Date:	November 19, 2013
 * Mod:		November 19, 2013
 * Description:
 * 	This is the basic heap class
 */

import java.util.*;

public class heap {
	private boolean debug = false; // Set debug to true for debugging
	private record [] table;
	private int num = 0;	// Number of item in table
	private int size;	// Max number of items table can hold
	private Comparator comp = null;

	// Constructor for heap that take in only initial capacity
	public heap(int init) {
		size = init;
		table = new record[size];
	}

	// Constructor for heap takes in two arguments
	// First argument is initial capacity of heap
	// Second argument is a comparator
	public heap(int init, Comparator comparator) {
		comp = comparator;
		size = init;
		table = new record[size];
	}
	
	// Heapifies the array upward from index with a loop
	private void heapifyUp(int index) {
		int child = index;
		int parent = (child-1)/2;
		int heaped = 0;
		while(parent >= 0 && table[parent].compareTo(table[child]) == -1) {
			record temp = table[parent];
			table[parent] = table[child];
			table[child] = temp;
			child = parent;
			parent = (child-1)/2;
			heaped++;
		}
		if(debug)System.out.print(heaped + " layers heaped\t");
	}

	// Heapifies the array downward from index by recursion
	private void heapifyDown(int index, int heaped) {
		int leftNum = 2*index+1;	// left child
		int rightNum = 2*index+2;	// right child
		record left = null;
		record right = null;
		//this.printHeap();
		if(leftNum <= num) left = table[leftNum];
		if(rightNum <= num) right = table[rightNum];
		record current = table[index];

		if(debug) System.out.println("num: " + num + " index: " + index + " left: " + leftNum + " right: " + rightNum);
		// both children exist
		if(num-1>rightNum) {
			if(debug) System.out.println("current: " + current.compareTo(right) + " " + current.compareTo(left));
			if((current.compareTo(right) > 0) && (current.compareTo(left) > 0)) return;
			else if((right.compareTo(current) > 0) && (right.compareTo(left) > 0)) {
				record temp = right;
				table[rightNum] = current;
				table[index] = temp;
				heapifyDown(rightNum, heaped + 1);
			}
			else if((left.compareTo(current) > 0) && (left.compareTo(right) > 0)) {
				record temp = left;
				table[leftNum] = current;
				table[index] = temp;
				heapifyDown(leftNum, heaped + 1);
			}
		}
		// Only left child exists
		else if(num-1 == rightNum) {
			if(left.compareTo(current) > 0) {
				record temp = left;
				table[leftNum] = current;
				table[index] = temp;
				heapifyDown(leftNum, heaped + 1);
			}
			else return;
		}
		else {
			if(debug)System.out.println(heaped + " layers heaped");
			return;
		}
	}


	// Adds value into heap and heapifies
	public boolean add(record value) {
		if(value == null) throw new NullPointerException("Cannot add null");
		long time = System.nanoTime();
		int heaped = 0;
		if(num == size) {
			if(debug) System.out.println("Increasing size from " + size + " to " + size*2);
			record[] temp = new record[size*2]; 
			for(int i = 0; i < size; i++) {
				temp[i] = table[i];
			}
			table = temp;
			size = size*2;
		}
		table[num] = value;
		heapifyUp(num);
		num++;
		if(debug) System.out.println("Took " + (System.nanoTime()-time) + " to add");
		System.out.print("adding ");
		value.printRecord();
		return true;
	}

	// Removes the head of the heap	and returns it
	public record remove() {
		long time = System.nanoTime();
		record head = table[0];
		if(head == null) return null;
		table[0] = table[num-1];
		table[num-1] = null;
		num--;
		heapifyDown(0, 0);
		time = System.nanoTime() - time;
		if(debug)System.out.println("Took " + time + " to remove");
		return head;
	}

	// Prints the heap
	public void printHeap() {
		if(debug) System.out.println("\nPrinting heap");
		if(num == 0) {
			System.out.println("Nothing here");
			return;
		}
		for(int i = 0; i < num; i++) {
			if(debug)System.out.print("i: " + i + " ");
			table[i].printRecord();
		}
	}

	public int compare(record a, record b) {
		if(comp != null) return comp.compare(a, b);
		else return ((Comparable) a).compareTo(b);	
	}	
}

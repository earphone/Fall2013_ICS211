/*
 * Assignment:	Homework 11
 * File:	Hash211
 * Author:	Brandon Higashi
 * Date:	November 28, 2013
 * Mod:		November 28, 2013
 * Description:
 * 	This is the hash table class
 */

import java.util.*;

public class Hash211 <K,V>{
	
	LinkedList<V> hash = new LinkedList();	// Hash as a linked list
	int size;		// Size of the hash
	boolean print;		// True if printing times
	long time;		// Time used for debugging times

	// Constructor
	// @param capacity Number of elements in the hash
	// @param printTimes Prints the times for each call to put and get
	public Hash211(int capacity, boolean printTimes) {
		size = capacity;
		print = printTimes;
		hash.clear();
		for(int i = 0; i < size; i++) {
			hash.add(null);
		}
	}

	// Puts an object with specific value into the hash with a certain key
	// @param key Key used to determine where in the hash the value goes
	// @param value Value that is stored in the hash
	// @return The previous value from the key in the hash or null if none
	// 	was there
	public V put(K key, V value) {
		if(print) time = System.nanoTime();
		int hKey = key.hashCode();
		int index = Math.abs(hKey)%size;
		V temp = hash.set(index, value);
		if(print) System.out.println("Took " + (System.nanoTime() - time) + " to add to hash");
		return temp;
	}

	// Gets an object with a specific key and returns the value there
	// @param key Key used to get value from hash
	// @return Value from given key or null if nothing was there
	public V get(K key) {
		if(print) time = System.nanoTime();
		int hKey = key.hashCode();
		int index = Math.abs(hKey)%size;
		V temp = hash.get(index);
		if(print) System.out.println("Took " + (System.nanoTime() - time) + " to get from hash");
		return temp;
	}
}

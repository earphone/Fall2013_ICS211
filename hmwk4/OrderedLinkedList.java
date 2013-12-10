/*
 * Assignment:		Homework 4
 * File:		OrderedLinkedList
 * Author:		Brandon Higashi
 * Date:		September 19, 2013
 * Mod:			September 24, 2013
 * Description:
 * 	This class provides methods in order to create and get values from a
 * 	linked list class that is kept in order of increasing key value.
 *
 * 	Currently editing add
 */

import java.util.*;

public class OrderedLinkedList<T> {
	
	// The following is the definition for a KeyedNode
	private static class KeyedNode<T> {
		private T object;
		private String key;
		private KeyedNode<T> next;
	
		// Constructor for a new node that has no next node
		private KeyedNode(T objectValue, String keyValue) {
			object = objectValue;
			key = keyValue;
			next = null;
		}
	
		// Constructor for a new node with a reference to another
		private KeyedNode(T objectValue, String keyValue, KeyedNode<T> reference) {
			object = objectValue;
			key = keyValue;
			next = reference;
		}
	}
	// End of KeyedNode definition
	
	
	// Head is the beginning element of the list while tail is the last
	// element in the list. Size is the number of elements in the list
	// from head to tail.
	private KeyedNode<T> head;
	private KeyedNode<T> tail;
	private int size;

	// Argument-free constructor
	public OrderedLinkedList() {
		head = null;
		tail = null;
		size = 0;
	}

	// Returns size of the list
	public int size() {
		return size;
	}

	// Add method given a key and object.
	// Returns null if no such key already in existence
	// If key exists repleces old object with new and returns old object
	public T add(String key, T value) {
		// If empty list, create new node and set head and tail to 
		// it and return null.
		if(size == 0) {
			head = new KeyedNode(value, key);
			head = tail;
			size = size + 1;;
			return null;
		}
		// Use find to test if key is already in list
		// If so then set that key's object to new value and return old
		// object.
		// If not then add in order and return null
		else if(size != 0) {
			KeyedNode<T> temp = head;
			KeyedNode<T> previous = head;
			for(int i = 0; i < size; i++) {
				System.out.println("i: " + i);
				// If key and node key are equal
				if(key.compareToIgnoreCase(temp.key) == 0) {
					T returnObject = temp.object;
					temp.key = key;
					size = size + 1;
					return returnObject;
				}
				// key is greater than temp.key
				else if(key.compareToIgnoreCase(temp.key) < 0) {
					previous = temp;
					temp = temp.next;
				}
				// key is less than temp.key
				else {
					if(i==size-1) {
						tail.next = new KeyedNode(value, key);
						size = size + 1;
					}
					else {
						previous.next = new KeyedNode(value, key, temp);
						size = size + 1;
					}
					return null;
				}
			}
		}
		return null;
	}
	
	// Finds key within the list.
	// Returns null if no such key.
	// If key exists, then returns the key's object.
	public T find(String key) {
		// Return null if empty list.
		if(this.size() == 0) {
			return null;
		}
		KeyedNode<T> temp = head;
		for(int i = 0; i < size; i++) {
			// If key found return object
			if(key.compareToIgnoreCase(temp.key) == 0) {
				return temp.object;
			}
			temp = temp.next;
		}
		// No matching key found
		return null;
	}

	// Returns object of node at a specified position
	// Returns null if no such position
	public T get(int position) {
		if(position >= size) {
			return null;
		}
		KeyedNode<T> temp = head;
		for(int i = 0; i < position; i++) {
			if(i == position) {
				return temp.object;
			}
			temp = temp.next;
		}
		return null;
	}
}


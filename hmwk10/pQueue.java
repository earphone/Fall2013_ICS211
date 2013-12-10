/*
 * Assignment:	Homework 10
 * File:	pQueue
 * Author:	Brandon Higashi
 * Date:	November 20, 2013
 * Mod:		November 22, 2013
 * Description:
 * 	This is the basic priority queue class
 */

import java.util.*;

public class pQueue<E> {
	private boolean debug = true;	// Set debug to true for debugging
	private heap queue;

	// Constructor for priority queue with only initial capacity
	public pQueue(int init) {
		queue = new heap(init);
	}

	// Constructor for priority queue takes in two arguments
	// First argument is initial capacity of queue
	// Second argument is a comparator
	public pQueue(int init, Comparator comp) {
		queue = new heap(init, comp);
	}

	// Offer method allows for new items appended to the queue
	public boolean offer(record item) {
		return queue.add(item);
	}

	// Poll method removes the first item from the queue and returns it
	public record poll() {
		return queue.remove();
	}

	// print method prints queue
	public void printQueue() {
		queue.printHeap();
	}
}

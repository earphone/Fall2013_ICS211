/*
 * Assignment:	Homework 7
 * File:	ArrayQueue
 * Author:	Brandon Higashi
 * Date:	October 22, 2013
 * Mod:		October 23, 2013
 * Description:
 * 	This is a generic queue that is implemented with a size 10 array
 */

public class ArrayQueue {

	private Object[] queue = new Object[10];
	private int current = 0;
	private int end = 0;
	private int count = 0;

	// Constructor for LinkedQueue
	public ArrayQueue() {
		queue = new Object[10];
	}

	// Offer tries to insert a value into the queue
	// Returns true if the insertions succeeds
	// Returns false if value is null or queue is full
	public boolean offer(Object value) {
		if(value == null) return false;
		if(count == 10) return false;
		for(int i=0;i<9;i++) {
			if(value.equals(queue[i])) return false;
		}
		queue[end] = value;
		if(end==9) end = 0;
		else end++;
		count++;
		return true;
	}

	// Poll method returns the first object, or null if there are none
	public Object poll() {
		if(count==0) return null;
		Object temp = queue[current];
		queue[current] = null;
		if(current==9) current = 0;
		else current ++;
		count--;
		return temp;
	}
}

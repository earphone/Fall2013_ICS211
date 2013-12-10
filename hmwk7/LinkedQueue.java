/*
 * Assignment:	Homework 7
 * File:	LinkedQueue
 * Author:	Brandon Higashi
 * Date:	October 21, 2013
 * Mod:		October 22, 2013
 * Description:
 *	This is a generic queue that is implemented using a linked list.
 */

public class LinkedQueue {
	private LinkedList queue;

	// Constructor for LinkedQueue
	public LinkedQueue() {
		queue = new LinkedList();
	}

	// Offer method takes a value and tries to insert it into the queue
	// Returns true if the insertion succeeds
	public boolean offer(Object value) {
		if(value == null) {
			return false;
		}
		if(queue.check(value)) {
			return false;
		}
		else {
			queue.add(value);	
			return true;
		}
	}

	// Poll method returns the first object, or null if there are none
	public Object poll() {
		if(queue.size()==0) return null;
		Object temp =  queue.get(1);
		if(queue.size()==1) queue = new LinkedList();
		else if(!queue.remove(1)) return null;
		return temp;
	}

	public String toString() {
		return queue.toString();
	}

	public int size() {
		return queue.size();
	}
}

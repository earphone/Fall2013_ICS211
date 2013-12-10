/*
 * Assignment:	Homework 7
 * File:	hmwk7test
 * Author:	Brandon Higashi
 * Date:	October 21, 2013
 * Mod:		October 23, 2013
 * Description:
 * 	This is a simple test class for homework 7
 */

import java.util.*;

public class hmwk7test {
	public static void main(String [] arguments) {
		if(arguments.length != 0) {
			System.out.println("Expecting no command-line arguments, got " + arguments.length + " . . . Exiting");
			System.exit(1);
		}

		LinkedQueue lqueue = new LinkedQueue();
		System.out.println("Polling lqueue: " + lqueue.poll());
		System.out.println("Adding null to lqueue: " + lqueue.offer(null));
		System.out.println("Adding 1 to lqueue: " + lqueue.offer(1));
		System.out.println("Adding 1 to lqueue: " + lqueue.offer(1));
		System.out.println("Adding 2 to lqueue: " + lqueue.offer(2));
		System.out.println("Adding 3 to lqueue: " + lqueue.offer(3));
		System.out.println("Adding 3 to lqueue: " + lqueue.offer(3));	
		System.out.println("Adding 4 to lqueue: " + lqueue.offer(4));
		System.out.println("Polling lqueue: " + lqueue.poll());
		System.out.println("Polling lqueue: " + lqueue.poll());
		System.out.println("Polling lqueue: " + lqueue.poll());
		System.out.println("Polling lqueue: " + lqueue.poll());
		System.out.println("Polling lqueue: " + lqueue.poll());

		ArrayQueue aqueue = new ArrayQueue();
		System.out.println("\nPolling aqueue: " + aqueue.poll());
		System.out.println("Adding null to aqueue: " + aqueue.offer(null));
		System.out.println("Adding 1 to aqueue: " + aqueue.offer(1));
		System.out.println("Adding 1 to aqueue: " + aqueue.offer(1));
		System.out.println("Adding 2 to aqueue: " + aqueue.offer(2));
		System.out.println("Adding 3 to aqueue: " + aqueue.offer(3));
		System.out.println("Adding 3 to aqueue: " + aqueue.offer(3));
		System.out.println("Adding 4 to aqueue: " + aqueue.offer(4));
		System.out.println("Adding 5 to aqueue: " + aqueue.offer(5));
		System.out.println("Adding 6 to aqueue: " + aqueue.offer(6));
		System.out.println("Adding 7 to aqueue: " + aqueue.offer(7));
		System.out.println("Adding 8 to aqueue: " + aqueue.offer(8));
		System.out.println("Adding 9 to aqueue: " + aqueue.offer(9));
		System.out.println("Adding 0 to aqueue: " + aqueue.offer(0));
		System.out.println("Adding 11  to aqueue: " + aqueue.offer(11));
		System.out.println("Polling aqueue: " + aqueue.poll());
		System.out.println("Polling aqueue: " + aqueue.poll());
		System.out.println("Polling aqueue: " + aqueue.poll());
		System.out.println("Polling aqueue: " + aqueue.poll());
		System.out.println("Polling aqueue: " + aqueue.poll());
		System.out.println("Adding 4 to aqueue: " + aqueue.offer(4));
		System.out.println("Polling aqueue: " + aqueue.poll());
		System.out.println("Polling aqueue: " + aqueue.poll());
		System.out.println("Polling aqueue: " + aqueue.poll());
		System.out.println("Polling aqueue: " + aqueue.poll());
		System.out.println("Polling aqueue: " + aqueue.poll());
		System.out.println("Polling aqueue: " + aqueue.poll());
		System.out.println("Polling aqueue: " + aqueue.poll());
				
	}
}

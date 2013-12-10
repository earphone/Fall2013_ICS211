/*
 * Assignment:		Homework 5
 * File:		CircularDoubleLinkedList
 * Author:		Brandon Higashi
 * Date:		October 7, 2013
 * Mod:			October 10, 2013
 * Description:
 * 	This class provides methods and a generic class that implements the
 * 	Iterable iterface. It also creates and get certain methods.
 */

import java.util.*;

public class CircularDoubleLinkedList<T> {

	//true debug to true for debugging
	private boolean debug = false;
// Definition of DoubleLinkedNode
	
    public class DoubleLinkedNode<T> {
        private T item;
        private DoubleLinkedNode<T> previous;
        private DoubleLinkedNode<T> next;
        
        // Constructor without a next or previous node
        public DoubleLinkedNode(T value) {
            item = value;
            next = null;
            previous = null;
        }
        
        // Constructor with specified next and previous nodes
        public DoubleLinkedNode(T value, DoubleLinkedNode<T> previous, DoubleLinkedNode<T> next) {
            item = value;
            this.next = next;
            this.previous = previous;
        }
        
        // Methods to get and set the value of the item
        public T getData() {
            return item;
        }
        
        public void setData(T data) {
            this.item = data;
        }
        
        // Methods to get and set the next node
        public DoubleLinkedNode<T> getNext() {
            return next;
        }
        
        public void setNext(DoubleLinkedNode<T> next) {
            this.next = next;
        }
        
        // Methods to get and set the previous node
        public DoubleLinkedNode<T> getPrevious() {
            return previous;
        }
        
        public void setPrevious(DoubleLinkedNode<T> previous) {
            this.previous = previous;
        }
        
        // Method that overrides the toString method
        public String toString() {
            return item.toString();
        }
    }

// Started of circular linked list
	protected DoubleLinkedNode<T> head;
	// Since circular double linked list, the tail is found by head.previous
	protected int size;

	// Checks assertion
	private void verify(boolean mustBeTrue) {
		if(! mustBeTrue) {
			throw new java.lang.AssertionError("Assertion Error");
		}
	}

	// Invariant checks
	private void invariants() {
		// uncomment the next like to skip all checks
		// return;
		// verfy the if head is null then size is 0
		verify((size==0) == (head==null));
		verify(size >= 0);
		if(size == 0) {
			return;
		}
		// check to make sure the size is the same as the list length
		int measureSize = 0;
		DoubleLinkedNode<T> node = head;
		do {
			node = node.next;
			measureSize++;
		} while(node != head);
		verify(measureSize == size);
	}

	// Constructor for an empty list
	public CircularDoubleLinkedList(){
		head = null;
		size = 0;
		invariants();
	}

	public void add(int data) {
		DoubleLinkedNode<T> newDNode = new DoubleLinkedNode(data);
		if(head == null) {
			head = newDNode;
			newDNode.setPrevious(head);
			newDNode.setNext(head);
		}
		else {
			DoubleLinkedNode tail = head.getPrevious();
			tail.setNext(newDNode);
			head.setPrevious(newDNode);
			newDNode.setNext(head);
			newDNode.setPrevious(tail);
		}
		size++;
		invariants();
	}

	// Method to add an item to the end of the list
	public void add(T data) {
	    if(debug) {
		System.out.println("CircularDoubleLinkedList: Add: " + data);
	    }
		DoubleLinkedNode<T> newDNode = new DoubleLinkedNode<T>(data);
		if(head == null) {
			head = newDNode;
			newDNode.setPrevious(head);
			newDNode.setNext(head);
		}
		else {
			DoubleLinkedNode tail = head.getPrevious();
			tail.setNext(newDNode);
			head.setPrevious(newDNode);
			newDNode.setNext(head);
			newDNode.setPrevious(tail);
		}
		size++;
		invariants();
	}

	// Method to add an item to the specified index
	public void add(int index, T data) {
		DoubleLinkedNode<T> newDNode = new DoubleLinkedNode(data);
		DoubleLinkedNode<T> node = head;
		while(index > 0) {
			node = node.getNext();
			index--;
		}
		if(index == 0) {
			DoubleLinkedNode<T> last = node.getPrevious();
			last.setNext(newDNode);
			node.setPrevious(newDNode);
			newDNode.setNext(node);
			newDNode.setPrevious(last);
		}
		size++;
		invariants();
	}

	// Method that returns the data stored at the specified index
	public T get(int index) {
		verify(index >= 0);
		DoubleLinkedNode<T> result = head;
		while(index > 0) {
			result = result.getNext();
			index--;
		}
		verify(result != null);
		return result.getData();
	}

	private DoubleLinkedNode<T> nodeAtPosition(int index) {
		verify(index >= 0);
		DoubleLinkedNode<T> result = head;
		while(index > 0) {
			result = result.next;
			index--;
		}
		verify(result != null);
		return result;
	}

	// Method that removes and returns an item from the list
	public T remove(int index) {
		// Check to make sure index is within boundaries
		if ((index < 0) || (index >= size)) {
			String badIndex = new String ("index " + index + " must be between 0 and " + (size - 1));
			throw new IndexOutOfBoundsException(badIndex);
		}
		// Head cannot be null if there is something to remove
		verify(head != null);
		T item = head.item;
		if(size == 1) {
			head = null;
		}
		else {
			DoubleLinkedNode<T> node = nodeAtPosition(index);
			item = node.item;
			if(index == 0) {
				head= node.next;
			}
			node.getPrevious().setNext(node.getNext());
			node.getNext().setPrevious(node.getPrevious());
		}
		size--;
		invariants();
		return item;
	}

	// Method that returns the size of the list
	public int size() {
		return size;
	}

	// Method that overrides the toString and returns a String of all
	// 	values V from teh front to end in the following format:
	// 	[V0,V1,V2,V,V,...,VN]
	public String toString() {
	    if(debug) {
		System.out.println("Before invariants");
	    }
		invariants();
	    if(debug) {
		System.out.println("After invariants");
	    }
		DoubleLinkedNode<T> node = head;
		StringBuffer result = new StringBuffer();
		if(head != null) {
			while(true) {
				result.append(node.item.toString());
			    if(debug) {
				System.out.println("Appending: " + node.item.toString());
			    }
				node = node.next;
				if(node == head) {
					break;
				}
				result.append(",");
			}
		}
		invariants();
		return result.toString();
	}

// CircularDoubleIterator class starts here
	private class CircularDoubleIterator  {
		private DoubleLinkedNode<T> current;
		
		// Constructor sets current to head
		private CircularDoubleIterator() {
			current = head;
		}		
		
		public boolean hasNext() {
			return (current.next != head);
		}

		public boolean hasPrevious() {
			return (current.previous != head);
		}

		public T next() {
			if(hasNext()) {
				T result = current.item;
				current = current.next;
				return result;
			}
			throw new java.util.NoSuchElementException("Circular list.next");
		}

		public T previous() {
			if(hasPrevious()) {
				T result = current.item;
				current = current.previous;
				return result;
			}
			throw new java.util.NoSuchElementException("Circular list.previous");
		}
		
	}
}	

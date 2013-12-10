/*
 * Assignment:	Homework 7
 * File:	LinkedList
 * Author:	Brandon Higashi
 * Date:	October 21, 2013
 * Mod:		October 21, 2013
 * Description:
 * 	This is a generic linked list class
 */

public class LinkedList {
	private Node head;
	private Node tail;
	private int count;

	// Constructor for empty list
	public LinkedList() {
		head = new Node(null);
		count = 0;
	}

	public void add(Object data) {
		Node temp = new Node(data);
		Node current = head;
		while(current.getNext() != null) {
			current = current.getNext();
		}
		current.setNext(temp);
		count++;
	}

	public void add(Object data, int index) {
		Node temp = new Node(data);
		Node current = head.getNext();
		for(int i = 1; i < index && current.getNext() != null; i++) {
			current = current.getNext();
		}
		temp.setNext(current.getNext());
		current.setNext(temp);
		count++;
	}

	public boolean check(Object data) {
		if(count == 0) return false;
		Node current = head;
		while(current.getNext() != null) {
			if(data.equals(current.getData())) return true;
			current = current.getNext();
		}
		return (data.equals(current.getData()));
	}

	public Object get(int index) {
		if(index <= 0) return null;
		Node current = head.getNext();
		for(int i = 1; i < index; i++) {
			if(current.getNext() == null) return null;
			current = current.getNext();
		}
		return current.getData();
	}

	public boolean remove(int index) {
		if(index < 1 || index > size()) return false;
		Node current = head;
		for(int i = 1; i < index; i ++) {
			if(current.getNext() == null) return false;
			current = current.getNext();
		}
		if(count==2) {
			if(index==1) head = current;
			else head.setNext(null);
		}
		current.setNext(current.getNext().getNext());
		count--;
		return true;
	}

	public int size() {
		return count;
	}

	private class Node {
		Node next;
		Object data;

		// Constructor for Node
		public Node(Object thisData) {
			data = thisData;
			next = null;
		}

		// Constructor for Node with a pointer to a new Node
		public Node(Object thisData, Node nextNode) {
			data = thisData;
			next = nextNode;
		}

		public Object getData() {
			return data;
		}

		public void setData(Object thisData) {
			data = thisData;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node nextNode) {
			next = nextNode;
		}
	}
}


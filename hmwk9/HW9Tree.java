/*
 * Assignment:	Homework 9
 * File:	HW9Tree
 * Author:	Brandon Higashi
 * Date:	November 2, 2013
 * Mod:		November 2, 2013
 * Description:
 * 	Converts a binary tree into a List or a String
 */

import java.util.*;

public class HW9Tree <E>{

	private BinaryNode<E> root;

	public HW9Tree () {
		root = null;
	}



	private static class BinaryNode<E> {
		private E item;
		private BinaryNode<E> left;
		private BinaryNode<E> right;

		// Constructor to build a node without subtrees
		private BinaryNode(E value) {
			item = value;
			left = null;
			right = null;
		}

		// Constructor to build a node with a specified (perhaps null)
		// subtree
		private BinaryNode(E value, BinaryNode<E> l, BinaryNode<E> r) {
			item = value;
			left = l;
			right = r;
		}
	}

	// Add method adds values to the tree
	public boolean add(E item, boolean [] left) {
		if(root == null) {
			root = new BinaryNode<E>(item);
			return true;
		}
		BinaryNode<E> current = root;
		for(int i = 0; i < left.length; i ++) {
			if(left[i]) {
				if(current.left == null) {
					current.left = new BinaryNode<E>(item);
					return true;
				}
					current = current.left;
			}
			else {
				if(current.right == null) {
					current.right = new BinaryNode<E>(item);
					return true;
				}
				current = current.right;
			}
		}
		throw new java.lang.ArrayIndexOutOfBoundsException("Boolean array is too short");
	}

	// toList method stores s reference to each of the tree's
	// objects in a List
	public List <E> toList() {
		List<E> tree = new ArrayList();
		return toList(root, tree);
	}

	protected List <E> toList(BinaryNode<E> node, List tree) {
		if(node == null) return tree;
		toList(node.left, tree);
		tree.add(node.item);
		toList(node.right, tree);
		return tree;
	}

	// toString method converts the tree to a string
	public String toString() {
		return toString(root, "");
	}

	protected String toString(BinaryNode<E> node, String space) {
		if(node == null) return "";
		String addedSpace = space + "    ";
		return space + node.item.toString() + "\n" +  toString(node.left,addedSpace) + toString(node.right,addedSpace);
	}	

}

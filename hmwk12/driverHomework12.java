/*
 * Assignment:	Homework 12
 * File:	driverHomework12
 * Author:	Brandon Higashi
 * Date:	December 06, 2013
 * Mod:		December 06, 2013
 * Description:
 * 	This is the main driver class for Homework 10
 * 	Reads in a .huff file name, decodes it and outputs to a the file name
 * 	minus the .huff
 * 	If new file name already exists, prompts user if should overwrite
 * 	If not a valid .huff exits
 */

import java.util.*;
import java.io.*;

public class driverHomework12 {

	private static boolean debug = false;	// Set to true to see debugging

	public static void main(String[] args) {
		if(args.length != 1) {
			System.out.println("Error: No filename given");
			System.out.println("Usage: java driverHomework12 filename");
			System.exit(1);
		}
		try {
			decompress(args[0]);	
		} catch(IOException e) {
			System.out.println("Could not read file: " + e.getMessage());
		}
	}
	
	// Renames the file and checks if it is a valid .huff
	// Produces the output filename by taking off the .huff from given file
	// Sends the Input and Output filestreams to decompress
	public static void decompress(String filename) throws IOException {
		log(filename);
		log(filename.substring(filename.lastIndexOf("."), filename.length()));
		if(filename.length()<5 || !filename.substring(filename.lastIndexOf("."), filename.length()).equals(".huff")) {
			System.out.println("Error: Not a valid name");
			System.out.println("Usage: java driverHomework12 filename");
			System.exit(1);
		}
		BufferedInputStream filein = new BufferedInputStream( new FileInputStream(filename));
		DataOutputStream fileout = new DataOutputStream(new FileOutputStream(filename.substring(0,filename.lastIndexOf("."))));
		try {
			decompress(filein,fileout);
		} finally {
			filein.close();
			fileout.close();
		}
	}


	// Takes in two file streams and decompresses the Input one and writes
	// it to the Output
	public static void decompress(InputStream in, OutputStream out) throws IOException {
		int count = 0;
		int nextByte = 0;
		StringBuffer end = new StringBuffer();
		StringBuffer ent = new StringBuffer();

		// Get number of bytes in file
		int num = 0;
		int tempNum = 0;
		for(int i = 0; i<4; i++) {
			num = num*16+in.read();
			log(num);
			log(toBinary(num));
		}
		log("Num " + num);

		// Get bytes in file and create a binary char array of all
		for(int h = 0; h < num; h++) {
			nextByte = in.read();
			ent.append(toBinary(nextByte));
		}
		log(ent.toString());
		char[] file = ent.toString().replace(" ","").toCharArray();

		// Create binary tree
		int current = 1;
		Stack<BinaryNode> stack = new Stack();
		BinaryNode root = new BinaryNode(null);
		stack.push(root);
		try {
		while(!stack.empty()) {
			BinaryNode temp = null;
			if(file[current] == '0') {
				temp = new BinaryNode(null);
			}
			else {
				String data = "";
				for(int j = 1;j < 9; j++) {
					data = data + file[current+j];
				}
				current = current + 8;
				log("Node " + data);
				temp = new BinaryNode(data);
				int charcode = Integer.parseInt(data,2);
				log(new Character((char)charcode).toString());
			}
			BinaryNode a = stack.peek();
			if(a.isLeft()) {
				a.setLeft(temp);
			}
			else {
				a.setRight(temp);
				stack.pop();
			}
			if(temp.isEmpty()) stack.push(temp);
			current++;
			log("Current: "+current);
		}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("File is not long enough");
			System.out.println("Exiting . . .");
			System.exit(1);
		}
	
		// Interpret the tree
		int print = 0;
		BinaryNode currentNode = root;
		log("Size of file: " + file.length);
		while(print<num) {
			log(current + " " + file[current]);
			if(file[current] == '0') currentNode = currentNode.getLeft();
			if(file[current] == '1') currentNode = currentNode.getRight();
			if(!currentNode.isEmpty()) {
				log("Adding " + currentNode.getData());
				out.write(Integer.parseInt(currentNode.getData(),2));
				currentNode = root;
				print++;
				log("Print: " +print);
			}
			current++;
		}

		in.close();
		out.close();
	}

	// Prints a value if debugging is on
	public static void log(Object item) {
		if(debug) System.out.println(item.toString());
	}
	
	// Takes in a int input and returns the binary string
	public static String toBinary(int num) {
		log("tobinary getting " + num);
		String binary = Integer.toBinaryString(num);
		while(binary.length()<8) {
			binary = "0" + binary;
		}
		return binary+" ";
	}

	public static class BinaryNode {
		private String item;
		private BinaryNode left;
		private BinaryNode right;
	

		private BinaryNode(String value) {
			item = value;
			left = null;
			right = null;
		}

		private BinaryNode(String value, BinaryNode l, BinaryNode r) {
			item = value;
			left = l;
			right = r;
		}

		public void setLeft(BinaryNode l) {
			left = l;
		}

		public void setRight(BinaryNode r) {
			right = r;
		}

		// Returns the data in node
		public String getData() {
			return item;
		}

		public BinaryNode getLeft() {
			return left;
		}

		public BinaryNode getRight() {
			return right;
		}

		// True if empty
		public boolean isEmpty() {
			if(item!=null) return false;
			else {
				log("Is empty");
				return true;
			}
		}

		// True if no node
		public boolean isLeft() {
			return (left==null);
		}

		// True if no node
		public boolean isRight() {
			return (right==null);
		}
	}
}

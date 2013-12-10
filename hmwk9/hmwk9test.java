/*
 * Assignment:	Homework 9
 * File:	hmkw9test
 * Author:	Brandon HIgashi
 * Date:	November 5, 2013
 * Mod:		November 5, 2013
 * Description:
 * 	The test class for binary tree of Homework 9
 */

public class hmwk9test {
	public static void main(String [] arguments) {

		HW9Tree test = new HW9Tree();
		boolean[] place = {true, true, false};

		test.add(1, place);
//		System.out.println(test.toString());
		test.add(2, place);
//		System.out.println(test.toString());
		test.add(3, place);
		System.out.println(test.toString());

		HW9Tree<String> hello = new HW9Tree();
		boolean[] placed = {true, true};
		hello.add("hello", placed);
		hello.add("foo", placed);
		hello.add("world", placed);
		placed[1] =  false;
		hello.add("baz", placed);
		placed[0] = false; placed[1] =  true;
		hello.add("bar", placed);
		hello.add("bug", placed);
		placed[1] =  false;
		hello.add("loop", placed);

// The following line throws a ArrayIndexOutOfBoundsException	
//		hello.add("fruit", placed);

		boolean [] lefts = {false, true, false};
		hello.add("fun", lefts);
		lefts[2] = true;
		hello.add("fe fi", lefts);
		System.out.println(hello.toString());
		
		for(String value : hello.toList()) {
			System.out.print(value + " ");
		}
		System.out.println();
	}
}

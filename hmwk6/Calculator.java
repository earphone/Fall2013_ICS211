/*
 * Assignment:	Homework 6
 * File:	Calculator
 * Author:	Brandon Higashi
 * Date:	October 15, 2013
 * Mod:		October 15, 2013
 * Description:
 * 	This class implements an infix calulator using the java.util.Stack<E>
 * 	for the following basic operations for floating point numbers:
 * 		+, -, *, /
 * 	* and / have a higher precedence than + and -
 */

import java.util.*;

public class Calculator {
	
	// Stack used
	private Stack operand = new Stack();
	private Stack operators =  new Stack();

	// set debug to true for debugging;
	private boolean debug = false;

	// Constructor
	public Calculator() {
		operand = new Stack();
		operators = new Stack();
	}

	public double calculate(String expression) {
		// Takes each element of the expression and puts them into a
		// string array
		String[] inputs = expression.split(" ");
	    if(debug) {
		System.out.print("Input array: ");
		for(String value : inputs) {
			System.out.print(value + " ");
		}
		System.out.println();
	   }	
		
		// Go through the string array and pop operators onto the
		// operators stack and operands onto the the operands stack
		for(String value : inputs) {
		   if(debug) System.out.println("Evaluating: " + value);
			if(value.equals("*") || value.equals("/") || value.equals("+") || value.equals("-")) {
				// If stack is empty push onto stack
				if(operand.empty()) {
					operand.push(value);
				}
				
				// If new operator is higher than old push onto
				// stack
				else if(value.equals("*") || value.equals("/")) {
					String old = (String)operand.peek();
					if(old.equals("*")) {
						double a = (Double)operators.pop();
						double b = (Double)operators.pop();
					    if(debug) {
						System.out.println(a + old + b);
					    }
					    	a = a*b;
						operators.push(a);
						old = (String)operand.pop();
						operand.push(value);
					}
					else if(old.equals("/")) {
						double a = (Double)operators.pop();
						double b = (Double)operators.pop();
					   if(debug) {
						System.out.println(a + old + b);
					   }
					   	a = b/a;
						operators.push(a);
						old = (String)operand.pop();
						operand.push(value);
					}
					else operand.push(value);
				}

				// Else pop old operator and evaluate top two
				// elements on operand stack then push new
				// operator onto stack
				else {
					double a = (Double)operators.pop();
					double b = (Double)operators.pop();
					String old = (String)operand.pop();
				    if(debug) {
					System.out.println(a + old + b);
				    }
					if(old.equals("*")) a = a*b;
					else if(old.equals("/")) a = b/a;
					else if(old.equals("+")) a = a+b;
					else a = b-a;
					operators.push(a);
					operand.push(value);
				}
			}
			// Put operators into operators stack
			else {
			    try {
				Double num = Double.parseDouble(value);
				operators.push(num);
			    }
			    catch(NumberFormatException e) {
				    System.out.println("NumberFormatException: Something besides a number or operator entered");
			    }
			}
		}
		// Finish up everything left over in stack
		String old;
		double a;
		double b;
		while(!operand.empty()) {
			old = (String)operand.pop();
			a = (Double)operators.pop();
			b = (Double)operators.pop();
			if(old.equals("*")) a = a*b;
			else if(old.equals("/")) a = b/a;
			else if(old.equals("+")) a = a+b;
			else a = b-a;
			operators.push(a);
		}
		return (Double)operators.peek();
	}
}

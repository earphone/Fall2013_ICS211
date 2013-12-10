/*
 * Assignment:		Homework 2
 * File:		Point
 * Author:		Brandon Higashi
 * Date:		September 10, 2013
 * Mod:			September 10, 2013
 * Description:
 * 	This class represents points in a two-dimensional plane.  Each point
 * 	has an x and a y coordinate, determined at creation time.
 */

public class Point {

	// Values for the coordinates X and Y
	private double x, y;
	
	// Sets X and Y when both are given
	public Point(double X, double Y) {
		x = X;
		y = Y;
	}

	// Set X and Y to 0 when no arguments are given
	public Point() {
		x = 0;
		y = 0;
	}

	// Simple getter function for X
	public double getX() {
		return x;
	}

	// Simple getter function for Y
	public double getY() {
		return y;
	}
	
	// Computes and returns the distance from this point to another
	public double distance(Point other) {
		double x12 = x - other.getX();
		double y12 = y - other.getY();
		x12 = Math.pow(x12,2);
		y12 = Math.pow(y12,2);
		return Math.sqrt(x12+y12);
	}

	// Returns the string "(x,y)"
	public String toString() {
		String points= "(" + x + "," + y + ")";
		return points;
	}
}

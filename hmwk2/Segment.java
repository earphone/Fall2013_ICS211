/*
 * Assignment:		Homework 2
 * File:		Segment
 * Author:		Brandon Higashi
 * Date:		September 10, 2013
 * Mod:			September 11, 2013
 * Description:
 * 	A class that implements the Segment Interface for line segments in the
 * 	two-dimensional plane.
 */


public class Segment implements SegmentInterface{
	
	private Point a, b;

	// Creates a segment with new points at (0,0)
	public Segment() {
		a = new Point(0,0);
		b = new Point(0,0);
	}
	
	// Sets Points a and b to two points added at creation
	public Segment(Point A, Point B) {
		a = A;
		b = B;
	}

	// Sets Points a and b given coordinates of two points
	// Use in the form Segment(X1,Y1,X2,Y2)
	public Segment(double x1, double y1, double x2, double y2) {
		a = new Point(x1,y1);
		b = new Point(x2,y2);
	}

	// The point at the left end of the segment
	// If both point's X coordinates are equal then chooses A
	
	public Point left() {
		if(a.getX() > b.getX()) {
			return b;
		}
		else {
			return a;
		}
	}

	// The point at the right of the segment
	// If both point's x coordinates are equal then chooses A
	public Point right() {
		if(a.getX() < b.getX()) {
			return b;
		}
		else {
			return a;
		}
	}

	// The point at the top of the segment
	// If both point's y coordinates are equal then chooses A
	public Point upper() {
		if(a.getY() < b.getY()) {
			return b;
		}
		else {
			return a;
		}
	}

	// The point at the botom of the segment
	// If both point's y coordinates are equal then chooses A
	public Point lower() {
		if(a.getY() > b.getY()) {
			return b;
		}
		else {
			return a;
		}
	}

	// The length of the segment using Point.distance
	// If points on the same spot then return 0
	public double length() {
		return a.distance(b);
	}

	// Determine if a segment is horizontal and returns true if so
	public boolean isHorizontal() {
		return a.getX() == b.getX();
	}

	// Determine if a segment is vertical and returns true if so
	public boolean isVertical() {
		return a.getY() == b.getY();
	}

	// Moves the entire segment to a new point by moving the lower point
	// to the new position.  If segment is horizontal then it moves the left
	// point to the new position.
	public void move(Point newLowerorLeft) {
		boolean moveA;
		double diffX, diffY, newX, newY;
		// Horizontal
	   	if(a.getY() == b.getY()) {
			// a is on the left
	       		if(a.getX() < b.getX()) {
				moveA = true;
			}
			// b is on the left
			else {
				moveA = false;
			}
		}
		// a is lower
		else if(a.getY() < b.getY()) {
			moveA = true;
		}
		// b is lower
		else {
			moveA = false;
		}
		// use a as the new point
		if(moveA) {
			diffX = a.getX() - newLowerorLeft.getX();
			diffY = a.getY() - newLowerorLeft.getY();
			newX = b.getX()-diffX;
			newY = b.getY()-diffY;
			a = newLowerorLeft;
			b = new Point(newX, newY);
		}
		// use b as the new point
		else {
			diffX = b.getX() - newLowerorLeft.getX();
			diffY = b.getY() - newLowerorLeft.getY();
			newX = a.getX()-diffX;
			newY = a.getY()-diffY;
			a = new Point(newX, newY);
			b = newLowerorLeft;
		}
	}

	// Returns a string in form "(x1,y1)(x2,y2)", where (x1,y1) is the 
	// lower or left most point
	public String toString() {
		String seg;
		double x1, x2, y1, y2;
		if(a.getY() == b.getY()) {
			if(a.getX() < b.getX()) {
				x1 = a.getX();
				x2 = b.getX();
				y1 = a.getY();
				y2 = b.getY();
			}
			else {
				x1 = b.getX();
				x2 = a.getX();
				y1 = b.getY();
				y2 = a.getY();
			}
		}
		else if(a.getY() < b.getY()) {
			x1 = a.getX();
			x2 = b.getX();
			y1 = a.getY();
			y2 = b.getY();
		}
		else {
			x1 = b.getX();
			x2 = a.getX();
			y1 = b.getY();
			y2 = a.getY();
		}
		seg = "(" + x1 + "," + y1 + ") (" + x2 + "," + y2 + ")";
		return seg;
	}
}

/*
 * Assignment:		Homework 2
 * File:		hmwk2test
 * Author:		Brandon Higashi
 * Date:		September 11, 2013
 * Mod:			September 11, 2013
 * Description:
 * 	This is the test class that contains the main method to test
 * 	Point, SegmentInterface, Segment, and CreateSegment.
 */

public class hmwk2test {
	
	// Invoked when first run
	public static void main (String[] arguments) {
		Point nothingP = new Point();
		Point aP = new Point(1,1);
		Point bP = new Point(2,1);
		System.out.println("X of aP is: " + aP.getX());
		System.out.println("Y of aP is: " + aP.getY());
		System.out.println("X of bP is: " + bP.getX());
		System.out.println("Y of bP is: " + bP.getY());
		System.out.println("Distance between aP and bP: " + aP.distance(bP));
		System.out.println("String of aP and bP: " + aP.toString() + " "+ bP.toString());
		System.out.println("String of nothingP " + nothingP.toString());

		Segment nothingS = new Segment();
		Segment aS = new Segment(aP, bP);
		System.out.println("nothingS is horizontal check " + nothingS.isHorizontal());
		System.out.println("aS is horizontal check " + aS.isHorizontal());
		System.out.println("nothingS is vertical check " + nothingS.isVertical());
		System.out.println("aS is vertical check " + aS.isVertical());
		System.out.println("aS left point " + aS.left());
		System.out.println("aS right point " + aS.right());
		System.out.println("aS upper point " + aS.upper());
		System.out.println("aS lower point " + aS.lower());
		System.out.println("aS length " + aS.length());
		System.out.println("aS to string " + aS.toString());
		Point newOne = new Point(4,5);
		aS.move(newOne);
		System.out.println("aS moved to new point " + aS.toString());
		Point newTwo = new Point(3,4);
		aS.move(newTwo);
		System.out.println("aS moved to new point " + aS.toString());
		System.out.println("Unit Test: ");
		CreateSegments.unitTest();
	}
}

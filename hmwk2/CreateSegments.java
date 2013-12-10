/*
 * Assignment:		Homework 2
 * File:		CreateSegments
 * Author:		Brandon Higashi
 * Date:		September 11, 2013
 * Mod:			September 11, 2013
 * Description:
 * 	This is a test class that creates predetermined segments using
 * 	the other classes and interfaces in this folder.
 */

public class CreateSegments {

	// Print the values of 4 segment variables that takes four SegmentInterface variables
	// as parameters
	public static void printFour(SegmentInterface aSI, SegmentInterface bSI, SegmentInterface cSI, SegmentInterface dSI) {
		System.out.println(aSI.toString() + "\n" + bSI.toString() + "\n" + cSI.toString() + "\n" + dSI.toString());
	}

	public static void unitTest() {
		SegmentInterface aSI = new Segment(1,2,4,5);
		SegmentInterface bSI = new Segment(1,2,4,2);
		Segment aS = new Segment(4,5,4,2);
		Segment bS = new Segment(0,0,7,1.5);
		CreateSegments.printFour(aSI, bSI, aS, bS);
		Point movement = new Point(-5.3, 0);
		bS.move(movement);
		CreateSegments.printFour(aSI, bSI, aS, bS);
	}
}

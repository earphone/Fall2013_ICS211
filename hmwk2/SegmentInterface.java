/*
 * Assignment:		Homework 2
 * File:		SegmentInterface
 * Author:		Brandon Higashi
 * Date:		September 10, 2013
 * Mod:			September 10, 2013
 * Description:
 * 	This is an interface that represents line segments in the two-
 * 	dimensional plane.  Each line segment has two endpoints, 
 * 	initialized at creation.
 */

public interface SegmentInterface {
	Point left();		// the point at the left end of segment
	Point right();		// the point at the right end of the segment
	Point upper();		// the point at the upper end of the segment
	Point lower();		// the point at the lower end of the segment
	double length();	// the length of the segment, that is, the
				//	distance between its endpoints
}	

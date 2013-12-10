/*
 * Assignment:	Homework 10
 * File:	compareRecords
 * Author:	Brandon Higashi
 * Date:	November 20, 2013
 * Mod:		November 20, 2013
 * Description:
 * 	Sample compare class for records
 */

import java.util.Comparator;

public class compareRecords implements Comparator<record> {
	public int compare(record left, record right) {
		return left.compareTo(right);
	}
}

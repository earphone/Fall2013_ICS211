/*
 * Assignment:	Homework 10
 * File:	record
 * Author:	Brandon Higashi
 * Date:	November 19, 2013
 * Mod:		November 19, 2013
 * Description:
 * 	This class holds all of the data
 */

public class record implements Comparable {
	String name = null;
	long deadline = 0;
	long duration = 0;

	public record(String nameIn, long deadlineIn, long durationIn) {
		name = nameIn;
		deadline = deadlineIn;
		duration = durationIn;
	}

	public long getDeadline() {
		return deadline;
	}

	public long getDuration() {
		return duration;
	}

	public String getName() {
		return name;
	}

	@Override
	public int compareTo(Object b) {
		if(this.getClass() == b.getClass()) {
			record B = (record) b;
			if(B == null) return -1;
			else if(this.deadline > B.getDeadline()) return -1;
			else if(this.deadline == B.getDeadline()) return 0;
			else return 1;
		}
		else return -1;
	}

	public void printRecord() {
		System.out.println(name + " with deadline " + deadline + " and duration " + duration);
	}
}

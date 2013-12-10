/*
 * Assignment:	Homework 10
 * File:	driverHomework10
 * Author:	Brandon Higashi
 * Date:	November 22, 2013
 * Mod:		November 22, 2013
 * Description:
 * 	This is the main driver class for Homework 10
 */

import java.util.*;
import java.io.*;

public class driverHomework10 {
	public static void main(String[] args) {
		if(args.length != 1) {
			System.out.println("Expecting one file . . . Exiting . . .");
			System.exit(1);
		}
	    try{
		boolean debug = false;	// set debug to true to see debugging
		FileInputStream fstream = new FileInputStream(args[0]);
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
		String line;
		pQueue queue = new pQueue(2);
		record process;
		record working;
		long time = 0;
		long duration = 0;
		boolean done;
		while((line = br.readLine()) != null) {
			if(debug)System.out.println("\t" + line);
			String[] split = line.split(" ");
			if(split[0].equals("schedule")) {
				process = new record(split[1], Integer.parseInt(split[2]), Integer.parseInt(split[3]));
				System.out.print(time + ": ");
				queue.offer(process);
			}
			else if(split[0].equals("run")) {
			  done = true;
			  while(done) {
				if(debug)System.out.println("time: " + time);
				working = queue.poll();
				if(working == null) return;
				System.out.print(time + ": busy with ");
				working.printRecord();
				if(duration != 0) {
					time = time + duration;
					if(time < working.getDeadline() && time < Integer.parseInt(split[1])) {
						System.out.println(time + ": done with " + working.getName());
						duration = 0;
						working = queue.poll();
					}
					if(time > working.getDeadline() && time < Integer.parseInt(split[1])) {
						System.out.println(time + ": done with " + working.getName() + " (late)");
						duration = 0;
						working = queue.poll();
					}
					if(time > Integer.parseInt(split[1])) {
						duration = Integer.parseInt(split[1]) - time + duration;
						time = Integer.parseInt(split[1]);
						done = false;
					}
					else System.out.println("Error in duration !- 0");
				}
				else if(time < working.getDeadline()) {
					if(debug) System.out.println("time: " + time + " deadline: " + working.getDeadline());
					time = time + working.getDuration();
					if(time < working.getDeadline() && time < Integer.parseInt(split[1])) {
						System.out.println(time + ": done with " + working.getName());
						working = queue.poll();
					}
					else if(time > working.getDeadline() && time < Integer.parseInt(split[1])) {
						System.out.println(time + ": done with " + working.getName() + " (late)");
						working = queue.poll();
					}
					else if(time > Integer.parseInt(split[1])) {
						duration = Integer.parseInt(split[1]) - time + working.getDuration();
						time = Integer.parseInt(split[1]);
						done = false;
					}
					else System.out.println("Error in time < working.getDeadline()");
				}
				else {
					time = time + working.getDuration();
					if(time < Integer.parseInt(split[1])) {
						System.out.println(time + ": done with " + working.getName() + " (late)");
					}
					if(time > Integer.parseInt(split[1])) {
						duration = Integer.parseInt(split[1]) - time + working.getDuration();
						time = Integer.parseInt(split[1]);
						done = false;
					}
					else System.out.println("Error in time else");
				}
			    }
			}
			else {
				System.out.println("Not a valid command . . . Exiting");
				System.exit(1);
			}
		}
	    }
	    catch(java.io.FileNotFoundException e) {
		    System.out.println("No file found");
	    }
	    catch(java.io.IOException e) {
		    System.out.println("Cannot read file");
	    }
	}
}

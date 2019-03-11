/*
 * File: VoteCounter.java
 * ---------------------
 * A sandcastle program that uses collections to tally votes 
 */

import acm.program.*;
import java.util.*;

public class VoteCounter extends ConsoleProgram {
	public void run() {
		ArrayList<String> votes = new ArrayList<String>();
		votes.add("Zaphod Beeblebrox");
		votes.add("Arthur Dent");
		votes.add("Trillian McMillian");
		votes.add("Zaphod Beeblebrox");
		votes.add("Marvin");
		votes.add("Mr. Zarniwoop");
		votes.add("Trillian McMillian");
		votes.add("Zaphod Beeblebrox");
		printVoteCounts(votes);
		
	}
	
	/*
	 * This method counts and displays the number of votes
	 * each candidate got by counting the each instance of a 
	 * given candidate in the array list. I used the following 
	 * source for help: https://www.geeksforgeeks.org/count-occurrences-elements-list-java/
	 * 
	 */
	
	private void printVoteCounts(ArrayList<String> votes) {
		int Zaphod = Collections.frequency(votes, "Zaphod Beeblebrox");				//counts each instance of "Zaphod Beblebrox" in the array list, giving the number of instances/votes
		int Arthur = Collections.frequency(votes, "Arthur Dent");
		int Trillian = Collections.frequency(votes, "Trillian McMillian");
		int Marvin = Collections.frequency(votes, "Marvin");
		int Zarniwoop = Collections.frequency(votes, "Mr. Zarniwoop");
		println ("Votes for Zaphod Beeblebrox: " + Zaphod);
		println ("Votes for Arthur Dent: " + Arthur);
		println ("Votes for Trillian McMillian: " + Trillian);
		println ("Votes for Marvin: " + Marvin);
		println ("Votes for Mr. Zarniwoop: " + Zarniwoop);
	}
}

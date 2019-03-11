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
	 * Your job is to implement this method according to 
	 * the problem specification. 
	 */
	
	private void printVoteCounts(ArrayList<String> votes) {
		int Zaphod = Collections.frequency(votes, "Zaphod Beeblebrox");
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

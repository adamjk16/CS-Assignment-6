/*
 * File: BlankClass.java
 * ---------------------
 * This class is a blank one that you can change at will. Remember, if you change
 * the class name, you'll need to change the filename so that it matches.
 * Then you can extend GraphicsProgram, ConsoleProgram, or DialogProgram as you like.
 */

import acm.program.*;
import java.util.*;

public class VoteCounter extends ConsoleProgram {
	public void run() {
		var votes = new ArrayList<String>();
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
	
	private void printVoteCounts(ArrayList<String> votes) {
		var counts = new HashMap<String, Integer>();
		for (String vote: votes) {
			if (!counts.containsKey(vote)) {
				counts.put(vote, 0);
			}
			counts.put(vote, counts.get(vote) + 1);
		}
		
		for (String candidate: counts.keySet()) {
			println("Votes for " + candidate + ": " + counts.get(candidate));
		}
	}
}

/*
 * File: NameSurferEntry.java
 * --------------------------
 * This class represents a single entry in the database.  Each
 * NameSurferEntry contains a name and a list giving the popularity
 * of that name for each decade stretching back to 1900.
 */

import acm.util.*;
import java.util.*;

public class NameSurferEntry implements NameSurferConstants {

	private String name;
	private int [] rank;

	/**
	 * Constructor: NameSurferEntry(line)
	 * Creates a new NameSurferEntry from a data line as it appears
	 * in the data file.  Each line begins with the name, which is
	 * followed by integers giving the rank of that name for each
	 * decade.
	 */
	
	//received help in LAIR
	
	public NameSurferEntry(String line) {
		rank = new int [NDECADES];
		String [] array = line.split(" ");
		name = array[0];
		for (int i = 1; i < array.length; i++) {
			rank[i - 1] = Integer.parseInt(array[i]);
		}
	}

	/**
	 * Public Method: getName()
	 * Returns the name associated with this entry.
	 */
	
	public String getName() {
		return name;
	}

	/**
	 * Public Method: getRank(decade)
	 * Returns the rank associated with an entry for a particular
	 * decade.  The decade value is an integer indicating how many
	 * decades have passed since the first year in the database,
	 * which is given by the constant START_DECADE.  If a name does
	 * not appear in a decade, the rank value is 0.
	 */
	public int getRank(int decade) {
		if (decade >= NDECADES) {
			return -1;
		}
		return rank[decade];
	}

	/**
	 * Public Method: toString()
	 * Returns a string that makes it easy to see the value of a
	 * NameSurferEntry.
	 */
	
	public String toString() {
		String dataString = "";
		for (int i = 0; i < rank.length - 1; i++) {
			dataString = rank[i] + ",";
		}
		dataString = name + " [" + dataString + "]";
		return dataString;
	}
}


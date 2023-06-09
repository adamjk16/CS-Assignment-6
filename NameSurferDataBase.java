/*
 * File: NameSurferDataBase.java
 * -----------------------------
 * This class keeps track of the complete database of names.
 * The constructor reads in the database from a file, and
 * the only public method makes it possible to look up a
 * name and get back the corresponding NameSurferEntry.
 * Names are matched independent of case, so that "Eric"
 * and "ERIC" are the same names.
 */

import acm.util.*;
import java.util.*;
import java.io.*;

public class NameSurferDataBase implements NameSurferConstants {

	private Scanner names;
	private HashMap <String, NameSurferEntry> nameHashMap;

	
	/**
	 * Constructor: NameSurferDataBase(filename)
	 * Creates a new NameSurferDataBase and initializes it using the
	 * data in the specified file.  The constructor throws an error
	 * exception if the requested file does not exist or if an error
	 * occurs as the file is being read.
	 */

	public NameSurferDataBase(String filename) {
		try {
			names = new Scanner(new File("names-data.txt"));
			nameHashMap = new HashMap <String, NameSurferEntry>();				//initializes hashMap
			while (names.hasNextLine()) {
				NameSurferEntry name = new NameSurferEntry(names.nextLine());
				nameHashMap.put(name.getName(), name);							//puts each entry of the database into a hashMap
			}
			names.close();	
		} catch (IOException e) {
			throw new ErrorException(e);
		}
	}

	/**
	 * Public Method: findEntry(name)
	 * Returns the NameSurferEntry associated with this name, if one
	 * exists.  If the name does not appear in the database, this
	 * method returns null.
	 */
	public NameSurferEntry findEntry(String name) {
		if (nameHashMap.containsKey(name)) {
			return nameHashMap.get(name);
		} else {
			return null;
		}
	}
}


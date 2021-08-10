package utilities;

import java.io.Serializable;

/** Location object used to log filename and linenumber where words were found
 * 
 * @author Don Laliberte
 * @author Elie Kabengele
 * @author Jared Smith
 * @author Jaekyung Jeon
 * @version August 9th 2021
 *
 */
public class Location implements Serializable {

	private String filename;
	private int line;

	/**
	 * Constructor For Location Object. Used to track both the filename and line number for logged Words
	 * @param filename filename to set
	 * @param line line number to set 
	 */
	public Location(String filename, int line) {
		this.filename = filename;
		this.line = line;
	}
	
	/**
	 * Returns the Filename of where a word was found
	 * @return filename to return
	 */
	public String getFilename() {
		return filename;
	}

	/**
	 * Returns the Line location of where a word was found
	 * @return line number to return
	 */
	public int getLine() {
		return line;
	}

	/**
	 * Verifys if two filenames are equal
	 */
	@Override
	public boolean equals(Object obj) {
		Location o = (Location) obj;
		if (filename.equals(o.getFilename()) && line == o.getLine()) {
			return true;
		}
		return false;
	}
}

package utilities;

import java.io.Serializable;

public class Location implements Serializable {

	private String filename;
	private int line;

	public Location(String filename, int line) {
		this.filename = filename;
		this.line = line;
	}
	
	public String getFilename() {
		return filename;
	}
	public int getLine() {
		return line;
	}

	@Override
	public boolean equals(Object obj) {
		Location o = (Location) obj;
		if (filename.equals(o.getFilename()) && line == o.getLine()) {
			return true;
		}
		return false;
	}
}

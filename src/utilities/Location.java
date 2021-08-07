package utilities;

public class Location {

	private String filename;
	private int line;
	
	
	
	public Location() {
	}

	public Location(String filename, int line) {
		super();
		this.filename = filename;
		this.line = line;
	}
	
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public int getLine() {
		return line;
	}
	public void setLine(int line) {
		this.line = line;
	}
}

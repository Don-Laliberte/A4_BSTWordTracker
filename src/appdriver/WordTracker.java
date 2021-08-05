package appdriver;

public class WordTracker {

	public static void main(String[] args) {
		
		if (args == null || args[0] == null) {
			System.out.println("Please enter a filename");
		}
		else if (args.length > 3) {
			System.out.println("ERROR: Invalid parameters!");
		}

	}

}

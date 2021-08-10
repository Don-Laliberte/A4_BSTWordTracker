package exceptions;

/**
 * Exception Class for all errors related to our BST
 * 
 * @author Don Laliberte
 * @author Elie Kabengele
 * @author Jared Smith
 * @author Jaekyung Jeon
 * @version August 9th 2021
 *
 */
public class TreeException extends Exception {
	public TreeException() {
		super();
	}
	
	/**
	 * Constructor that takes message parameter
	 * @param message sent to console to explain specific cause of thrown error
	 */
	public TreeException(String message) {
		super(message);
	}
}

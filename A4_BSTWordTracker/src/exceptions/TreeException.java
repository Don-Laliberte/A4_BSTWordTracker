package exceptions;

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

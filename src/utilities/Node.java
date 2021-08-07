package utilities; // TODO move to own package please!

import java.io.Serializable;

public class Node implements Serializable {
	// Determines the serialized version of the program
	private static final long serialVersionUID = 8609620369083022064L;
	
	// field attributes
	private Object data;
	private Node next;
	private Node previous;
	
	/**
	 * Initializes the newly created Node
	 */
	public Node() {

	}
	
	/**
	 * Initializes the newly created Node
	 * @param data - the data to set
	 */
	public Node(Object data) {
		this.data = data;
		next = null;
		previous = null;
	}
	
	/**
	 * 
	 * Initializes the newly created Node
	 * @param data - the data to set
	 * @param next - the next to set
	 */
	public Node(Object data, Node next, Node previous) {
		this.data = data;
		this.next = next;
		this.previous = previous;
	}
	
	/**
	 * Gets the data of a Node
	 * @return data
	 */
	public Object getData() {
		return data;
	}

	/**
	 * Sets the data of a Node based on data parameter
	 * @param data
	 */
	public void setData(Object data) {
		this.data = data;
	}
	
	/**
	 * Gets the next of a Node
	 * @return next
	 */
	public Node getNext() {
		return next;
	}
	
	/**
	 * Sets the next of a Node based on next parameter
	 * @param next - the next to set
	 */
	public void setNext(Node next) {
		this.next = next;
	}

	/**
	 * Gets the previous of a Node
	 * @return previous
	 */
	public Node getPrevious() {
		return previous;
	}
	
	/**
	 * Sets the previous of a Node based on previous parameter
	 * @param previous - the previous to set
	 */
	public void setPrevious(Node previous) {
		this.previous = previous;
	}

}

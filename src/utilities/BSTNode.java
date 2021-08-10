package utilities;

import java.io.Serializable;

/** BSTNode Class which will be used to store entries to our BSTree
 * Like a linked list they store data and have pointers to their left and right side children
 * 
 * @author Don Laliberte
 * @author Elie Kabengele
 * @author Jared Smith
 * @author Jaekyung Jeon
 * @version August 9th 2021
 *
 */
public class BSTNode implements Serializable {
	
	private Object elem;
	private BSTNode left;
	private BSTNode right;
	
	/**
	 * Default Constructor for BSTNode. Used to instansiate nodes with no children
	 * @param elem element to set
	 */
	public BSTNode(Object elem) {
		this.elem = elem;
		left=null;
		right=null;
	}

	/**
	 * Default Constructor for BSTNode. Used to instansiate nodes with both a left and right child
	 * @param elem element to set
	 */
	public BSTNode(Object elem, BSTNode left, BSTNode right) {
		super();
		this.elem = elem;
		this.left = left;
		this.right = right;
	}
	
	/**
	 * Returns the data element stored in this node.
	 * @return element to return
	 */
	public Object getElem() {
		return elem;
	}

	/**
	 * Sets the data element stored in this node
	 * @param elem element to set
	 */
	public void setElem(Object elem) {
		this.elem = elem;
	}

	/**
	 * Gets the left child node of the current
	 * @return child node to return
	 */
	public BSTNode getLeft() {
		return left;
	}

	/**
	 * Sets the left child node of the current
	 * @param left node to set
	 */
	public void setLeft(BSTNode left) {
		this.left = left;
	}

	/**
	 * Gets the right child node of the current
	 * @return child node to return
	 */
	public BSTNode getRight() {
		return right;
	}

	/**
	 * Sets the right child node of the current
	 * @param right node to set
	 */
	public void setRight(BSTNode right) {
		this.right = right;
	}

	

}

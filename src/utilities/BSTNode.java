package utilities;

import java.io.Serializable;

public class BSTNode implements Serializable {
	
	private Object elem;
	private BSTNode left;
	private BSTNode right;
	
	public BSTNode(Object elem) {
		this.elem = elem;
		left=null;
		right=null;
	}

	public BSTNode(Object elem, BSTNode left, BSTNode right) {
		super();
		this.elem = elem;
		this.left = left;
		this.right = right;
	}
	
	
	public Object getElem() {
		return elem;
	}

	public void setElem(Object elem) {
		this.elem = elem;
	}

	public BSTNode getLeft() {
		return left;
	}

	public void setLeft(BSTNode left) {
		this.left = left;
	}

	public BSTNode getRight() {
		return right;
	}

	public void setRight(BSTNode right) {
		this.right = right;
	}

	

}

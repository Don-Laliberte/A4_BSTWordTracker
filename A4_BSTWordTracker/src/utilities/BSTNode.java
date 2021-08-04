package utilities;

public class BSTNode {
	
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
	
	
	
	

}

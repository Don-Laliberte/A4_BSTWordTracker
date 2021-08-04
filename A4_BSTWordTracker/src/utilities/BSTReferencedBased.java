package utilities;

import adts.BSTreeADT;
import adts.Iterator;
import exceptions.TreeException;

public class BSTReferencedBased implements BSTreeADT{
	
	private BSTNode root;
	
	

	public BSTReferencedBased() {
		root = null;
	}

	public BSTReferencedBased(BSTNode root) {
		super();
		this.root = root;
	}

	@Override
	public Comparable getRootData() throws TreeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		if (root == null) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean contains(Comparable entry) throws TreeException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Comparable getEntry(Comparable entry) throws TreeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(Comparable entry) throws NullPointerException {
		if (root == null) {
			root = new BSTNode(entry);
			return true;
		}
		
		BSTNode temp = root;
		
		while (temp != null) {
			if (entry.compareTo(root.getElem()) == -1 || entry.compareTo(root.getElem()) == 0) {
				if (temp.getLeft() != null) {
					temp = temp.getLeft();
				}
				else {
					temp.setLeft(new BSTNode(entry));
					return true;
				}
			}
			
			if (entry.compareTo(root.getElem()) == 1) {
				if (temp.getRight() != null) {
					temp = temp.getRight();
				}
				else {
					temp.setRight(new BSTNode(entry));
					return true;
				}
			}
		}	
		
		
		return false;
	}

	@Override
	public Iterator inorderIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator preorderIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator postorderIterator() {
		// TODO Auto-generated method stub
		return null;
	}

}

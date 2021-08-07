package utilities;

import adts.BSTreeADT;
import adts.Iterator;
import exceptions.TreeException;

public class BSTReferencedBased<E extends Comparable<? super E>> implements BSTreeADT{
	private static final long serialVersionUID = 1L;
	private BSTNode root;
	private int size;
	

	public BSTReferencedBased() {
		root = null;
	}

	public BSTReferencedBased(BSTNode root) {
		super();
		this.root = root;
	}

	@Override
	public Comparable getRootData() throws TreeException {
		return (Comparable) root.getElem();
	}

	@Override
	public int size() {
		return size;
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
		size = 0;
		root = null;
	}

	@Override
	public boolean contains(Comparable entry) throws TreeException {
		//@todo to be implemented using Iterators. Traverse and compare using entry.getWord() and return true if found.
		return false;
	}

	@Override
	public E getEntry(Comparable entry) throws TreeException {
		//@todo to be implemented using Iterators. Traverse and compare using entry.getWord() and return that node's word if found.
		return null;
	}

	@Override
	public boolean add(Comparable entry) throws NullPointerException {
		if (root == null) {
			root = new BSTNode(entry);
			size++;
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
					size++;
					return true;
				}
			}
			
			if (entry.compareTo(root.getElem()) == 1) {
				if (temp.getRight() != null) {
					temp = temp.getRight();
				}
				else {
					temp.setRight(new BSTNode(entry));
					size++;
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

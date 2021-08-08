package utilities;

import java.util.NoSuchElementException;

import adts.BSTreeADT;
import adts.Iterator;
import exceptions.TreeException;

public class BSTReferencedBased<E extends Comparable<? super E>> implements BSTreeADT {
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
		} else {
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
		Iterator inorder = inorderIterator();
		
		while (inorder.hasNext()) {
			BSTNode node = (BSTNode) inorder.next();
			if (node.getElem().equals(entry)) {
				return true;
			}
		}
		throw new TreeException();
	}

	@SuppressWarnings("unchecked")
	@Override
	public E getEntry(Comparable entry) throws TreeException {
		Iterator inorder = inorderIterator();
		
		while (inorder.hasNext()) {
			BSTNode node = (BSTNode) inorder.next();
			if (node.getElem().equals(entry)) {
				return (E) node.getElem();
			}
		}
		throw new TreeException();
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
			if (entry.compareTo(temp.getElem()) == -1 || entry.compareTo(temp.getElem()) == 0) {
				if (temp.getLeft() != null) {
					temp = temp.getLeft();
				} else {
					temp.setLeft(new BSTNode(entry));
					size++;
					return true;
				}
			} else if (entry.compareTo(temp.getElem()) == 1) {
				if (temp.getRight() != null) {
					temp = temp.getRight();
				} else {
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
		return new Iterator() {

			private MyStack<BSTNode> travStack = new MyStack<BSTNode>(); // used for tracking traversal
			BSTNode current = root;
			boolean initialized = false;
			
			
			@Override
			public boolean hasNext() {
				if (initialized == false) { //initializes the tree by moving farthest left on first call. This is always going to run upon first call
					initialize();
					initialized = true;
				}
				return !travStack.isEmpty();
			}
			
			public void initialize() {
				while (current != null) { //moves current to the farthest left (up to an empty child), filling the stack on the first next call
					travStack.push(current); //pushes "queued" nodes to stack 
					current = current.getLeft();  //moves current further left
				}
			}
			
			
			public void iterate() throws NoSuchElementException { //Moves current to the next element
				
				BSTNode tempNode = travStack.peek().getRight(); //takes farthest left node and stores it's right child in temp node
				travStack.pop(); //pops the child/parent off the stack
				while (tempNode != null) { //if the right child is not an empty node keep looping
					travStack.push(tempNode); //pushes right subtree node into stack
					tempNode = tempNode.getLeft(); //keeps iterating through right subtree's left children
				}
			}
			
			public Object next() throws NoSuchElementException {
				if (hasNext() == true) { //Checks if there is a next element
					BSTNode returnValue = travStack.peek(); //stores the topmost node on stack
					iterate(); //iterates tree for next call
					return returnValue.getElem(); //returns the stored value
				}
				else {
					throw new NoSuchElementException();
				}

			}

			
		};
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

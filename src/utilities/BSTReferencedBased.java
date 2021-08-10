package utilities;

import java.util.NoSuchElementException;

import adts.BSTreeADT;
import adts.Iterator;
import exceptions.TreeException;

/** Implementation of our BST data structure. This is used to create new trees as well as modify the tree structure.
 * 
 * @author Don Laliberte
 * @author Elie Kabengele
 * @author Jared Smith
 * @author Jaekyung Jeon
 * @version August 9th 2021
 *
 */
public class BSTReferencedBased<E extends Comparable<? super E>> implements BSTreeADT {
	private static final long serialVersionUID = 1L;
	private BSTNode root;
	private int size;

	/** Default Constructor for BSTReferencedBased, instansiates root as nulll 
	*/
	public BSTReferencedBased() {
		root = null;
	}

	/**
	 * Constructor for BSTReferencedBased, instansiates root as given.
	 * @param root given root to set
	 */
	public BSTReferencedBased(BSTNode root) {
		super();
		this.root = root;
	}

	/**
	 * Returns the data for the root node.
	 * @return the data for the root
	 */
	@Override
	public Comparable getRootData() throws TreeException {
		return (Comparable) root.getElem();
	}

	/**
	 * Returns the number of nodes in tree
	 * @return number of nodes in tree
	 */
	@Override
	public int size() {
		return size;
	}

	/**
	 * Used to verify if a tree has nodes
	 * @return true if the tree has nodes, otherwise false
	 */
	@Override
	public boolean isEmpty() {
		if (root == null) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Clears the tree of all nodes 
	 */
	@Override
	public void clear() {
		size = 0;
		root = null;
	}

	/**
	 * Checks for an Entry in the Tree
	 * @throws TreeException if the BST is empty and contains zero elements
	 * @param entry to search for
	 * @return returns true if the entry is found, false otherwise
	 */
	@Override
	public boolean contains(Comparable entry) throws TreeException {
		Iterator inorder = inorderIterator();
		
		while (inorder.hasNext()) {
			E elem = (E) inorder.next();
			if (elem.equals(entry)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Used to Iterate through the tree in search of a specific entry
	 * @throws TreeException if the BST is empty and contains zero elements
	 * @param entry to locate
	 * @return located entry 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public E getEntry(Comparable entry) throws TreeException {
		Iterator inorder = inorderIterator();
		
		while (inorder.hasNext()) {
			E elem = (E) inorder.next();
			if (elem.equals(entry)) {
				return (E) elem;
			}
		}
		throw new TreeException();
	}

	/** Add method for tree used to link new nodes
	 * @param entry entry to add to tree
	 * @return true if successful, false otherwise.
	 */
	@Override
	public boolean add(Comparable entry) throws NullPointerException {
		if (root == null) {
			root = new BSTNode(entry);
			size++;
			return true;
		}

		BSTNode temp = root;

		while (temp != null) {
			if (entry.compareTo(temp.getElem()) < 0 || entry.compareTo(temp.getElem()) == 0) {
				if (temp.getLeft() != null) {
					temp = temp.getLeft();
				} else {
					temp.setLeft(new BSTNode(entry));
					size++;
					return true;
				}
			} else if (entry.compareTo(temp.getElem()) > 0) {
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

	/**
	 * inorder iterator implementation allows us to navigate the tree inorder
	 * @return returns new inorder Iterator Object 
	 */
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

	/**
	 * preorder iterator implementation allows us to navigate the tree preorder
	 * @return returns new preorder Iterator Object 
	 */
	@Override
	public Iterator preorderIterator() {
		
		return new Iterator() {

			private MyStack<BSTNode> travStack = new MyStack<BSTNode>(); // used for tracking traversal
			BSTNode current = root;
			boolean initialized = false;
			
			
			@Override
			public boolean hasNext() {
				if (initialized == false) { //initializes the tree by setting the root as the topmost element
					initialize();
					initialized = true;
				}
				return !travStack.isEmpty();
			}
			
			public void initialize() {
				if (current != null) {
					travStack.push(current);
				}
			}
			
			
			public void iterate() throws NoSuchElementException { //Moves current to the next element
				
				BSTNode tempNode = travStack.pop(); //takes current node and pops it, storing it in a temp node
				if (tempNode.getRight() != null) {
					travStack.push(tempNode.getRight()); //makes right node second highest on stack after that iterate method
				}
				if (tempNode.getLeft() != null) {
					travStack.push(tempNode.getLeft()); //makes left node the topmost and current element in the stack
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

	/**
	 * postorder iterator implementation allows us to navigate the tree postorder
	 * @return returns new postorder Iterator Object 
	 */
	@Override
	public Iterator postorderIterator() {
		return new Iterator() {

			private MyStack<BSTNode> travStack = new MyStack<BSTNode>(); // used for tracking traversal
			private MyStack<BSTNode> outStack = new MyStack<BSTNode>(); // used to store the traversal
			BSTNode current = root;
			boolean initialized = false;
			
			
			@Override
			public boolean hasNext() {
				if (initialized == false) { //initializes the tree by traversing in postorder and storing in a stack
					initialize();
					initialized = true;
				}
				return !outStack.isEmpty();
			}
			
			public void initialize() {
				travStack.push(current);
				
				while(!travStack.isEmpty()) {
					BSTNode tempNode = travStack.pop();
					outStack.push(tempNode);
					if (tempNode.getLeft() != null) {
						travStack.push(tempNode.getLeft());
					}
					if (tempNode.getRight() != null) {
						travStack.push(tempNode.getRight());
					}
				}
			}
			
			
			
			public Object next() throws NoSuchElementException {
				if (hasNext() == true) { //Checks if there is a next element
					BSTNode returnValue = outStack.peek(); //stores the topmost node on stack
					outStack.pop(); //pops the out stack
					return returnValue.getElem(); //returns the stored value
				}
				else {
					throw new NoSuchElementException();
				}

			}

			
		};
	}

}

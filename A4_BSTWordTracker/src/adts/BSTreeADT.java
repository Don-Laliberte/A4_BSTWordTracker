package adts;

import java.io.Serializable;

import exceptions.TreeException;

public interface BSTreeADT<E extends Comparable<? super E>> extends Serializable{
	
	/**
	 * The element stored in the root of the BST will be returned
	 * @return data element stored in the root of the tree
	 * @exception if the root is empty, the tree does not exist
	 */
	public E getRootData() throws TreeException;
	
	public int size();
	
	public boolean isEmpty();
	
	public void clear();
	
	public boolean contains(E entry) throws TreeException;
	
	/**
	 * retrieves an element from the tree given the object to search for
	 * @param entry
	 * @return
	 * @throws TreeException
	 */
	public E getEntry(E entry)  throws TreeException;
	
	public boolean add(E entry) throws NullPointerException;
	
	public Iterator<E> inorderIterator();
	
	public Iterator<E> preorderIterator();
	
	public Iterator<E> postorderIterator();
}

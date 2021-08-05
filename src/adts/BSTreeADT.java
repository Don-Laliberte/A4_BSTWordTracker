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
	
	/**
	 * The total number of elements stored in the BST will be returned
	 * @return total number of elements stored in BST
	 */
	public int size();
	
	/**
	 * Checks if the BST stores zero elements and returns boolean condition
	 * @return true if zero elements are stored, otherwise false
	 */
	public boolean isEmpty();
	
	/**
	 * Clears all elements stored within the BST
	 */
	public void clear();
	
	/**
	 * Checks if BST contains a given element and returns boolean condition
	 * @param entry that is being checked for existence within the BST
	 * @return true if element exists, otherwise false
	 * @throws TreeException if the BST is empty and contains zero elements
	 */
	public boolean contains(E entry) throws TreeException;
	
	/**
	 * retrieves an element from the tree given the object to search for
	 * @param entry element is being retrieved
	 * @return the element that is retrieved
	 * @throws TreeException if the BST is empty and contains zero elements
	 */
	public E getEntry(E entry)  throws TreeException;
	
	/**
	 * Inserts an element within the BST in accordance to the BST rules
	 * @param entry element to be inserted
	 * @return true if element is added successfully, otherwise false
	 * @throws NullPointerException if the element being added is null
	 */
	public boolean add(E entry) throws NullPointerException;
	
	/**
	 * Returns an Iterator object that iterates through the BST through LVR
	 * @return in-order traversal Iterator Object  
	 */
	public Iterator<E> inorderIterator();
	
	/**
	 * Returns an Iterator object that iterates through the BST through VLR
	 * @return pre-order traversal Iterator Object 
	 */
	public Iterator<E> preorderIterator();
	
	/**
	 * Returns an Iterator object that iterates through the BST through LRV
	 * @return post-order traversal Iterator Object 
	 */
	public Iterator<E> postorderIterator();
}

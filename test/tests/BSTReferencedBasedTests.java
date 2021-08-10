package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import exceptions.TreeException;
import utilities.BSTReferencedBased;
import utilities.Word;
import adts.Iterator;

class BSTReferencedBasedTests {

	/*Initalize our trees for testing use later on*/
	BSTReferencedBased<String> bst1;
	BSTReferencedBased<String> bst2;
	BSTReferencedBased<Word> bst3;
	BSTReferencedBased<Integer> bst4;
	BSTReferencedBased<Integer> bst5;

	/**setup and reset trees before starting tests 
	 * @throws Exception while instansiating new trees 
	*/
	@BeforeEach
	void setUp() throws Exception {
		bst1 = new BSTReferencedBased<String>();
		bst2 = new BSTReferencedBased<String>();
		bst3 = new BSTReferencedBased<Word>();
		bst4 = new BSTReferencedBased<Integer>();
		bst5 = new BSTReferencedBased<Integer>();
	}

	/**
	 * TearDown Structure after each test
	 * @throws Exception while clearing old trees
	 */
	@AfterEach
	void tearDown() throws Exception {
		bst1.clear();
		bst2.clear();
		bst3.clear();
		bst4.clear();
		bst5.clear();
	}
	
	/**
	 * Tests the Add Method of BSTRefrence used to add nodes to tree
	 * @throws TreeException
	 */
	@Test
	void testAdd() throws TreeException {

		bst1.add("a");
		bst1.add("b");
		bst1.add("c");
		assertEquals("a", (bst1.getEntry("a")));
	}

	/**
	 * Tests the Size Method of BSTRefrence which returns the number of nodes
	 */
	@Test
	void testSize() {

		assertEquals(0, bst1.size()); // empty tree size

		bst1.add("a");
		bst1.add("b");

		assertEquals(2, bst1.size()); // incrememnt size

		bst1.clear();

		assertEquals(0, bst1.size()); // reset size test
	}

	/** 
	 * Tests IsEmpty Method of BSTRefrence which returns if the tree structure has any nodes
	*/
	@Test
	void testIsEmpty() {
		
		assertTrue(bst1.isEmpty());

		bst1.add("a");
		bst1.add("b");
		assertFalse(bst1.isEmpty());

		bst1.clear();

		assertTrue(bst1.isEmpty());		
	}

	/**
	 * Tests the clear method of BSTRefrence which is used to reset the tree
	 */
	@Test
	void testClear() {
		bst1.add("a");
		bst1.add("b");
		bst1.clear();

		assertTrue(bst1.isEmpty());
		assertEquals(0, bst1.size()); 
	}

	/**
	 * Tests the contains method of BSTRefrence which is used to check if a value is in the tree
	 * @throws TreeException for cases where the tree is empty
	 */
	@Test
	void testContains() throws TreeException {

		bst1.add("a");
		bst1.add("b");
		bst1.add("c");
		bst1.add("d");

		assertTrue(bst1.contains("a")); // root
		assertTrue(bst1.contains("c")); // middle
		assertTrue(bst1.contains("d")); // end
		assertFalse(bst1.contains("z")); // does not contain
		
	}
	
	/**
	 * Tests iterating over the tree and stopping at a node
	 * @throws TreeException if BST is empty and contains 0 nodes
	 */
	@Test
	void testGetEntry() throws TreeException {
		
		bst1.add("a");
		bst1.add("b");		
		bst1.add("c");

		assertEquals("a", bst1.getEntry("a"));
		assertEquals("b", bst1.getEntry("b"));
		assertEquals("c", bst1.getEntry("c"));
	
	}

	/**
	 * Tests the getRoot method of BSTRefrence which is used to get the root of the tree
	 * @throws TreeException incase there is no root and the tree hasn't been formed 
	 */
	@Test
	void testGetRootData() throws TreeException {

		bst1.add("a");
		bst1.add("b");		
		bst1.add("c");

		assertEquals("a", bst1.getRootData());

	}

	/**
	 * Tests the InOrder Iterator for BSTRefrence where we traverse the tree inorder
	 * @throws TreeException
	 */
	@Test
	void testInOrderIterator() throws TreeException {
		Word word1 = new Word("a");
		Word word2 = new Word("b");
		Word word3 = new Word("c");
		bst3.add(word1);
		bst3.add(word2);
		bst3.add(word3);
		Iterator inorder = bst3.inorderIterator();
		assertTrue(inorder.hasNext());
		assertTrue(((Word) inorder.next()).getWord().equals(word1.getWord()));
	    assertTrue(((Word) inorder.next()).getWord().equals(word2.getWord()));
		assertTrue(((Word) inorder.next()).getWord().equals(word3.getWord()));
	}

	/**
	 * Tests the PreOrder Iterator for BSTRefrence where we traverse the tree PreOrder
	 * @throws TreeException
	 */
	@Test
	void testPreOrderIterator() throws TreeException {
		Word word1 = new Word("a");
		Word word2 = new Word("b");
		Word word3 = new Word("c");
		bst4.add(word1);
		bst4.add(word2);
		bst4.add(word3);
		Iterator preorder = bst4.preorderIterator();
		assertTrue(preorder.hasNext());
		assertTrue(((Word) preorder.next()).getWord().equals(word1.getWord()));
	    assertTrue(((Word) preorder.next()).getWord().equals(word2.getWord()));
		assertTrue(((Word) preorder.next()).getWord().equals(word3.getWord()));    
	}
	
	/**
	 * Tests the PostOrder Iterator for BSTRefrence where we traverse the tree PostOrder
	 * @throws TreeException
	 */
	@Test
	void testPostOrderIterator() throws TreeException {
		Word word1 = new Word("a");
		Word word2 = new Word("b");
		Word word3 = new Word("c");
		bst5.add(word1);
		bst5.add(word2);
		bst5.add(word3);
		Iterator postorder = bst5.postorderIterator();
		assertTrue(postorder.hasNext());
		assertTrue(((Word) postorder.next()).getWord().equals(word3.getWord()));
	    assertTrue(((Word) postorder.next()).getWord().equals(word2.getWord()));
		assertTrue(((Word) postorder.next()).getWord().equals(word1.getWord()));
	}

}

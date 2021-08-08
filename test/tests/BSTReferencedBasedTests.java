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

	BSTReferencedBased<String> bst1;
	BSTReferencedBased<String> bst2;
	BSTReferencedBased<Word> bst3;

	@BeforeEach
	void setUp() throws Exception {
		bst1 = new BSTReferencedBased<String>();
		bst2 = new BSTReferencedBased<String>();
		bst3 = new BSTReferencedBased<Word>();
	}

	@AfterEach
	void tearDown() throws Exception {
		bst1.clear();
		bst2.clear();
		bst3.clear();
	}
	
	@Test
	void testAdd() throws TreeException {

		bst1.add("a");
		bst1.add("b");

		assertEquals("a", bst1.getEntry("a"));
	}

	@Test
	void testSize() {

		assertEquals(0, bst1.size()); // empty tree size

		bst1.add("a");
		bst1.add("b");

		assertEquals(2, bst1.size()); // incrememnt size

		bst1.clear();

		assertEquals(0, bst1.size()); // reset size test
	}

	@Test
	void testIsEmpty() {
		
		assertTrue(bst1.isEmpty());

		bst1.add("a");
		bst1.add("b");
		assertFalse(bst1.isEmpty());

		bst1.clear();

		assertTrue(bst1.isEmpty());		
	}

	@Test
	void testClear() {
		bst1.add("a");
		bst1.add("b");
		bst1.clear();

		assertTrue(bst1.isEmpty());
		assertEquals(0, bst1.size()); 
	}

	@Test
	void testContains() throws TreeException {
		fail("partially implemented");
		/*
		bst1.add("a");
		bst1.add("b");		
		bst1.add("c");
		bst1.add("d");

		assertTrue(bst1.contains("a")); // root
		assertTrue(bst1.contains("c")); // middle
		assertTrue(bst1.contains("d")); // end
		assertFalse(bst1.contains("z")); // does not contain
		*/

	}
	
	@Test
	void testGetEntry() {
		fail("partially implemented");
		/*
		bst1.add("a");
		bst1.add("b");		
		bst1.add("c");

		// TODO index based?
		assertEquals("a", bst1.getEntry("a"));
		assertEquals("b", bst1.getEntry("b"));
		assertEquals("c", bst1.getEntry("c"));
		*/
	}

	@Test
	void testGetRootData() throws TreeException {
		fail("partially implemented");
		/*
		bst1.add("a");
		bst1.add("b");		
		bst1.add("c");

		assertEquals("a", bst1.getRootData());
		*/
	}

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

}

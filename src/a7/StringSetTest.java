package a7;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class StringSetTest {
	/**
	 * Helps to more easily create test StringSets.
	 */
	private StringSet createThreeElementSet(String e1, String e2, String e3) {
		StringSet set = new StringSet();
		set.insert(e1);
		set.insert(e2);
		set.insert(e3);
		return set;
	}

	/**
	 * Checks that all elements of elemsToCheck are contained within set, and fails
	 * if not.
	 */
	private void checkContainsExactly(StringSet set, String[] elemsToCheck, String failureMessage) {
		for (String elem : elemsToCheck)
			assertTrue(set.contains(elem), failureMessage);
		// We also check the size, to make sure that nothing else is contained
		// This test will fail until you have correctly implemented the size() method
		assertEquals(set.size(), elemsToCheck.length, failureMessage);
	}

	/*********** test constructor ************/

	@Test
	public void testConstructorEmpty() {
		StringSet set = new StringSet();
		assertEquals("{}", set.toString(), "Failed constructing empty set -- invalid string representation");
		assertEquals(0, set.size(), "Failed constructing empty set -- invalid size");
	}

	/*********** test insert ************/

	@Test
	public void testInsert() {
		StringSet set = createThreeElementSet("hello", "goodbye", "why");
		String[] expectedElements = { "hello", "goodbye", "why" };
		checkContainsExactly(set, expectedElements, "Failed constructing 3 element set");
	}

	@Test
	public void testInsertDuplicates() {
		StringSet set = createThreeElementSet("hello", "goodbye", "goodbye");
		String[] expectedElements = { "hello", "goodbye" };
		checkContainsExactly(set, expectedElements, "Failed constructing 2 element set with duplicates");
	}

	@Test
	public void testInsertNull() {
		StringSet set = new StringSet();
		try {
			set.insert(null);
			fail("Did not throw exception when calling insert(null)");
		} catch (IllegalArgumentException e) {
			// If we catch an exception, we pass the test
		}
	}

	/*********** test contains ************/

	@Test
	public void testContainsTrue() {
		StringSet set = createThreeElementSet("hello", "goodbye", "why");
		assertTrue(set.contains("hello"), "Failed checking set for an element that it contains");
		assertTrue(set.contains("why"), "Failed checking set for an element that it contains");
	}

	@Test
	public void testContainsFalse() {
		StringSet set = createThreeElementSet("hello", "goodbye", "why");
		assertFalse(set.contains("he"), "Failed checking set for an element that it does not contain");
		assertFalse(set.contains(""), "Failed checking set for an element that it does not contain");
	}

	@Test
	public void testContainsEmptySet() {
		StringSet set = new StringSet();
		assertFalse(set.contains("x"), "Failed checking set for an element that it does not contain");
	}

	@Test
	public void testContainsNull() {
		StringSet set = new StringSet();
		try {
			set.contains(null);
			fail("Did not throw exception when checking contains(null)");
		} catch (IllegalArgumentException e) {
			// If we catch an exception, we pass the test
		}
	}

	/*********** test toString ************/

	@Test
	public void testToStringOneElement() {
		StringSet set = new StringSet();
		set.insert("cat");
		assertEquals("{cat}", set.toString(), "toString({cat}) failed");
	}

	@Test
	public void testToStringTwoElements() {
		StringSet set = new StringSet();
		set.insert("cat");
		set.insert("dog");
		String str = set.toString();
		// Sets are not guaranteed to have a particular ordering, so we must check both
		// orders.
		assertTrue(str.equals("{cat, dog}") || str.equals("{dog, cat}"), "toString({cat, dog}) failed");
	}

	/*********** test size ************/

	// TODO -- fill this in with several test cases for size
	@Test
	public void testSize() {
		StringSet test1 = new StringSet();
		test1.insert("hi");
		test1.insert("how");
		test1.insert("are");
		test1.insert("you");
		assertEquals(4, test1.size(), "Incorrect size. Test failed.");
	}

	/*********** test remove ************/

	// TODO -- fill this in with several test cases for remove
	@Test
	public void testRemove() {
		StringSet test1 = new StringSet();
		test1.insert("hi");
		test1.insert("how");
		test1.insert("are");
		test1.insert("you");
		test1.remove("how");
		assertEquals("{hi, are, you}", test1.toString(), "Incorrect string. Test failed.");
	}

	/*********** test union ************/

	// TODO -- fill this in with several test cases for union
	@Test
	public void testUnion() {
		StringSet test1 = new StringSet();
		test1.insert("hi");
		test1.insert("how");
		test1.insert("are");
		test1.insert("you");

		StringSet test2 = new StringSet();
		test2.insert("I");
		test2.insert("am");
		test2.insert("good");
		test2.insert("you");
		test2.insert("are");
		test2.insert("neat");

		StringSet testUnion = test1.union(test2);

		assertEquals("{hi, how, are, you, I, am, good, neat}", testUnion.toString(), "Incorrect string. Test failed.");
	}

	/*********** test intersection ************/

	// TODO -- fill this in with several test cases for intersection
	@Test
	public void testIntersection() {
		StringSet test1 = new StringSet();
		test1.insert("hi");
		test1.insert("how");
		test1.insert("are");
		test1.insert("you");

		StringSet test2 = new StringSet();
		test2.insert("I");
		test2.insert("am");
		test2.insert("good");
		test2.insert("you");
		test2.insert("are");
		test2.insert("neat");

		StringSet testUnion = test1.intersection(test2);

		assertEquals("{are, you}", testUnion.toString(), "Incorrect string. Test failed.");
	}

}

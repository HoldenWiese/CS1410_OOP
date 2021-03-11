package a5;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

class CompleterTest {

	@Test
	void testReadCitiesFile() throws FileNotFoundException {
		String[] sampleArrExpected = { "5", "applesauce", "fishing", "goldfish", "miracle", "rockets to the moon" };
		String[] sampleArrTest = Completer.readCitiesFile("src/a5/sample.txt");

		String element0Expected = "5";
		String element5Expected = "rockets to the moon";

		assertArrayEquals("Completer.readCitiesFile(" + Arrays.toString(sampleArrExpected) + " failed.",
				sampleArrExpected, sampleArrTest);
		assertEquals(element0Expected, sampleArrTest[0], "Element[0] Test failed.");
		assertEquals(element5Expected, sampleArrTest[5], "Element[5] Test failed.");
	}

	@Test
	void testBinarySearchForKey() {
		String[] test1 = { "abcdef ghi", "bcdef", "cdefg", "defghi", "efghijk", "fghijkl", "ghijklmno", "hijklmn",
				"ijklmno", "jklmnop", "klmnopqrs" };

		assertEquals(0, Completer.binarySearchForKey(test1, "abc"), "binarySearchForKey(test1, \"abc\") failed.");
		assertEquals(7, Completer.binarySearchForKey(test1, "hijk"), "binarySearchForKey(test1, \"hijk\") failed.");
		assertEquals(10, Completer.binarySearchForKey(test1, "klmn"), "binarySearchForKey(test1, \"klmn\") failed.");
		assertEquals(9, Completer.binarySearchForKey(test1, "jk"), "binarySearchForKey(test1, \"jk\") failed.");
		assertEquals(0, Completer.binarySearchForKey(test1, "abcdef ghi"),
				"binarySearchForKey(test1, \"abcdef ghi\") failed.");
		assertEquals(10, Completer.binarySearchForKey(test1, "klmnopqr"),
				"binarySearchForKey(test1, \"klmnopqrs\") failed.");
		assertEquals(-1, Completer.binarySearchForKey(test1, "zebra"),
				"binarySearchForKey(test1, \"zebra\") failed.");
	}

}

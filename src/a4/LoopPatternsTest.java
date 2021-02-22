package a4;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

/**
 * @author wiese
 *
 */
class LoopPatternsTest {

	@Test
	public void lowestAphabeticallyTest() {
		String[] input1 = { "zebra", "dog", "lion", "buffalo", "ape", "corgi", "anteater", "crocodile" };
		String[] input2 = { "word" };
		assertEquals("anteater", LoopPatterns.lowestAlphabetically(input1),
				"lowestAlphabetically(" + Arrays.toString(input1) + ") failed.");
		assertEquals("word", LoopPatterns.lowestAlphabetically(input2),
				"lowestAlphabetically(" + Arrays.toString(input2) + ") failed.");
	}
	
	@Test
	public void findSmallestNumberInTwoArraysTest() {
		int[] input1 = { 10, 8, 7, 5, 3, 0, -3, 6, -1 };
		int[] input2 = { 14, 4, -6, 10, 19, -1, 12 };
		int[] input3 = { 20, 5, 1 };
		int[] input4 = { 105, 12000, 45, 26, 4};
		assertEquals(-6, LoopPatterns.findSmallestNumberInTwoArrays(input1, input2),
				"findSmallestNumberInTwoArraysTest(" + Arrays.toString(input1) + ", " + Arrays.toString(input2)
						+ ") failed.");
		assertEquals(1, LoopPatterns.findSmallestNumberInTwoArrays(input3, input4),
				"findSmallestNumberInTwoArraysTest(" + Arrays.toString(input3) + ", " + Arrays.toString(input4)
						+ ") failed.");
	}

	@Test
	public void findSmallestNumberInTwoArraysTestSpecialCase(){
		int[] input1 = {10, 8, 7, 5, 3, 6};
		int[] input2 = null;
		assertEquals(3, LoopPatterns.findSmallestNumberInTwoArrays(input1, input2), "findSmallestNumberInTwoArraysTest(" 
		+ Arrays.toString(input1) + ", " + Arrays.toString(input2) + ") failed." );
	}
	
	@Test
	public void curveScoresTest() {
		int[] input1 = {45, 56, 67, 75, 85, 95, 100};
		int[] input2 = {0, 1, 5, 25, 50, 75, 99, 100};
		int[] input3 = {55};
		int[] input1Expected = {55, 66, 77, 85, 95, 100, 100};
		int[] input2Expected = {10, 11, 15, 35, 60, 85, 100, 100};
		int[] input3Expected = {65};

		assertArrayEquals("curveScores(" + Arrays.toString(input1) + ") failed.", input1Expected, LoopPatterns.curveScores(input1));
		assertArrayEquals("curveScores(" + Arrays.toString(input2) + ") failed.", input2Expected, LoopPatterns.curveScores(input2));
		assertArrayEquals("curveScores(" + Arrays.toString(input3) + ") failed.", input3Expected, LoopPatterns.curveScores(input3));
	}
}

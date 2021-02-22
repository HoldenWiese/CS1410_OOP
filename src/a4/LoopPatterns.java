package a4;

/**
 * @author wiese This class contains three different methods that utilize
 *         optimization loops.
 *
 *         The first method, lowestAlphabetically(), will return the lowest
 *         String found in an array of Strings by lexicographical comparison of
 *         each element to the lowest element found so far.
 * 
 *         The second method, findSmallestNumberInTwoArrays(), finds and returns
 *         the lowest int found in two int[].
 * 
 *         The third method, curvedScores(), returns and int[] of scores that
 *         curves the input by 10.
 */
public class LoopPatterns {
	/**
	 * This method with iterate through a String array to find and return the String
	 * that is lowest alphabetically. Note: Input will contain at least one element
	 * and all elements will be lower-case.
	 * 
	 * @param lowerCaseWords This parameter is a String[] array of lower-case String
	 *                       words.
	 * @return A String is returned that is the lowest word lexicographically found
	 *         within the array.
	 */
	public static String lowestAlphabetically(String[] lowerCaseWords) {
		String lowest = lowerCaseWords[0];

		for (int i = 0; i < lowerCaseWords.length; i++) {
			if (lowest.compareTo(lowerCaseWords[i]) > 0) {
				lowest = lowerCaseWords[i];
			}
		}

		return lowest;
	}

	/**
	 * This method compares returns the lowest int that is found within 2 int
	 * arrays.
	 * 
	 * @param array1 This int array will have a length of at least 1.
	 * @param array2 This int array may have a length of 0.
	 * @return An int is returned that is the lowest number found in either of the
	 *         arrays.
	 */
	public static int findSmallestNumberInTwoArrays(int[] array1, int[] array2) {
		int array1Lowest = array1[0];
		int array2Lowest = array1[0];
		int lowest = array1Lowest;
		for (int i = 0; i < array1.length; i++) {
			if (array1[i] < array1Lowest) {
				array1Lowest = array1[i];
			}
		}
		if (array2 != null) {
			for (int i = 0; i < array2.length; i++) {
				if (array2[i] < array2Lowest) {
					array2Lowest = array2[i];
				}
			}
		}
		if (array1Lowest < array2Lowest) {
			lowest = array1Lowest;
		} else {
			lowest = array2Lowest;
		}
		return lowest;
	}

	/**
	 * This method will take an array of integers and add 10 to each element. Each
	 * element will only go to a max of 100. A new array is returned with the curved
	 * elements of the input.
	 * 
	 * @param scores This is an array of integers that will be used to created a new
	 *               array with curved scores.
	 * @return A new int[] with the curved scores.
	 */
	public static int[] curveScores(int[] scores) {
		int[] curvedScores = new int[scores.length];

		for (int i = 0; i < scores.length; i++) {
			curvedScores[i] = scores[i] + 10;
			if (curvedScores[i] > 100) {
				curvedScores[i] = 100;
			}
		}

		return curvedScores;
	}
}

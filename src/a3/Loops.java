package a3;

import java.util.Arrays;

/**
 * @author wiese This class contains methods that manipulate arrays.
 */
public class Loops {

	/**
	 * This method takes an int array parameter. It changes every value of the array
	 * to 0. It does not return any value.
	 * 
	 * @param arr An int array that will have all of it's element values changed to
	 *            zero.
	 */
	public static void clearArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			arr[i] = 0;
		}
	}

	/**
	 * This method returns the contents of an int array in a neat string format. For
	 * example, and int array of [1, 2, 3] will return {1, 2, 3}.
	 * 
	 * @param arr Array with values to use to create return String value.
	 * @return Returns a string of the contents of an int array formatted between
	 *         squiggly braces. Ex. "{1, 2, 3}"
	 */
	public static String arrayToString(int[] arr) {
		String arrAsString = "{";
		if (arr.length < 1) {
			arrAsString += "}";
			return arrAsString;
		}
		for (int i = 0; i < arr.length; i++) {
			arrAsString += arr[i];
			if (i < arr.length - 1) {
				arrAsString += ", ";
			}
		}
		arrAsString += "}";
		return arrAsString;
	}

	/**
	 * This method takes and int array and checks if there are more even number or
	 * odd numbers. A boolean of true is return only if there are more even numbers.
	 * 
	 * @param arr An int array that is not null.
	 * @return A boolean. True if the majority of elements are even. False
	 *         otherwise.
	 */
	public static boolean hasMoreEvenThanOdd(int[] arr) {
		int totalEven = 0;
		int totalOdd = 0;

		for (int value : arr) {
			if (value % 2 == 0) {
				totalEven++;
			} else {
				totalOdd++;
			}
		}
		return totalEven > totalOdd;
	}

	/**
	 * This method takes a double array and returns a new array with all of the
	 * elements in reverse order.
	 * 
	 * @param arr A double array that we will use to created new reversed array.
	 * @return A new double[] with all the elements from the input param in reverse.
	 */
	public static double[] reverseArray(double[] arr) {
		int indexReverse = arr.length - 1;
		double[] reversedArr = new double[arr.length];
		for (int i = 0; i < arr.length; i++) {
			reversedArr[i] = arr[indexReverse];
			indexReverse--;
		}
		return reversedArr;
	}
	
	/**
	 * This method produces a new double array that sums an element with its surrounding elements so its value is an average.
	 * 
	 * @param arr This is the input double[]. It is not altered, but used to create new array.
	 * @return Returns a double array.
	 */
	public static double[] smoothArray(double[] arr) {
		double[] averagedArr = new double[arr.length];
		
		for(int i = 0; i < arr.length; i++) {
			if(i == 0) {
				averagedArr[i] = (arr[i] + arr[i+1])/2;
			} else if (i == arr.length - 1) {
				averagedArr[i] = (arr[i] + arr[i-1])/2;
			} else {
				averagedArr[i] = (arr[i-1] + arr[i] + arr[i+1])/3;
			}
		}
		return averagedArr;
	}

	public static void main(String[] args) {
		/* Testing clearArray() */
		int[] testArray1 = { 1, 2, 3, 4, 5, 6 };
		System.out.print("Testing clearArray() with input: " + Arrays.toString(testArray1) + " produces this output: ");
		clearArray(testArray1);
		System.out.println(Arrays.toString(testArray1) + "\n");

		/* Testing arrayToString() */
		int[] testArray2 = { 1, 2, 3, 4, 5, 6 };
		System.out.println("Testing arrayToString() with input: " + Arrays.toString(testArray2)
				+ " produces this output: " + arrayToString(testArray2) + "\n");

		/* Testing hasMoreEvenThanOdd() */
		int[] testArray3 = { 1, 2, 3, 4, 5, 6 };
		int[] testArray4 = { 1, 2, 3, 4, 6, 8, 10 };
		System.out.println("Testing hasMoreEvenThanOdd() with input: " + Arrays.toString(testArray3)
				+ " produces this output: " + hasMoreEvenThanOdd(testArray3));
		System.out.println("Testing hasMoreEvenThanOdd() with input: " + Arrays.toString(testArray4)
				+ " produces this output: " + hasMoreEvenThanOdd(testArray4) + "\n");

		/* Testing reverseArray() */
		double[] testArray5 = { 1.0, 2.0, 3.0, 4.0, 5.0 };
		System.out.println("Testing reverseArray() with input: " + Arrays.toString(testArray5)
				+ " produces this output: " + Arrays.toString(reverseArray(testArray5)) + "\n");

		/* Testing smoothArray() */
		double[] testArray6 = { 0.0, 0.2, 0.7, 0.2 };
		System.out.println("Testing smoothArray() with input: " + Arrays.toString(testArray6)
				+ " produces this output: " + Arrays.toString(smoothArray(testArray6)));
	}
}

package a5;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;
import javax.swing.*;

/**
 * This program acts as a text completion program for names of cities.
 * 
 * @author Prof. David E. Johnson
 *
 */
public class Completer {

	/**
	 * Reads in a file of lowercase city names of the following format, a number N
	 * that specifies the number of cities in the file and then the cities, as
	 * follows: N cityNameAndLocation1 cityNameAndLocation2 ... cityNameAndLocationN
	 * 
	 * The method makes a String array with the cityNameAndLocations. If the
	 * filename is not found, an exception throws back to the calling method. (No
	 * code is needed to detect and throw the exception - it just happens).
	 * 
	 * @param filename the file of city names as described above.
	 * @return an array of the city names and locations.
	 * @throws FileNotFoundException
	 */
	public static String[] readCitiesFile(String filename) throws FileNotFoundException {
		File citiesFile = new File(filename);
		Scanner scan = new Scanner(citiesFile, "utf-8");

		int citiesCount = scan.nextInt();
		String[] citiesArr = new String[citiesCount];
		
		//skip the first line with the number of cities.
		scan.nextLine();

		for (int i = 0; i < citiesCount; i++) {
			citiesArr[i] = scan.nextLine();
		}
		scan.close();

		return citiesArr;
	}

	/**
	 * This is a modified binary search that compares a key String with the Strings
	 * in the cities array.
	 * 
	 * This search does not distinguish between two Strings that have the same first
	 * letters as key. So for a key of "David", "David Johnson" and "David
	 * Letterman" would both count as equal to the key.
	 * 
	 * Assumes cities is sorted in ascending order.
	 * 
	 * @param cities : a sorted array of cities
	 * @param key    : the start of a city.
	 * @return the index where the start of cities matches key, or -1 otherwise.
	 */
	public static int binarySearchForKey(String[] cities, String key) {
		int low = 0;
		int high = cities.length - 1;
		
		while (low <= high) {
			int middle = low + (high - low) / 2;

			if (cities[middle].startsWith(key)) {
				return middle;
			} else if (key.compareTo(cities[middle]) < 0) {
				high = middle - 1;
			} else {
				low = middle + 1;
			}

		}
		return -1;
	}

	/**
	 * This is a modified sequential search that compares a key String with the
	 * Strings in the cities array.
	 * 
	 * This search does not distinguish between two Strings that have the same first
	 * letters as key. So for a key of "David", "David Johnson" and "David
	 * Letterman" would both count as equal to the key.
	 * 
	 * @param cities : an array of cities
	 * @param key    : the start of a city.
	 * @return the index where the start of cities matches key, or -1 otherwise.
	 */
	public static int sequentialSearchForKey(String[] cities, String key) {
		// This method does not need to be modified. Look at the startWith use
		// as a starting point for the binary search code.
		for (int index = 0; index < cities.length; index++) {
			// match any String that has the same beginning as the key
			if (cities[index].startsWith(key))
				return index;
		}
		return -1; // no match was found
	}

	public static void main(String[] args) {
		/*
		 * The CompleterApp reads the cities.txt file using readCitiesFile, sorts the
		 * array and then searches using the search methods from this file.
		 * 
		 * The first argument is the location of the cities file relative to the project
		 * folder.
		 * 
		 * The second argument is "binary" or "sequential" to specify which search
		 * method should be used.
		 * 
		 * The third argument is a boolean flag. If - false: the cities array is used
		 * unchanged - true: each element in the cities array is multiplied to make a
		 * much larger array where the performance of the search matters.
		 */
		boolean makeBig = false;
		CompleterApp app = new CompleterApp("src/a5/cities.txt", "binary", makeBig);
		app.start();
		
	}

}

/*
 * How did I experiment with the application? What did I observer?
 * 
 * I struggled a little bit with the readCitiesFile() method. I was able to get
 * arrays but they all had small errors with the first or last element. I
 * noticed that the first line was appearing blank in the array. I think this is
 * because the scanner read it as an int so it did not put it in the array.
 * Otherwise the array was good. I decided to simply convert the first element
 * to a string after the whole array was populated. I could have checked if each
 * line was a int but that seems like it would be inefficient.
 * 
 * It seems to perform really well. Even when I use the larger array.
 * 
 * The other challenge I had was understanding the .compareTo method. It was a
 * bit confusing at first, but after playing around with it I feel confident I
 * understand it now.
 * 
 * l
 */

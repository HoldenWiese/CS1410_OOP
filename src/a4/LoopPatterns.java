package a4;

import java.awt.Color;
import java.util.Scanner;

/**
 * @author wiese This class contains different methods that utilize optimization
 *         loops.
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
 * 
 *         In addition, there are four methods that allow user to make a
 *         modified version of an image by making it grey, negative, brighter,
 *         or merging two images together.
 * 
 *         The main method runs program that will adjust an image according to
 *         user input. It allows the user to choose how the image is modified
 *         and then shows them the image.
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

	/**
	 * This method will take an image and create a grey scale version of the image.
	 * It does not alter the original image, but returns a new one.
	 * 
	 * @param pic This is the image that will be made grey.
	 * @return Returns type Picture that is converted to greyscale.
	 */
	public static Picture makeGrey(Picture pic) {
		Picture newPic = new Picture(pic);
		for (int row = 0; row < newPic.height(); row++) {
			for (int col = 0; col < newPic.width(); col++) {
				Color color = newPic.get(col, row);
				int red = color.getRed();
				int green = color.getGreen();
				int blue = color.getBlue();
				int grey = (red + green + blue) / 3;
				Color newColor = new Color(grey, grey, grey);
				newPic.set(col, row, newColor);
			}
		}
		return newPic;
	}

	/**
	 * This method takes a Picture parameter and returns a new Picture that is the
	 * negative version of the pic provided.
	 * 
	 * @param pic This is the Picture that we will create negative version of.
	 * @return Picture object is returned.
	 */
	public static Picture makeNegative(Picture pic) {
		Picture newPic = new Picture(pic);
		for (int row = 0; row < newPic.height(); row++) {
			for (int col = 0; col < newPic.width(); col++) {
				Color color = newPic.get(col, row);
				int red = 255 - color.getRed();
				int green = 255 - color.getGreen();
				int blue = 255 - color.getBlue();
				Color newColor = new Color(red, green, blue);
				newPic.set(col, row, newColor);
			}
		}
		return newPic;
	}

	/**
	 * This method takes a number and changes number to RGB valid value if
	 * necessary. If the number is out side of the range of 0 - 255 it changes it to
	 * nearest number.
	 * 
	 * @param num This is the number that will be checked.
	 * @return An int will be returned that will be the same as input or 0, or 255.
	 */
	public static int safeColor(int num) {
		if (num < 0) {
			num = 0;
		} else if (num > 255) {
			num = 255;
		}
		return num;
	}

	/**
	 * This method takes a picture and changes the brightness based on a multiplier
	 * input.
	 * 
	 * @param pic        This is the Picture we will use to make a new brighter
	 *                   image.
	 * @param multiplier This is a double of multiplier adjusting how much brighter
	 *                   the image should be.
	 * @return A new Picture is returned.
	 */
	public static Picture makeBrighter(Picture pic, double multiplier) {
		Picture newPic = new Picture(pic);
		for (int row = 0; row < newPic.height(); row++) {
			for (int col = 0; col < newPic.width(); col++) {
				Color color = newPic.get(col, row);
				double red = multiplier * color.getRed();
				double green = multiplier * color.getGreen();
				double blue = multiplier * color.getBlue();
				int safeRed = safeColor((int) red);
				int safeGreen = safeColor((int) green);
				int safeBlue = safeColor((int) blue);
				Color newColor = new Color(safeRed, safeGreen, safeBlue);
				newPic.set(col, row, newColor);
			}
		}
		return newPic;
	}

	/**
	 * This method uses to Pictures to create a new Picture that is a combination of
	 * the two provided. It does this by setting each pixel to the second pictures
	 * pixel unless the pixel is green.
	 * 
	 * @param pic1 First image to be used.
	 * @param pic2 Second image to be used.
	 * @return A new Picture that is a combination of the first and second.
	 */
	public static Picture mergeImages(Picture pic1, Picture pic2) {
		Picture newPic = new Picture(pic2);
		for (int row = 0; row < newPic.height(); row++) {
			for (int col = 0; col < newPic.width(); col++) {
				Color color1 = pic1.get(col, row);
				Color color2 = pic2.get(col, row);
				if (color2.equals(new Color(0, 255, 0))) {
					newPic.set(col, row, color1);
				}
			}
		}
		return newPic;
	}

	public static void main(String[] args) {
		Picture sourceImage = new Picture("Arches.jpg");
		Picture greenScreenImage = new Picture("cat.png");
		Scanner input = new Scanner(System.in);
		System.out.println("What effect would you like to apply?\n" + "Valid options (do not include the quotes) are\n"
				+ "\"greyscale\", \"negative\", \"brighter\", \"addcat\":");
		String option = input.next();
		if (option.equals("greyscale")) {
			Picture greyImage = makeGrey(sourceImage);
			greyImage.show();
		} else if (option.equals("negative")) {
			Picture negativeImage = makeNegative(sourceImage);
			negativeImage.show();
		} else if (option.equals("brighter")) {
			System.out.println("Enter a number multiplier to adjust brightness.");
			Double multiplier = input.nextDouble();
			Picture brighterPic = makeBrighter(sourceImage, multiplier);
			brighterPic.show();
		} else if (option.equals("addcat")) {
			Picture addCatImage = mergeImages(sourceImage, greenScreenImage);
			addCatImage.show();
		} else {
			System.out.println("Invalid input! Please restart the program.");
		}
		input.close();
	}
}

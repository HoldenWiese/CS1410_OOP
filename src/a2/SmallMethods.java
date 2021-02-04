package a2;

public class SmallMethods {

	/**
	 * Produces boolean true if the input number is equal to 0. If the input is
	 * anything other than 0 false is returned.
	 * 
	 * @param number The number that is provided and checked to see if it is zero.
	 * @return A boolean. Only true if input param is zero.
	 */
	public static boolean isZero(int number) {
		if (number == 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Produces a string based on number input. If number is equal to 0 "Zero" is
	 * returned. Otherwise "Not Zero" is returned
	 * 
	 * @param number This is the number checked to see if it equals 0.
	 * @return A string "Zero" or "Not Zero" based on the value of number argument.
	 */
	public static String describeNumber(int number) {
		if (isZero(number) == true) {
			return "Zero";
		} else {
			return "Not Zero";
		}
	}

	/**
	 * Produces 1 of 3 possible strings based on number param. If number is 0,
	 * "Zero" is returned. If number is greater than 0 "Positive" is returned. If
	 * number is less than 0, "Negative" is returned.
	 * 
	 * @param number The number that is evaluated to determined return statement.
	 * @return A string with value "Zero", "Positive", or "Negative".
	 */
	public static String classifyNumber(int number) {
		if (number == 0) {
			return "Zero";
		} else if (number > 0) {
			return "Positive";
		} else {
			return "Negative";
		}
	}

	/**
	 * This method checks to see if a number is divisible by 2 or 7. If input is
	 * divisible by either number boolean true is returned.
	 * 
	 * @param number This is the number that will be checked.
	 * @return A boolean of true or false based on divisibility. For example, 3 will
	 *         return false and 21 will return true.
	 */
	public static boolean isDivisibleByTwoOrSeven(int number) {
		if (number % 2 == 0) {
			return true;
		} else if (number % 7 == 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Checks to see which of two input numbers is smaller. If they are both the
	 * same then numB is returned.
	 * 
	 * @param numA One of the two input numbers provided to test.
	 * @param numB One of the two input numbers provided to test.
	 * @return A double. Whichever number was smaller or numB in case of tie.
	 */
	public static double chooseSmaller(double numA, double numB) {
		if (numA < numB) {
			return numA;
		} else {
			return numB;
		}
	}

	/**
	 * This method takes a number and multiplies it by two. The product is
	 * multiplied by two repeatedly until product is greater than 50. If the input
	 * is zero, zero is returned.
	 * 
	 * @param number This is the number that will be doubled.
	 * @return Returns an int greater than 50.
	 */
	public static int firstDoublingPastFifty(int number) {
		if (number == 0) {
			return 0;
		}

		number = number * 2;

		while (number < 50) {
			number = number * 2;
		}

		return number;
	}

	/**
	 * This method adds "a " or "an " before a word. "an " is added if a, e, i, o,
	 * or u is the first letter. Otherwise "a " is added. For example, inputing
	 * "octopus" will return "an octopus".
	 * 
	 * @param word Is any word. This word will be used to determined if a or an is
	 *             used.
	 * @return A string is returned of a or an followed by the input word.
	 */
	public static String addIndefiniteArticle(String word) {
		String makeLowerCase = word.toLowerCase();
		char firstLetter = makeLowerCase.charAt(0);

		if (firstLetter == 'a' || firstLetter == 'e' || firstLetter == 'i' || firstLetter == 'o'
				|| firstLetter == 'u') {
			return "an " + word;
		} else {
			return "a " + word;
		}

	}

	/**
	 * This method takes String and loops over it creating a new string by taking
	 * alternating letters staring at the first letter of the string. For example,
	 * "David" will return "Dvd".
	 * 
	 * @param phrase This is the string that is looped and referenced to create a
	 *               new string.
	 * @return A string is returned that is like the input arguement but every other
	 *         char is absent.
	 */
	public static String skipLetters(String phrase) {
		int totalChars = phrase.length();
		int counter = 0;
		String newPhrase = "";
		while (counter < totalChars) {
			if (counter % 2 == 0) {
				newPhrase = newPhrase + phrase.charAt(counter);
			}
			counter++;
		}
		return newPhrase;
	}

	/**
	 * This method takes a number and returns the sum or all numbers less than the
	 * provided number and greater than 0 and are divisible by 2 or 7. For example
	 * input of 8 will return 19. The numbers from 0 up to 8 that are divisible by 2
	 * or 7 are 2, 4, 6, 7. Negative numbers will not work for this method.
	 * 
	 * @param number This is the number that we will use to check all numbers less
	 *               than it.
	 * @return Returns an int of the sum calculated.
	 */
	public static int sumDivisibleByTwoOrSeven(int number) {
		int sum = 0;
		for (int i = 0; i < number; i++) {
			if (i % 2 == 0 || i % 7 == 0) {
				sum = sum + i;
			}
		}
		return sum;
	}

	/**
	 * Produces a String starting and ending with the edge character and having the
	 * inner char repeated in-between. The total number of characters in the string
	 * is width. As an example makeLine('+', '-', 8) would return the string
	 * "+------+".
	 * 
	 * NOTE: This method is already completely implemented and must not be modified
	 * for the assignment.
	 * 
	 * @param edge  The character used at the start and end of the returned string.
	 * @param inner The character repeated in-between the edge char.
	 * @param width The total number of characters in the returned string. Width
	 *              must be greater or equal to 2.
	 * @return A string with width characters.
	 */
	public static String makeLine(char edge, char inner, int width) {
		String line = "";
		int currentLocation = 0;
		// Make the middle part of the line first.
		while (currentLocation < width - 2) {
			line = line + inner;
			currentLocation = currentLocation + 1;
		}
		// Add in the start and end character to the line.
		return edge + line + edge;
	}

	/**
	 * This method creates a string that looks like a square when printed to
	 * console. It uses the makeLine() method to help create each row in the square.
	 * When you put a number in a square is produced that is number * number high
	 * and wide. The lowest allowable input is one. 1 returns "+".
	 * 
	 * @param size This specifies the height and width of the square.
	 * @return A string is returned that prints a square.
	 */
	public static String makeSquare(int size) {
		if (size == 1) {
			return "+";
		}
		String topAndBottom = makeLine('+', '-', size);
		String middle = makeLine('|', ' ', size);
		String result = "";
		for (int i = 0; i < size; i++) {
			if (i == 0) {
				result = topAndBottom + "\n";
			}
			if (i > 0 && i < size - 1) {
				result = result + middle + "\n";
			}
			if (i == size - 1) {
				result = result + topAndBottom;
			}
		}
		return result;
	}

	public static void main(String[] args) {

		/* Testing isZero() */
		int num1 = 12;
		int num2 = 0;
		boolean num1ZeroTest = isZero(num1);
		boolean num2ZeroTest = isZero(num2);
		System.out.println("Testing isZero()");
		System.out.println("isZero() method returned " + num1ZeroTest + " on test input: " + num1);
		System.out.println("isZero() method returned " + num2ZeroTest + " on test input: " + num2);
		System.out.println();

		/* Testing describeNumber() */
		num1 = 13;
		num2 = 0;
		String num1DescribeTest = describeNumber(num1);
		String num2DescribeTest = describeNumber(num2);
		System.out.println("Testing describeNumber()");
		System.out.println("describeNumber() method returned \"" + num1DescribeTest + "\" on test input: " + num1);
		System.out.println("describeNumber() method returned \"" + num2DescribeTest + "\" on test input: " + num2);
		System.out.println();

		/* Testing classifyNumber() */
		num1 = 5;
		num2 = 0;
		int num3 = -4;
		String num1ClassifyTest = classifyNumber(num1);
		String num2ClassifyTest = classifyNumber(num2);
		String num3ClassifyTest = classifyNumber(num3);
		System.out.println("Testing classifyNumber()");
		System.out.println("classifyNumber() method returned \"" + num1ClassifyTest + "\" on test input: " + num1);
		System.out.println("classifyNumber() method returned \"" + num2ClassifyTest + "\" on test input: " + num2);
		System.out.println("classifyNumber() method returned \"" + num3ClassifyTest + "\" on test input: " + num3);
		System.out.println();

		/* Testing isDivisibleByTwoOrSeven() */
		num1 = 16;
		num2 = 49;
		num3 = 95;
		boolean num1IsDivisibleTest = isDivisibleByTwoOrSeven(num1);
		boolean num2IsDivisibleTest = isDivisibleByTwoOrSeven(num2);
		boolean num3IsDivisibleTest = isDivisibleByTwoOrSeven(num3);
		System.out.println("Testing isDivisibleByTwoOrSeven()");
		System.out.println(
				"isDivisibleByTwoOrSeven() method returned " + num1IsDivisibleTest + " on test input: " + num1);
		System.out.println(
				"isDivisibleByTwoOrSeven() method returned " + num2IsDivisibleTest + " on test input: " + num2);
		System.out.println(
				"isDivisibleByTwoOrSeven() method returned " + num3IsDivisibleTest + " on test input: " + num3);
		System.out.println();

		/* Testing chooseSmaller() */
		double num4 = 55;
		double num5 = 88;
		double test1ChooseSmaller = chooseSmaller(num4, num5);
		double test2ChooseSmaller = chooseSmaller(num4, num4);
		double test3ChooseSmaller = chooseSmaller(num5, num4);
		System.out.println("Testing chooseSmaller()");
		System.out.println(
				"chooseSmaller() method returned " + test1ChooseSmaller + " on test input: " + num4 + ", " + num5);
		System.out.println(
				"chooseSmaller() method returned " + test2ChooseSmaller + " on test input: " + num4 + ", " + num4);
		System.out.println(
				"chooseSmaller() method returned " + test3ChooseSmaller + " on test input: " + num5 + ", " + num4);
		System.out.println();

		/* Testing firstDoublingPastFifty() */
		/*
		 * Note: Unclear if numbers greater than 50 should be doubled once or not at
		 * all.
		 */
		num1 = 5;
		num2 = 0;
		num3 = 52;
		int num1FirstDoublingPastFifty = firstDoublingPastFifty(num1);
		int num2FirstDoublingPastFifty = firstDoublingPastFifty(num2);
		int num3FirstDoublingPastFifty = firstDoublingPastFifty(num3);
		System.out.println("firstDoublingPastFifty()");
		System.out.println(
				"firstDoublingPastFifty() method returned " + num1FirstDoublingPastFifty + " on test input: " + num1);
		System.out.println(
				"firstDoublingPastFifty() method returned " + num2FirstDoublingPastFifty + " on test input: " + num2);
		System.out.println(
				"firstDoublingPastFifty() method returned " + num3FirstDoublingPastFifty + " on test input: " + num3);
		System.out.println();

		/* Testing addIndefiniteArticle() */
		String string1 = "ant";
		String string2 = "egg";
		String string3 = "Iguana";
		String string4 = "Octopus";
		String string5 = "undertaker";
		String string6 = "banana";
		String string7 = "Zombie";
		String articleTest1 = addIndefiniteArticle(string1);
		String articleTest2 = addIndefiniteArticle(string2);
		String articleTest3 = addIndefiniteArticle(string3);
		String articleTest4 = addIndefiniteArticle(string4);
		String articleTest5 = addIndefiniteArticle(string5);
		String articleTest6 = addIndefiniteArticle(string6);
		String articleTest7 = addIndefiniteArticle(string7);
		System.out.println("Testing addIndefiniteArticle()");
		System.out.println("addIndefiniteArticle() method returned \"" + articleTest1 + "\" on test input: " + string1);
		System.out.println("addIndefiniteArticle() method returned \"" + articleTest2 + "\" on test input: " + string2);
		System.out.println("addIndefiniteArticle() method returned \"" + articleTest3 + "\" on test input: " + string3);
		System.out.println("addIndefiniteArticle() method returned \"" + articleTest4 + "\" on test input: " + string4);
		System.out.println("addIndefiniteArticle() method returned \"" + articleTest5 + "\" on test input: " + string5);
		System.out.println("addIndefiniteArticle() method returned \"" + articleTest6 + "\" on test input: " + string6);
		System.out.println("addIndefiniteArticle() method returned \"" + articleTest7 + "\" on test input: " + string7);
		System.out.println();

		/* Testing skipLetters() */
		String string8 = "Holden";
		String string9 = "A walk in the park!";
		String string10 = "Hi";
		String skipLettersTest1 = skipLetters(string8);
		String skipLettersTest2 = skipLetters(string9);
		String skipLettersTest3 = skipLetters(string10);
		System.out.println("Testing skipLetters()");
		System.out.println("skipLetters() method returned \"" + skipLettersTest1 + "\" on test input: " + string8);
		System.out.println("skipLetters() method returned \"" + skipLettersTest2 + "\" on test input: " + string9);
		System.out.println("skipLetters() method returned \"" + skipLettersTest3 + "\" on test input: " + string10);
		System.out.println();

		/* Testing sumDivisibleByTwoOrSeven() */
		num1 = 2;
		num2 = 8;
		num3 = 26;
		int sumDivTest1 = sumDivisibleByTwoOrSeven(num1);
		int sumDivTest2 = sumDivisibleByTwoOrSeven(num2);
		int sumDivTest3 = sumDivisibleByTwoOrSeven(num3);
		System.out.println("Testing sumDivisibleByTwoOrSeven()");
		System.out.println("sumDivisibleByTwoOrSeven() method returned " + sumDivTest1 + " on test input: " + num1);
		System.out.println("sumDivisibleByTwoOrSeven() method returned " + sumDivTest2 + " on test input: " + num2);
		System.out.println("sumDivisibleByTwoOrSeven() method returned " + sumDivTest3 + " on test input: " + num3);
		System.out.println();

		/* Testing makeSquare() */
		num1 = 10;
		num2 = 1;
		num3 = 2;
		String makeSquareTest1 = makeSquare(num1);
		String makeSquareTest2 = makeSquare(num2);
		String makeSquareTest3 = makeSquare(num3);
		System.out.println("Testing makeSquare()");
		System.out.println("makeSquare() method returned \n" + makeSquareTest1 + "\non test input: " + num1);
		System.out.println("makeSquare() method returned \n" + makeSquareTest2 + "\non test input: " + num2);
		System.out.println("makeSquare() method returned \n" + makeSquareTest3 + "\non test input: " + num3);
		System.out.println();
	}
}

package a6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Chatter {
	private String greeting;
	private String goodbye;
	private String[] phrases;

	Chatter(String greeting, String goodbye, String phrasesPath) {
		this.greeting = greeting;
		this.goodbye = goodbye;
		this.phrases = loadLinesFromFile(phrasesPath);
	}

	/**
	 * This static method takes a String that is the path to a txt file with a list
	 * of phrases. If the file is not found this method returns and empty string.
	 * This method is static so it may be called without an instance variable.
	 * 
	 * @param path This is a String that is the relative file path to phrases.
	 * @return Returns and array of phrases found within a txt file at the location
	 *         mentioned in the parameter. If file path does not work, an empty
	 *         string array is returned.
	 */
	public static String[] loadLinesFromFile(String path) {
		File phrasesFile = new File(path);
		try {
			Scanner scan = new Scanner(phrasesFile, "utf-8");

			int phrasesCount = scan.nextInt();
			String[] phrasesArr = new String[phrasesCount];

			scan.nextLine();

			for (int i = 0; i < phrasesCount; i++) {
				phrasesArr[i] = scan.nextLine();
			}
			scan.close();

			return phrasesArr;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			return new String[0];
		}
	}

	/**
	 * This is a getter method to get the greeting String instance variable of the
	 * instance of Chatter this is called on.
	 * 
	 * @return Returns the greeting string of the Chatter object.
	 */
	public String sayHello() {
		return greeting;
	}

	/**
	 * This is a getter method to get the goodbye String instance variable of the
	 * instance of Chatter this is called on.
	 * 
	 * @return Returns the goodbye String variable of the Chatter object.
	 */
	public String sayGoodbye() {
		return goodbye;
	}

	/**
	 * This method takes a String parameter, breaks it into words, and returns the
	 * last word of the String.
	 * 
	 * @param phrase This is a string object. The last word in the String is
	 *               returned.
	 * @return Returns a String of the last word found in the provided phrase.
	 */
	private static String lastWord(String phrase) {
		String[] phraseArr = phrase.split(" ");
		return phraseArr[phraseArr.length - 1];
	}

	/**
	 * This method takes a String and checks to see if any word matches any of the
	 * phrases in phrases[]. It takes the last word from the string provided using
	 * the lastWord() method and then itterates over each phrase to check if that
	 * word occurs. If the word is found the method returns the phrase containing
	 * the matching word.
	 * 
	 * @param inputPhrase This is a String object storing the users response to the
	 *                    chat bot.
	 * @return Returns a String. Returns a phrase containing a word that matches the
	 *         last word of the userInput or a String asking the user for more
	 *         information.
	 */
	public String respondToPhrase(String inputPhrase) {
		String word = lastWord(inputPhrase);
		for (int i = 0; i < phrases.length; i++) {
			if (phrases[i].contains(word)) {
				return phrases[i];
			}
		}
		return "Please tell me more about " + inputPhrase;
	}
}

package a9;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author Holden This class extends Chatter. This class takes the shortest
 *         string from the user input and uses that word to return a random
 *         phrase that includes that same word.
 */
public class ChatterCustom extends Chatter {

	/**
	 * The constructor method. This constructor utilizes the constructor from the
	 * abstract Chatter class it inherits from. It initializes a greeting String
	 * property, a goodBye String property, and a phrases String[] property.
	 * 
	 * @param greeting    A String greeting the chatbot uses to introduce itself.
	 * @param goodbye     A String goodby the chatbot uses to say goodby before
	 *                    ending.
	 * @param phrasesPath A String phrase path. This is used in loadlines() to
	 *                    create an array of available chatbot responses.
	 */
	public ChatterCustom(String greeting, String goodbye, String phrasesPath) {
		super(greeting, goodbye, phrasesPath);
		// TODO Auto-generated constructor stub
	}

	/**
	 * This method breaks the user input into strings and puts them in a String[]
	 * that is returned.
	 * 
	 * @param phrase This is the user input that is captured in the abstract class.
	 * @return Returns a String[] of user response of individual words from the
	 *         phrase String.
	 */
	private static String[] getWords(String phrase) {
		String[] words = phrase.split(" ");
		return words;
	}

	/**
	 * This method takes the user input phrase. Parses the phrase into words stored
	 * in words[] String[]. Finds the smallest word in the array. Then builds an
	 * array list of responses that contain the smallest word. Then, returns one of
	 * the responses randomly.
	 * 
	 * @param userPhrase This is the user input that is captured in the abstract
	 *                   class.
	 * @return Returns a String response randomly from possible responses or a
	 *         string asking for more info.s
	 */
	@Override
	public String respondToPhrase(String userPhrase) {
		ArrayList<String> possiblePhrases = new ArrayList<>();
		String[] words = getWords(userPhrase);

		int min = words[0].length();
		int minIndex = 0;

		for (int i = 0; i < words.length; i++) {
			if (words[i].length() < min) {
				min = words[i].length();
				minIndex = i;
			}
		}

		if (words[0].equals("")) {
			return "Please talk to me!";
		}

		for (String phrase : phrases) {
			if (phrase.contains(words[minIndex])) {
				possiblePhrases.add(phrase);
			}
		}

		if (possiblePhrases.size() > 0) {
			Random random = new Random();
			int randomNum = random.nextInt(possiblePhrases.size());
			return possiblePhrases.get(randomNum);
		} else {
			return "Please tell me more about " + userPhrase;
		}
	}
}

package a9;

import java.util.ArrayList;
import java.util.Random;

public class ChatterFullMatch extends Chatter {

	/**
	 * The constructor method. This constructor utilizes the constructor from the
	 * abstract Chatter class it inherits from. It initializes a greeting String
	 * property, a goodBye String property, and a phrases String[] property.
	 * 
	 * @param greeting    A String greeting the chatbot uses to introduce itself.
	 * @param goodbye     A String goodbye the chatbot uses to say goodbye before
	 *                    ending.
	 * @param phrasesPath A String phrase path. This is used in loadlines() to
	 *                    create an array of available chatbot responses.
	 */
	public ChatterFullMatch(String greeting, String goodbye, String phrasesPath) {
		super(greeting, goodbye, phrasesPath);
	}

	/**
	 * This method takes user inputs and returns the last word from their input.
	 * 
	 * @param phrase The user input the Chatter class gets.
	 * @return Returns the last work from the user input. A String.
	 */
	private static String[] getWords(String phrase) {
		String[] words = phrase.split(" ");
		return words;
	}

	/**
	 * This method takes user input. Looks at each word in the input and builds an
	 * array of possible responses from responses that include the same word. A
	 * random match is returned from the possible matches.
	 * 
	 * @param userPhrase A String of the users input.
	 * @return A String of a random response that matches a input, or a default
	 *         String.
	 */
	@Override
	public String respondToPhrase(String userPhrase) {
		ArrayList<String> possiblePhrases = new ArrayList<>();
		String[] words = getWords(userPhrase);
		for (String word : words) {
			for (String phrase : phrases) {
				if (phrase.contains(word)) {
					possiblePhrases.add(phrase);
				}
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

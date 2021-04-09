package a9;

public class ChatterLastWord extends Chatter {

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
	public ChatterLastWord(String greeting, String goodbye, String phrasesPath) {
		super(greeting, goodbye, phrasesPath);
	}

	/**
	 * Breaks apart the phrase into words, and returns the last one. Assumes
	 * punctuation has been removed.
	 * 
	 * @param phrase a sentence.
	 * @return the last word in the phrase.
	 */
	public static String lastWord(String phrase) {
		String[] words = phrase.split(" ");
		return words[words.length - 1];
	}

	/**
	 * Picks a response phrase from phrases by getting the last word in userPhrase
	 * and finding the first line in phrases that contains that word.
	 * 
	 * Provides a default response if no match is found.
	 * 
	 * @param userPhrase a sentence of lower-case words
	 * @return a line from phrases containing the last word in userPhrase
	 */
	@Override
	public String respondToPhrase(String userPhrase) {
		String lastWord = lastWord(userPhrase);
		for (String phrase : phrases) {
			if (phrase.contains(lastWord)) {
				return phrase;
			}
		}
		return "Please tell me more about " + userPhrase;
	}

}

package a8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * This class reads in a file of movie reviews. From that it "learns" what words
 * are associated with good reviews and what are associated with poor reviews.
 * It can then predict the score for a new review that contains those words.
 * 
 * @author Profs. David E. Johnson & Travis Martin
 * @author Holden Wiese
 *
 */
public class MovieReviewPredictor {
	/**
	 * Maps a word to its average score, based on the reviews passed to the
	 * constructor of this class.
	 */
	private HashMap<String, Double> wordValues;

	/**
	 * Constructs a new MovieReviewPredictor by reading in a file of reviews with
	 * scores and using that to create a mapping between a word and its score. At
	 * the end of the constructor, the wordValue HashMap should be filled in and
	 * ready to be used.
	 */
	public MovieReviewPredictor(String filename) {
		// Read in the lines from the filename.
		ArrayList<String> reviews = linesFromFile(filename);
		// Get the word values from the lines and store them in wordValue
		// using the appropriate method(s).
		wordValues = computeWordValues(reviews);
	}

	/**
	 * Reads the lines from the file and stores each in an ArrayList. Each line
	 * should be processed as follows: - the line is set to all lower case -
	 * punctuation is removed by removing all characters that are not a through z or
	 * 0 through 9
	 * 
	 * The processing above can be achieved with the code: line =
	 * line.toLowerCase().replaceAll("[^a-z0-9 ]", "");
	 * 
	 * If the input file is invalid, this method catches the exception, prints a
	 * warning, and returns an empty list.
	 * 
	 * @param filename the name of the file to read
	 * @return an ArrayList of the lines with punctuation removed and made all
	 *         lowercase.
	 */
	public static ArrayList<String> linesFromFile(String filename) {
		ArrayList<String> reviewLines = new ArrayList<>();
		File reviewsFile = new File(filename);
		try {
			Scanner s = new Scanner(reviewsFile);
			while (s.hasNextLine()) {
				String line = s.nextLine();
				line = line.toLowerCase().replaceAll("[^a-z0-9 ]", "");
				reviewLines.add(line);
			}
			s.close();
		} catch (FileNotFoundException e) {
			System.out.println("Warning! File not found exception.");
		}

		return reviewLines;
		// Read the lines from filename
		// For each line, make it lowercase and remove punctuation as described in the
		// javadoc
		// If an exception occurs, catch it and return an empty ArrayList.
	}

	/**
	 * Given an ArrayList of review Strings, computes the total score associated
	 * with each word.
	 * 
	 * So, for the input ["1 bad movie", "2 good movie"], this returns: {"bad": 1,
	 * "good": 2, "movie": 3}.
	 * 
	 * @param reviews An ArrayList of lines representing reviews. The first word in
	 *                each line is a score.
	 * @return a HashMap of each word as a key and its total score as the value
	 */
	public static HashMap<String, Integer> computeScores(ArrayList<String> reviews) {
		HashMap<String, Integer> totalScores = new HashMap<>();
		for (String line : reviews) {
			String[] words = line.split(" ");
			int score = Integer.parseInt(words[0]);
			for (int i = 1; i < words.length; i++) {
				if (!totalScores.containsKey(words[i])) {
					totalScores.put(words[i], score);
				} else {
					int value = totalScores.get(words[i]);
					totalScores.put(words[i], value + score);
				}
			}
		}
//		System.out.println("Word totals: " + totalScores);

		return totalScores;
		// Create a HashMap for your scores.
		// Loop over all the reviews.
		// Break a review into words with String split.
		// Find the score for the review using the first item in the split array and
		// Integer.parseInt.
		// Loop over the rest of the words.
		// For each word, build up the total score HashMap entry.

		// Use these debugging statements as you work on your code, then remove them
		// before submitting.
	}

	/**
	 * Given an ArrayList of review Strings, computes the number of times each word
	 * appears.
	 * 
	 * So, for the input ["1 bad movie", "2 good movie"], this returns: {"bad": 1,
	 * "good": 1, "movie": 2}.
	 * 
	 * @param reviews An ArrayList of lines representing reviews. The first word in
	 *                each line is a score.
	 * @return a HashMap of each word as a key and the number of times it appears in
	 *         the reviews as a value
	 */
	public static HashMap<String, Integer> computeCounts(ArrayList<String> reviews) {
		HashMap<String, Integer> wordCounts = new HashMap<>();
		for (String line : reviews) {
			String[] words = line.split(" ");
			for (int i = 1; i < words.length; i++) {
				if (wordCounts.containsKey(words[i])) {
					int currentCount = wordCounts.get(words[i]);
					wordCounts.put(words[i], currentCount + 1);
				} else {
					wordCounts.put(words[i], 1);
				}
			}
		}
//		System.out.println("Word counts: " + wordCounts);

		return wordCounts;
		// Create a HashMap for your counts.
		// Loop over all the reviews.
		// Break a review into words with String split.
		// Find the score for the review using the first item in the split array
		// Loop over the rest of the words.
		// For each word, build up count HashMap entry.

		// Use these debugging statements as you work on your code, then remove them
		// before submitting.
	}

	/**
	 * Given a list of reviews from the file, this method computes the average score
	 * for each word in the reviews and stores that score in a HashMap where the key
	 * is the word and the value is the average score.
	 * 
	 * To get the average score, this first computes the total score for a word and
	 * the number of times it appears.
	 * 
	 * Further, this only stores the word the HashMap if the score is not an average
	 * word - if the score is less than 1.75 or greater than 2.25.
	 * 
	 * @param reviews An ArrayList of lines representing reviews. The first word in
	 *                each line is a score, and all following words are separated by
	 *                spaces.
	 * @return a HashMap with non-average words as keys, and the "word value" as
	 *         values
	 */
	public static HashMap<String, Double> computeWordValues(ArrayList<String> reviews) {
		// Compute the word total scores and counts using the appropriate method(s).
		HashMap<String, Integer> wordScores = computeScores(reviews);
		HashMap<String, Integer> wordCounts = computeCounts(reviews);
		HashMap<String, Double> wordScoreAveraged = new HashMap<>();

		for (String word : wordScores.keySet()) {
			double score = wordScores.get(word);
			score = score / wordCounts.get(word);
			if (score < 1.75 || score > 2.25) {
				wordScoreAveraged.put(word, score);
			}
		}

		// Build a HashMap of average scores, making sure to only include words with
		// scores
		// < 1.75 or > 2.25

		// Return the HashMap (remove the null return)
		return wordScoreAveraged;
	}

	/**
	 * This method predicts a review score given a review. A review is of the form
	 * "some text all in lower case and no punctuation". The predicted score is the
	 * average wordValue of any non-null word.
	 * 
	 * @param review a String of numbers and lowercase letters.
	 * @return the predicted score, or -1 if the review has no words in wordValue.
	 */
	public double predictScore(String review) {
		// Break the review into words
		String[] words = review.split(" ");
		double totalValueWords = 0.0;
		double score = 0.0;

		// Find the total score for all words in the review that are in the wordValue
		// HashMap. Count up how many words added to the score.
		for (String word : words) {
			if (wordValues.containsKey(word)) {
				score += wordValues.get(word);
				totalValueWords++;
			}
		}

		// Compute the average using the total score and word count.
		if (score == 0.0) {
			return -1;
		} else {
			return score / totalValueWords;
		}
	}

	@Override
	public String toString() {
		return "map: " + wordValues;
	}

	/**
	 * Predict movie reviews by first learning about words in review. (This does not
	 * need to be modified).
	 */
	public static void main(String[] args) throws FileNotFoundException {

		// First write and test your program with the small set of reviews. Then,
		// learn with the big file and try different tests.
//		String learningFilename = "src/a8/MovieReviews.txt";
		String learningFilename = "src/a8/smallReviews.txt";

		// Make an instance of the predictor based on the filename.
		MovieReviewPredictor predictor = new MovieReviewPredictor(learningFilename);
		System.out.println(predictor.wordValues);

		// Test the predictor.
		String testFilename = "src/a8/smallReviews.txt";
		// Read the file of test reviews.
		ArrayList<String> lines = linesFromFile(learningFilename);

		// Loop over each review. Compare the predicted score with the real score.
		for (String line : lines) {
			String[] words = line.split(" ");
			String noScoreLine = "";
			for (int wordIndex = 1; wordIndex < words.length; wordIndex++)
				noScoreLine += words[wordIndex] + " ";
			String prediction = String.format("%.1f", predictor.predictScore(noScoreLine));
			System.out.print("Predicted: " + prediction + " Actual: ");
			System.out.println(line);
		}
	}
}

/*
 * How well did the predictor work? It worded kind of well, but not great. From
 * what I've seen it does do a decent job of predicting a movie score relative
 * to other predictions but the numbers are usually in the range of 1.5-3
 * instead of 0 to 4.
 * 
 * Do you see any trends? Yes it looks like you usually get a score in the range
 * of 1.5-3.0.
 * 
 * Any explanation for why score might not work? It may not work because the
 * words collected are to general. It would likely work a lot better if you
 * programitically only selected certain types of words such and adjectives. Or
 * getting more data and analyzing it manually to correct errors might help.
 */
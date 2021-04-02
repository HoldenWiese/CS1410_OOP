package a8;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class MovieReviewPredictorTest {

	/* Creating some resources to run tests on */
	String learningFilename = "src/a8/smallReviews.txt";
	ArrayList<String> reviews = MovieReviewPredictor.linesFromFile(learningFilename);
	MovieReviewPredictor predictor1 = new MovieReviewPredictor(learningFilename);
	String testReview1 = "this quiet introspective and entertaining independent is worth seeking";
	String testReview2 = "pretty bad decent movie";

	String invalidFilename = "";
	MovieReviewPredictor predictor2 = new MovieReviewPredictor(invalidFilename);

	/* TEST CONSTRUCTOR */
	@Test
	void testMovieReviewPredictor() {
		assertEquals("map: {pretty=3.0, movie=2.3333333333333335, bad=0.0, excellent=4.0, decent=3.0}",
				predictor1.toString(), "contstructor didn't create expected map");
		assertEquals("map: {}", predictor2.toString(), "contstructor didn't create expected map");
	}

	/* TEST LinesFromFile() */
	@Test
	void testLinesFromFile() {
		assertEquals("[4 a excellent movie, 0 a bad movie, 3 pretty decent movie]",
				predictor1.linesFromFile(learningFilename).toString(), "Test failed: unexpected Array result");
		assertEquals("[]", predictor1.linesFromFile(invalidFilename).toString(),
				"Test failed: unexpected Array result");
	}

	/* TEST computeScore() */
	@Test
	void testComputeScores() {
		assertEquals(3, MovieReviewPredictor.computeScores(reviews).get("pretty"),
				"Test failed: unexpected HashMap result");
	}

	@Test
	void testComputeCounts() {
		assertEquals(1, MovieReviewPredictor.computeCounts(reviews).get("pretty"),
				"Test failed: unexpected HashMap result");
	}

	@Test
	void testComputeWordValues() {
		assertEquals(3.0, MovieReviewPredictor.computeWordValues(reviews).get("pretty"),
				"Test failed: unexpected HashMap result");
	}

	@Test
	void testPredictScore() {
		assertEquals(-1.0, predictor1.predictScore(testReview1), "Test failed: unexpected result");
		assertEquals(2.0833333333333335, predictor1.predictScore(testReview2), "Test failed: unexpected result");
	}

}

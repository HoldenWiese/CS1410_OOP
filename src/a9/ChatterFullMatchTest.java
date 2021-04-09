package a9;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ChatterFullMatchTest {

	Chatter botFull = new ChatterFullMatch("Hi, what would you like to talk about?", "It was nice chatting with you!",
			"src/a9/phrases.txt");

	@Test
	void testRespondToPhrase() {
		assertEquals("which is better, the spaghetti or chicken salad?", botFull.respondToPhrase("chicken"),
				"Test failed: Expected: \"which is better, the spaghetti or chicken salad?\"");
	}

}

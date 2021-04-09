package a9;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ChatterCustomTest {

	Chatter botCustom = new ChatterCustom("Hi, what would you like to talk about?", "It was nice chatting with you!",
			"src/a9/phrases.txt");

	@Test
	void testRespondToPhrase() {
		assertEquals("which is better, the spaghetti or chicken salad?", botCustom.respondToPhrase("chicken"),
				"Test failed: Expected: \"which is better, the spaghetti or chicken salad?\"");
	}

}

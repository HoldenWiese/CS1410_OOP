package a9;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ChatterLastWordTest {

	ChatterLastWord botLast = new ChatterLastWord("Hi, what would you like to talk about?",
			"It was nice chatting with you!", "src/a9/phrases.txt");

	@Test
	void testRespondToPhrase() {
		assertEquals("are you okay?", botLast.respondToPhrase("okay"), "Test failed: Expected: \"Are you okay?\"");
	}

	@Test
	void testChatterLastWord() {
		assertEquals("doing", botLast.lastWord("how are you doing"), "Test failed: Expected: \"doing\"");
	}

	@Test
	void testChatterSayHello() {
		assertEquals("Hi, what would you like to talk about?", botLast.sayHello(),
				"Test failed: Expected: Hi, what would you like to talk about?");
	}

	@Test
	void testChatterSayGoodbye() {
		assertEquals("It was nice chatting with you!", botLast.sayGoodbye(),
				"Test failed: Expected: \"It was nice chatting with you!\"");
	}
}

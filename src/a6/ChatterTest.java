package a6;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.Test;

class ChatterTest {
	a6.Chatter chatBot1 = new a6.Chatter("Hello", "Bye", "src/a6/phrases.txt");
	a6.Chatter chatBot2 = new a6.Chatter("Hi", "GOODB", "src/a6/phrases.txt");
	a6.Chatter chatBot3 = new a6.Chatter("Oy", "gb", "");

	String[] phrases1Arr = Chatter.loadLinesFromFile("src/a6/phrases.txt");
	String[] phrases2Arr = Chatter.loadLinesFromFile("src/dontexist/a6/phrases.txt");

	@Test
	void testLoadLinesFromFile() {
		assertEquals("i'm good", phrases1Arr[0], "Test failed: First element in array incorrect.");
		assertEquals("my house is close to the bank", phrases1Arr[phrases1Arr.length - 1],
				"Test failed: Last element in array incorrect.");
		assertEquals(994, phrases1Arr.length, "Test failed: Array length incorrect.");
		assertEquals(0, phrases2Arr.length, "Test failed: Array length incorrect.");
	}

	@Test
	void testSayHello() {
		assertEquals("Hello", chatBot1.sayHello(), "Test failed: Unexpected response.");
		assertEquals("Hi", chatBot2.sayHello(), "Test failed: Unexpected response.");
		assertEquals("Oy", chatBot3.sayHello(), "Test failed: Unexpected response.");
	}

	@Test
	void testSayGoodbye() {
		assertEquals("Bye", chatBot1.sayGoodbye(), "Test failed: Unexpected response.");
		assertEquals("GOODB", chatBot2.sayGoodbye(), "Test failed: Unexpected response.");
		assertEquals("gb", chatBot3.sayGoodbye(), "Test failed: Unexpected response.");
	}

	@Test
	void testRespondToPhrase() {
		assertEquals("is your father home?", chatBot1.respondToPhrase("i'm home"), "Test failed: Unexpected output.");
		assertEquals("i'm tired", chatBot1.respondToPhrase("the sunset is red"), "Test failed: Unexpected output.");
		assertEquals("Please tell me more about today has been neat", chatBot1.respondToPhrase("today has been neat"),
				"Test failed: Unexpected output.");
	}

}

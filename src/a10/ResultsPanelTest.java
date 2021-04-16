package a10;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ResultsPanelTest {

	ResultsPanel testing = new ResultsPanel();
	RPS rock = RPS.ROCK;
	RPS paper = RPS.PAPER;
	RPS scissors = RPS.SCISSORS;

	@Test
	void testDetermineWinnerHumanWins() {
		assertEquals("Human Wins!", testing.determineWinner(rock, scissors), "Test failed: Expected Human Wins!");
		assertEquals("Human Wins!", testing.determineWinner(paper, rock), "Test failed: Expected Human Wins!");
		assertEquals("Human Wins!", testing.determineWinner(scissors, paper), "Test failed: Expected Human Wins!");
	}
	
	@Test
	void testDetermineWinnerComputerWins() {
		assertEquals("Computer Wins!", testing.determineWinner(rock, paper), "Test failed: Expected Computer Wins!");
		assertEquals("Computer Wins!", testing.determineWinner(paper, scissors), "Test failed: Expected Computer Wins!");
		assertEquals("Computer Wins!", testing.determineWinner(scissors, rock), "Test failed: Expected Computer Wins!");
	}
	
	@Test
	void testDetermineWinnerTie() {
		assertEquals("Tie Game!", testing.determineWinner(rock, rock), "Test failed: Expected Tie Game!");
		assertEquals("Tie Game!", testing.determineWinner(paper, paper), "Test failed: Expected Tie Game!");
		assertEquals("Tie Game!", testing.determineWinner(scissors, scissors), "Test failed: Expected Tie Game!");
	}
}

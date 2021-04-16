package a10;

import java.awt.GridLayout;

import javax.swing.*;

/**
 * Displays the results of a the current round of RPS.
 */
@SuppressWarnings("serial")
public class ResultsPanel extends JPanel {
	
	JLabel humanChoice;
	JLabel computerChoice;
	JLabel winner;
	
	public ResultsPanel(){
		humanChoice = new JLabel("human choice: no selection");
		computerChoice = new JLabel("computer choice: no selection");
		winner = new JLabel("winner: none");
		
    	GridLayout grid = new GridLayout(3, 1, 10, 10);
    	setLayout(grid);
    	
    	add(humanChoice);
    	add(computerChoice);
    	add(winner);
    	
	}
	
    /**
     * Updates this panel to display the two provided moves
     * plus the winner when the provided moves are played against
     * each other in a game of Rock Paper Scissors.
     * 
     * @param human the move of the human player
     * @param computer the move of the computer player
     */
    public void updateResults(RPS human, RPS computer) {
        // TODO: Implement this method and the rest of the class
    	if(human == RPS.ROCK) {
    		humanChoice.setText("human choice: Rock!");
    	} else if(human == RPS.PAPER) {
    		humanChoice.setText("human choice: Paper!");
    	} else {
    		humanChoice.setText("human choice: Scissors!");
    	}
    	
    	if(computer == RPS.ROCK) {
    		computerChoice.setText("computer choice: Rock!");
    	} else if(computer == RPS.PAPER) {
    		computerChoice.setText("computer choice: Paper!");
    	} else {
    		computerChoice.setText("computer choice: Scissors!");
    	}
    	
    	winner.setText(determineWinner(human, computer));
    }
    
    public String determineWinner(RPS human, RPS computer) {
    	if(human == RPS.ROCK && computer == RPS.ROCK) {
    		return "Tie Game!";
    	} else if(human == RPS.ROCK && computer == RPS.PAPER) {
    		return "Computer Wins!";
    	} else if(human == RPS.ROCK && computer == RPS.SCISSORS) {
    		return "Human Wins!";
    	} else if(human == RPS.PAPER && computer == RPS.ROCK) {
    		return "Human Wins!";
    	} else if(human == RPS.PAPER && computer == RPS.PAPER) {
    		return "Tie Game!";
    	} else if(human == RPS.PAPER && computer == RPS.SCISSORS) {
    		return "Computer Wins!";
    	} else if(human == RPS.SCISSORS && computer == RPS.ROCK) {
    		return "Computer Wins!";
    	} else if(human == RPS.SCISSORS && computer == RPS.PAPER) {
    		return "Human Wins!";
    	} else {
    		return "Tie Game!";
    	}
    }
    
    public static void main(String[] args) {
        JFrame testFrame = new JFrame("test results");
        
        // Code similar to the following can be used to test
        // this panel on its own. You can create a panel
        // and call methods on it without worrying
        // how the other panels interact with it.
        ResultsPanel testPanel = new ResultsPanel();
        testFrame.setContentPane(testPanel);
        testPanel.updateResults(RPS.ROCK, RPS.PAPER);
        
        testFrame.pack();
        testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        testFrame.setVisible(true);
    }
}

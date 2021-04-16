package a10;

import java.awt.GridLayout;

import javax.swing.*;

/**
 * This is the main class to create a GUI for playing
 * Rock Paper Scissors (RPS).
 * 
 * This GUI has 3 main functionalities:
 * 1. A panel for toggling the type of computer opponent. The
 *    computer opponent is the person who the user of this GUI
 *    will be playing against, and different opponents may use
 *    different strategies for playing their moves.
 * 2. A panel for displaying the results of each round of RPS.
 *    This panel displays the move that the human made,
 *    the move that the computer made, and this round's winner.
 * 3. A panel allowing the human user to choose a RPS move. When
 *    this move is chosen, the currently selected computer opponent
 *    makes its move, and then the results are updated accordingly.
 */
@SuppressWarnings("serial")
public class Battle extends JFrame {
    private OpponentPanel opponentPanel = new OpponentPanel();
    private ResultsPanel resultsPanel = new ResultsPanel();
    private HumanMovePanel humanMovePanel = new HumanMovePanel(this);

    public Battle() {
        super("Battle");
        // TODO: Create & add extra components for the other
        //       functionalities of this panel.
        add(opponentPanel);
        add(resultsPanel);
        add(humanMovePanel);
        setLayout(new GridLayout(1, 3, 10, 10));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
    }
    
    /**
     * Coordinates between the panels in this object whenever the
     * user takes their turn. Makes a new move in the RPS game.
     */
    public void processTurn(RPS humanChoice) {
    	Opponent computer = opponentPanel.getOpponent();
    	resultsPanel.updateResults(humanChoice, computer.getResponse(humanChoice));
        // TODO: Implement this method. This should get a computer
        // response and update the results display.
    }
    
    public static void main(String[] args) {
        Battle b = new Battle();
        b.setVisible(true);
    }
}
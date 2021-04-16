package a10;

/**
 * For this turn's move, returns whatever the human played last turn.
 * 
 * This opponent always plays ROCK as its first move.
 */
public class CopyPreviousOpponent implements Opponent {
	private RPS lastMove;
    @Override
    public RPS getResponse(RPS humanMove) {
        // TODO: Implement this method, adding extra details to the class as necessary
    	if(lastMove == null) {
    		lastMove = humanMove;
    		return RPS.ROCK;
    	} else {
    		RPS temp = lastMove;
    		lastMove = humanMove;
    		return temp;
    	}
    }
    
    public void setLastMove(RPS humanMove) {
    	lastMove = humanMove;
    }
}

package a10;

import java.util.Random;

/**
 * Returns a random response independent of the human's move.
 */
public class RandomOpponent implements Opponent {
    @Override
    public RPS getResponse(RPS humanMove) {
        // TODO: implement this method
    	Random random = new Random();
        int randomValue = random.nextInt(3);
        return RPS.values()[randomValue];
    }
}

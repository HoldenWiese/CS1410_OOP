package a11;

/**
 * @author Holden
 *
 */
public class CowPlant extends Plant {
	private int regenerateHealthAmount;

	/**
	 * Similar to the plant class but with the addition of a regenerateHealthAmount
	 * field. This is how much health regenerates every cool down.
	 */
	public CowPlant(int xPosition, int yPosition, int size, String imgPath, int health, int coolDown, int attackDamage,
			int regenerateHealthAmount) {
		super(xPosition, yPosition, size, imgPath, health, 0, attackDamage);
		this.regenerateHealthAmount = regenerateHealthAmount;
	}

	/**
	 * The cow can regenerate a specific amount of health every cool down. This
	 * method overrides the actOn method to accomplish this.
	 */
	@Override
	public void actOn(Plant other) {
		if (isReadyForAction() && (this.getHealth() <= this.getFullHealth() - regenerateHealthAmount)) {
			this.changeHealth(regenerateHealthAmount);
			resetCoolDown();
		}
	}

}

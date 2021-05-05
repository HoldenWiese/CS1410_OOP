package a11;

import java.util.Random;

public class FarmerZombie extends Zombie {
	private int criticalHitDamage;
	private double criticalHitChance;

	/**
	 * The Farmer zombie is capable of landing a critical hit. Specify a critical
	 * hit chance in and multiplier in this constructor.
	 */
	public FarmerZombie(int xPosition, int yPosition, int size, String imgPath, int health, int coolDown, int speed,
			int attackDamage, int criticalHitMultiplier, double criticalHitChance) {
		super(xPosition, yPosition, size, imgPath, health, coolDown, speed, attackDamage);
		this.criticalHitDamage = this.attackDamage * criticalHitMultiplier;
		this.criticalHitChance = criticalHitChance;
	}

	/**
	 * This method generates a boolean. I works by taking the percent chance of
	 * critical hit and generating a random number.
	 * 
	 * @return
	 */
	public boolean criticalHit() {
		Random rand = new Random();
		double upperBound = 1.0 / this.criticalHitChance;
		if (rand.nextInt((int) upperBound) == (int) upperBound - 1) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Override includes addition of critical hit condition.
	 */
	@Override
	public void actOn(Plant other) {
		if (isColliding(other)) {
			if (isReadyForAction()) {
				if (criticalHit()) {
					other.changeHealth(-criticalHitDamage);
				} else {
					other.changeHealth(-attackDamage);
				}
				resetCoolDown();
			}
		}
	}
}

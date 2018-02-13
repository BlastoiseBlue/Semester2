package project3;

public class SnakeAlien extends Alien {
	private int snakeDamage = 10;

	public int getDamage() {
		return snakeDamage;
	}

	public SnakeAlien(int h, String n) {
		super(h, n);
	}
}

package project3;

public class OgreAlien extends Alien {
	private int ogreDamage = 6;

	public int getDamage() {
		return ogreDamage;
	}

	public OgreAlien(int h, String n) {
		super(h, n);
	}
}

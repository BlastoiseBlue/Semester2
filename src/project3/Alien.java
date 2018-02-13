package project3;

public abstract class Alien {
//	public static final int SNAKE_ALIEN = 0;
//	public static final int OGRE_ALIEN = 1;
//	public static final int MARSHMALLOW_MAN_ALIEN = 2;
//	public int type;// Stores one of the three above types
	public int health;// 0=dead, 100=full
	public String name;
	/*
	 * Returns the damage value of the alien in question
	 */
	public abstract int getDamage();

	public Alien(int h, String n) {
		name = n;
		health = h;
	}

	public static class AlienPack {
		private Alien[] aliens;

		public AlienPack(int numAliens) {
			aliens = new Alien[numAliens];
		}
		/*
		 * Adds an alien to the pack
		 * 
		 * @param newAlien The alien to be added
		 * @param index The alien's position in the pack
		 */
		public void addAlien(Alien newAlien, int index) {
			aliens[index] = newAlien;
		}
		/*
		 * Returns the array of aliens
		 * 
		 * @return aliens The array of aliens
		 */
		public Alien[] getAliens() {
			return aliens;
		}
		/*
		 * Calculates the total amount of damage dealt by the pack
		 * 
		 * @return damage The total damage dealt by the pack
		 */
		public int calculateDamage() {
			int damage = 0;
			for (int i = 0; i < aliens.length; i++) {
				damage += aliens[i].getDamage();
			}
			return damage;
		}
	}

	public static void main(String[] args) {
		OgreAlien brutus=new OgreAlien(100,"brutus");
		SnakeAlien slimy=new SnakeAlien(100,"slimy");
		MarshmallowManAlien puffy=new MarshmallowManAlien(100,"puffy");
		AlienPack pack=new AlienPack(3);
		pack.addAlien(brutus, 0);
		pack.addAlien(slimy, 1);
		pack.addAlien(puffy, 2);
		System.out.println("Total pack damage = "+pack.calculateDamage());
	}

}

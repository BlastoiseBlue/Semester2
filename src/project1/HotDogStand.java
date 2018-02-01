/*
 * @author Emmet Stanevich
 * Created on 1/11/18
 * Edited on 2/1/18
 * Project 1
 */
package project1;

public class HotDogStand {
	private int sold = 0;
	private int morningSold = 0;
	private int afternoonSold = 0;
	private int id;
	private static int morningTotal = 0;
	private static int afternoonTotal = 0;
	private static int totalSold = 0;
	private static int nextId = 1;

	/*
	 * Constructor for class HotDogStand
	 * 
	 * @param inputId ID to be used for the stand
	 * 
	 * @param alreadySold Tracks how many hot dogs have been sold already by the
	 * time the stand is registered
	 */
	public HotDogStand(int inputId, int alreadySold) {
		id = inputId;
		morningSold = alreadySold;
		sold = alreadySold;
		morningTotal += alreadySold;
		totalSold += alreadySold;
	}

	/*
	 * Sells a specified number of hot dogs in the morning
	 * 
	 * @param s The number of hot dogs to increase the counter by
	 */
	public void sellMorning(int s) {
		morningSold += s;
		totalSold += s;
		morningTotal += s;
		sold += s;
		System.out.println("Stand " + this.id + " sells " + s);
	}

	/*
	 * Sells 1 hot dog in the morning
	 */
	public void sellMorning() {
		sellMorning(1);
	}

	/*
	 * Sells a specified number of hot dogs in the afternoon
	 * 
	 * @param s The number of hot dogs to increase the counter by
	 */
	public void sellAfternoon(int s) {
		afternoonSold += s;
		sold += s;
		afternoonTotal += s;
		totalSold += s;
		System.out.println("Stand " + this.id + " sells " + s);
	}

	/*
	 * Sells 1 hot dog in the afternoon
	 */
	public void sellAfternoon() {
		sellAfternoon(1);
	}

	/*
	 * Prints out the number of hot dogs sold that morning by all stands
	 */
	public static void outputMorningTotal() {
		System.out.println("Total sold this morning: " + morningTotal);
	}

	/*
	 * Prints out the number of hot dogs sold by an individual stand that morning
	 */
	public void outputMorning() {
		System.out.println("Stand " + this.id + " sold " + morningSold + " hot dogs this morning");
	}

	/*
	 * Prints out the number of hot dogs sold that afternoon by all stands
	 */
	public static void outputAfternoonTotal() {
		System.out.println("Total sold this afternoon: " + afternoonTotal);
	}

	/*
	 * Prints out the number of hot dogs sold that afternoon by an individual stand
	 */
	public void outputAfternoon() {
		System.out.println("Stand " + this.id + " sold " + afternoonSold + " hot dogs this afternoon");
	}

	/*
	 * Prints out the number of hot dogs sold that day between all stands
	 */
	public static void outputDailyTotal() {
		System.out.println("Between the " + (HotDogStand.nextId - 1) + " stands, " + (HotDogStand.totalSold)
				+ " hot dogs were sold today");
	}

	/*
	 * Prints out the number of hot dogs sold by a specific stand taht day
	 */
	public void outputDaily() {
		System.out.println("Stand " + this.id + " sold " + sold + " hotdogs today");
	}

	/*
	 * Returns the ID of the stand
	 */
	public int getId() {
		return id;
	}

	public static void main(String[] args) {
		HotDogStand[] stand = new HotDogStand[3];
		for (int i = 0; i < stand.length; i++) {
			stand[i] = new HotDogStand(i + 1, 0);
		}
		stand[0].sellMorning();
		stand[1].sellMorning(2);
		stand[0].sellMorning();
		HotDogStand.outputMorningTotal();
		stand[1].sellAfternoon();
		stand[0].sellAfternoon();
		stand[2].sellAfternoon();
		HotDogStand.outputAfternoonTotal();
		HotDogStand.outputDailyTotal();
	}
	/*
	 * Stand 1 sells 1 Stand 2 sells 2 Stand 1 sells 1 Total sold this morning: 4
	 * Stand 2 sells 1 Stand 1 sells 1 Stand 3 sells 1 Total sold this afternoon: 3
	 * Between the 0 stands, 7 hot dogs were sold today
	 */
}

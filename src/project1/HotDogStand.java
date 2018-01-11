/*
 * Emmet Stanevich
 * 1/11/18
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

	// public HotDogStand() {
	// claimId();
	// }
	public HotDogStand(int inputId, int alreadySold) {
		id = inputId;
		morningSold = alreadySold;
		sold = alreadySold;
		morningTotal += alreadySold;
		totalSold += alreadySold;
	}

	// private void calibrate() {
	// sold = morningSold + afternoonSold;// Sets the total sold
	// }

	public void sellMorning(int s) {
		morningSold += s;
		totalSold += s;
		morningTotal += s;
		sold += s;
		System.out.println("Stand " + this.id + " sells " + s);
	}

	public void sellMorning() {
		sellMorning(1);
	}

	public void sellAfternoon(int s) {
		afternoonSold += s;
		sold += s;
		afternoonTotal += s;
		totalSold += s;
		System.out.println("Stand " + this.id + " sells " + s);
	}

	public void sellAfternoon() {
		sellAfternoon(1);
	}

	// private void claimId() {
	// id = nextId;
	// nextId++;
	// }

	public static void outputMorningTotal() {
		System.out.println("Total sold this morning: " + morningTotal);
	}

	public void outputMorning() {
		System.out.println("Stand " + this.id + " sold " + morningSold + " hot dogs this morning");
	}

	public static void outputAfternoonTotal() {
		System.out.println("Total sold this afternoon: " + afternoonTotal);
	}

	public void outputAfternoon() {
		System.out.println("Stand " + this.id + " sold " + afternoonSold + " hot dogs this afternoon");
	}

	public static void outputDailyTotal() {
		System.out.println("Between the " + (HotDogStand.nextId - 1) + " stands, " + (HotDogStand.totalSold)
				+ " hot dogs were sold today");
	}

	public void outputDaily() {
		System.out.println("Stand " + this.id + " sold " + sold + " hotdogs today");
	}

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
	 *  Stand 1 sells 1
	 *  Stand 2 sells 2
	 *  Stand 1 sells 1
	 *  Total sold this morning: 4
	 *  Stand 2 sells 1
	 *  Stand 1 sells 1
	 *  Stand 3 sells 1
	 *  Total sold this afternoon: 3
	 *  Between the 0 stands, 7 hot dogs were sold today
	 */
}

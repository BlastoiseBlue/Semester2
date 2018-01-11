/*
 * Emmet Stanevich
 * 1/11/18
 * Project 1
 */
package project1;

public class Driver {

	public static void main(String[] args) {
		HotDogStand[] stand = new HotDogStand[3];
		for (int i = 0; i < stand.length; i++) {
			stand[i] = new HotDogStand(i+1, 0);
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

}

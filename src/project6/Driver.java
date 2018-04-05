/**
 * Driver.java
 * 
 * This program will run each program from project6
 */
package project6;

import java.util.Scanner;

/**
 * @author emmet Created: March 3 2018
 */
public class Driver {

	/**
	 * @param args
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner kbd = new Scanner(System.in);
		System.out.println("Which program would you like to run?");
		int x;
		do {
			x = kbd.nextInt();
			kbd.nextLine();
			switch (x) {
			case 1:
				Program1 p1 = new Program1();
				break;
			case 2:
				System.out.println("Enter the substring to count: ");
				Program2 p2 = new Program2(kbd.nextLine());
				break;
			case 3:
				int n;
				do {
					System.out.println("Enter the digit to search for: ");
					n = kbd.nextInt();
				} while (n < 0 || n > 9);
				Program3 p3 = new Program3(n);
				break;
			}
		} while (x > 3 || x < 0);
	}
}

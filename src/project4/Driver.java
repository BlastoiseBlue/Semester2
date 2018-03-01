/*
 * Divisor.java
 * 
 * This program accepts 2 integers as input and divides them
 * 
 * Created: Thur Mar 1 2018
 * @author Emmet Stanevich
 */
package project4;

import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num1, num2;
		double ratio;
		boolean error = false;
		do {
			try {
				error = false;
				num1 = scan.nextInt();
				
			} catch (Exception e) {

			}
		} while (error);
	}

}

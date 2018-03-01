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
import java.util.InputMismatchException;

public class Driver {
	static void ReturnRatio() {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		int numerator = 0, denominator = 0;
		double ratio;
		boolean error = false;
		do {
			error = false;
			try {
				System.out.println("Please input the numerator:");
				numerator = scan.nextInt();
				if (numerator < 0)
					throw new NegativeInputException(); // Throws an exception if the input is negative
			} catch (InputMismatchException e) {
				error = true;
				scan.nextLine();
				System.out.println("ERROR: INPUT MISMATCH");
			} catch (NegativeInputException e) {
				error = true;
				System.out.println(e.getMessage());
				scan.nextLine();
			} catch (Exception e) {
				error = true;
				System.out.println(e.getMessage());
				scan.nextLine();
			}
		} while (error);
		do {
			error = false;
			try {
				error = false;
				System.out.println("Please input the denominator:");
				denominator = scan.nextInt();
				if (denominator == 0)
					throw new DivideByZeroException(); // Throws an exception if the denominator is zero
				if (denominator < 0)
					throw new NegativeInputException();
			} catch (InputMismatchException e) {
				error = true;
				scan.nextLine();
				System.out.println(e.getMessage());
			} catch (NegativeInputException e) {
				error = true;
				System.out.println(e.getMessage());
				scan.nextLine();
			} catch (DivideByZeroException e) {
				error = true;
				System.out.println(e.getMessage());
				scan.nextLine();
			} catch (Exception e) {
				error = true;
				System.out.println(e.getMessage());
			}
		} while (error);
		ratio = (double) numerator / denominator;
		System.out.println("The result is " + ratio);
	}

	public static void main(String[] args) {
		ReturnRatio();
	}

}

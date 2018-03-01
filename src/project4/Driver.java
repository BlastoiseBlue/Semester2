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
		Scanner scan = new Scanner(System.in);
		int numerator = 0, denominator = 0;
		double ratio;
		boolean error = false;
		do {
			error = false;
			try {
				
				System.out.println("Please input the numerator:");
				numerator = scan.nextInt();
				if(numerator<0)throw new NegativeInputException();
				
			} catch (Exception e) {
				//error = true;
				System.out.println(e.getMessage());
			}
		} while (error);
		do {
			error=false;
			try {
				error = false;
				System.out.println("Please input the denominator:");
				denominator = scan.nextInt();
				if (denominator==0)throw new DivideByZeroException();
				if (denominator<0)throw new NegativeInputException();
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

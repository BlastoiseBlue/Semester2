/*
 * DataIO.java
 * 
 * This class will read in and store data from a text file, calculate the average,
 * and display the standard deviation
 * 
 * Created: 3/8/18
 * @author Emmet Stanevich
 */
package project5;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.*;
import java.math.*;

@SuppressWarnings("unused")
public class DataIO {
	private String inputFile = null;
	private double[] numbers;

	/*
	 * Stores the numbers of the targeted file in an array, and prints out the
	 * average and standard deviation
	 * 
	 * @param fileIn The file to read the numbers from
	 */
	public DataIO(String fileIn) {
		inputFile = fileIn;
		try {
			store();
			System.out.println(average(numbers));
			System.out.println(stdDev(numbers));
		} catch (Exception e) {
			System.out.println("Exception is --- " + e.getMessage() + "\n");
			System.exit(0);
		}
	}

	/*
	 * First constructs an array, then fills it with numbers it reads from the file
	 */
	private void store() {
		Scanner myIn = null;
		Scanner lineCounter = null;
		try {
			myIn = new Scanner(new FileInputStream(inputFile));
			lineCounter = new Scanner(new FileInputStream(inputFile));
			int n = 0;
			while (lineCounter.hasNextLine()) {
				lineCounter.nextLine();
				n++;
			}
			numbers = new double[n];
			for (int i = 0; i < n; i++) {
				numbers[i] = myIn.nextDouble();
				// myIn.nextLine();
				System.out.println(numbers[i]);
			}
		} catch (InputMismatchException e) {
			System.out.println("Exception is --- " + e.getMessage() + "\n");
		} catch (IOException e) {
			System.out.println("Exception is --- " + e.getMessage() + "\n");
		}
	}

	/*
	 * Adds up all of the stored numbers, then sets the value "average" to the total
	 * divided by the amount of numbers stored, then returns that number
	 * 
	 * @param n The array to compute the average of
	 */
	public double average(double[] n) {
		int total = 0;
		for (int i = 0; i < n.length; i++) {
			total += n[i];
		}
		return total / n.length;
	}

	/*
	 * Returns the standard deviation of an array
	 * 
	 * @param n The array that the standard deviation will be calculated from
	 */
	public double stdDev(double[] n) {
		double[] t = new double[n.length];
		for (int i = 0; i < n.length; i++) {
			t[i] = (n[i] - average(n)) * (n[i] - average(n));
		}
		return Math.sqrt(average(t));
	}
}

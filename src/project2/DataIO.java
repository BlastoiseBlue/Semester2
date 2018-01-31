package project2;

import java.util.Scanner;
import java.io.*;

public class DataIO {
	/*
	 * readData reads text from a file and stores it in two arrays
	 */
	String[][] myNames;
	double[][] stuScores;
	char[] grades;
	String inputFile = "project2IN.txt";

	char grade(double grade) {
		if (grade >= 89.5)
			return 'A';
		else if (grade >= 82.5)
			return 'B';
		else if (grade >= 72.5)
			return 'C';
		else if (grade >= 62.5)
			return 'D';
		else
			return 'F';
	}
	/*
	 * public void printData() { for (int i = 0; i < myNames.length; i++) {
	 * System.out.print(myNames[i] + ":\n"); for (int j = 0; j <
	 * stuScores[i].length; j++) { System.out.print(stuScores[i][j] + "\t");
	 * 
	 * } System.out.println(); } }
	 */

	public DataIO(String fileIn) {
		inputFile = fileIn;
	}

	public DataIO() {

	}

	/*
	 * Reads the data in the specified file and stores is in local arrays
	 * 
	 * @fileIn String The name of the file
	 */
	public void readData(String fileIn) {
		inputFile = fileIn;
		readData();
	}

	/*
	 * Reads the data in an already-specified file and stores it in local arrays
	 */
	public void readData() {
		Scanner myIn = null; // Initializes fileIn to empty
		String first, last;
		Scanner lineCounter = null;
		try {
			// Attempt to open the file
			myIn = new Scanner(new FileInputStream(inputFile));
			lineCounter = new Scanner(new FileInputStream(inputFile));
			int n = 0;
			while (lineCounter.hasNextLine()) {
				@SuppressWarnings("unused") // This placeholder is mainly used to force the counter to advance to the
											// next line
				String placeHolder = lineCounter.nextLine();
				n++;
			}
			myNames = new String[n][2];
			stuScores = new double[n][4];
			grades = new char[n];
			System.out.println("Opening input file: " + inputFile);
			int i = 0;
			for (i = 0; i < n; i++) {
				first = myIn.next();
				last = myIn.next();
				myNames[i][0] = first;
				myNames[i][1] = last;
				int j = 0;
				double total = 0;
				for (j = 0; j < 3; j++) {
					stuScores[i][j] = myIn.nextDouble();
					total += stuScores[i][j]; // Keeps track of the total scores
				}
				stuScores[i][j] = total / (stuScores[i].length - 1); // Stores the average score in the next slot
				grades[i] = grade(stuScores[i][j]);
			}
			System.out.println("Closing input file: " + inputFile);
			myIn.close();
		} catch (IOException e) {
			System.out.println("Exception is --- " + e.getMessage());
		}

	}

	public void writeData() {

	}
}

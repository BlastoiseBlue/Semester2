package project2;

import java.util.Scanner;
import java.io.*;

public class DataIO {
	/*
	 * readData reads text from a file and stores it in two arrays
	 */
	String[] myNames;
	double[][] stuScores;

	public void printData() {
		for (int i = 0; i < myNames.length; i++) {
			System.out.print(myNames[i] + ":");
			for (int j = 0; j < stuScores.length; j++) {
				System.out.print(stuScores[i][j]);
				System.out.println();
			}
		}
	}

	public void readData() {
		Scanner myIn = null; // Initializes fileIn to empty
		String first, last;
		String inputFile = "project2IN.txt";
		try {
			// Attempt to open the file
			myIn = new Scanner(new FileInputStream(inputFile));
			int i = 0;
			while (myIn.hasNextLine()) {
				// String placeHolder=myIn.nextLine();
				first = myIn.next();
				last = myIn.next();
				myNames[i] = (last + ", " + first);
				int j = 0;
				double total = 0;
				for (j = 0; j < 3; j++) {
					stuScores[i][j] = myIn.nextDouble();
					total += stuScores[i][j]; // Keeps track of the total scores
				}
				stuScores[i][j + 1] = total / (stuScores[i].length); // Stores the average score in the next slot
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

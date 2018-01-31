package project2;

import java.util.Scanner;
import java.io.*;

public class DataIO {
	/*
	 * readData reads text from a file and stores it in two arrays
	 */
	String[] myNames;
	double[][] stuScores;
	String inputFile = "project2IN.txt";

	public void printData() {
		for (int i = 0; i < myNames.length; i++) {
			System.out.print(myNames[i] + ":");
			for (int j = 0; j < stuScores.length; j++) {
				System.out.print(stuScores[i][j]);
				System.out.println();
			}
		}
	}

	public DataIO(String fileIn) {
		inputFile = fileIn;
	}

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
				String placeHolder = lineCounter.nextLine();
				n++;
			}
			myNames = new String[n];
			stuScores = new double[n][4];
			System.out.println("Opening input file: " + inputFile);
			int i = 0;
			//while (myIn.hasNextLine()) {
				for(i=0;i<n;i++) {
				//lineCounter = new Scanner(myIn.nextLine());
				first = myIn.next();
				last = myIn.next();
				myNames[i] = (last + ", " + first);
				int j = 0;
				double total = 0;
				for (j = 0; j < 3; j++) {
					stuScores[i][j] = myIn.nextDouble();
					total += stuScores[i][j]; // Keeps track of the total scores
				}
				stuScores[i][j] = total / (stuScores[i].length-1); // Stores the average score in the next slot
				
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

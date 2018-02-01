package project2;

/*
 * @authors Emmet Stanevich and Miranda Henning
 */
import java.util.Scanner;
import java.io.*;

public class DataIO {
	/*
	 * readData reads text from a file and stores it in two arrays, and then
	 * proceeds to calculate a grade based of the average score of each student
	 * 
	 */
	String[][] myNames;
	double[][] stuScores;
	char[] grades;
	String inputFile = null;

	/*
	 * Determines the letter grade based on the average score
	 * 
	 * @param grade The average score for the given student
	 */
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

	public DataIO(String fileIn) {
		inputFile = fileIn;
	}

	/*
	 * Reads the data in the specified file and stores is in local arrays. This
	 * method can be used to change the file that is being read from
	 * 
	 * @param fileIn The name of the file
	 */
	public void readData(String fileIn) {
		inputFile = fileIn;
		readData();
	}

	/*
	 * Reads the data in an already-specified file and stores it in local arrays, as
	 * well as computing the average score and the letter grade. This method will
	 * also display the information as it is being stored
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
			System.out.println("Opening input file: " + inputFile + "\n");
			System.out.println("Displaying data as it is being read");
			int i = 0;
			for (i = 0; i < n; i++) {
				first = myIn.next();
				last = myIn.next();
				myNames[i][0] = first;
				myNames[i][1] = last;
				System.out.print(myNames[i][1] + ", " + myNames[i][0]);
				int j = 0;
				double total = 0;
				for (j = 0; j < 3; j++) {
					stuScores[i][j] = myIn.nextDouble();
					System.out.print(" " + stuScores[i][j]);
					total += stuScores[i][j]; // Keeps track of the total scores
				}
				System.out.println(" " + 0.0);
				stuScores[i][j] = total / (stuScores[i].length - 1); // Stores the average score in the next slot
				grades[i] = grade(stuScores[i][j]); // Assigns a letter grade to the student based on their score
			}
			System.out.println("\nHere are the average scores:");
			for (int k = 0; k < myNames.length; k++) {
				System.out.println("Average for " + myNames[k][1] + ", " + myNames[k][0] + " is "
						+ stuScores[k][stuScores[k].length - 1]);
			}
			System.out.println("Closing input file: " + inputFile + "\n");
			myIn.close();
		} catch (IOException e) {
			System.out.println("Exception is --- " + e.getMessage() + "\n");
		}

	}

	/*
	 * Writes the stored data onto the specified file
	 * 
	 * @param fileOut The file that the data gets written onto
	 */
	public void writeData(String fileOut) {
		PrintWriter outputStream = null;
		try {
			outputStream = new PrintWriter(new FileOutputStream(fileOut));
			System.out.println("Writing to output file: " + fileOut + "\n");
			outputStream.printf("%-20sScore1 Score2 Score3 Average Grade\n", "Name");
			for (int i = 0; i < myNames.length; i++) {
				outputStream.printf("%-20s", myNames[i][1] + ", " + myNames[i][0] + ": ");
				for (int j = 0; j < stuScores[i].length; j++) {
					outputStream.printf("%6.1f ", stuScores[i][j]);
				}
				outputStream.printf("%6c\n", grades[i]);
			}
			System.out.println("Closing file: " + fileOut + "\n");
			outputStream.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error opening the file " + fileOut + "\n");
		}
	}
}

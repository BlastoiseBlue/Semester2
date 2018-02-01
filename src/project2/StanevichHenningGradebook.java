package project2;

/*
 * @authors Emmet Stanevich and Miranda Henning
 */
public class StanevichHenningGradebook {
	/*
	 * Prints out the data from the stored memory, formatted for readability
	 * 
	 * @param input The DataIO object that has the data stored from the input file
	 */
	static void printClean(DataIO input) {
		System.out.printf("%-20sScore1 Score2 Score3 Average Grade\n", "Name");
		for (int i = 0; i < input.myNames.length; i++) {
			System.out.printf("%-20s", input.myNames[i][1] + ", " + input.myNames[i][0] + ": ");
			for (int j = 0; j < input.stuScores[i].length; j++) {
				System.out.printf("%6.1f ", input.stuScores[i][j]);
			}
			System.out.printf("%6c\n", input.grades[i]);
		}
		System.out.println();
	}

	/*
	 * This will read an input file, reorder the names to last, first and print out
	 * each name, the corresponding score, and the average score. After that, it
	 * will output the results into project2OUT.txt
	 */
	public static void main(String[] args) {
		DataIO students = new DataIO("project2IN.txt");
		students.readData();
		printClean(students);
		students.writeData("project2OUT.txt");
		System.out.println("The program is finished, have a nice day.");
	}

}

package project2;

/*
 * @authors Emmet Stanevich and Miranda Henning
 */
public class StanevichHenningGradebook {
	/*
	 * Prints out the data from the stored memory
	 */
	static void printData(DataIO input) {
		for (int i = 0; i < input.myNames.length; i++) {
			System.out.print(input.myNames[i][1] + ", " + input.myNames[i][0] + ":\n");
			for (int j = 0; j < input.stuScores[i].length; j++) {
				System.out.print(input.stuScores[i][j] + "\t");
			}
			System.out.println("\n Grade: "+input.grades[i]);
		}
	}

	/*
	 * This will read an input file, reorder the names to last, first and print out
	 * each name, the corresponding score, and the average score. After that, it
	 * will output the results into project2OUT.txt
	 */
	public static void main(String[] args) {
		DataIO students = new DataIO("C:\\Users\\emmet\\eclipse-workspace\\Semester2\\bin\\project2\\project2IN.txt");
		students.readData();
		printData(students);
	}

}

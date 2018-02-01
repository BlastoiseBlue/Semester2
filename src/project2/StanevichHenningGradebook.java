package project2;

/*
 * @authors Emmet Stanevich and Miranda Henning
 */
public class StanevichHenningGradebook {
	/*
	 * Prints out the data from the stored memory
	 * 
	 * @param input The DataIO object that has the 
	 */
	static void printClean(DataIO input) {
		for (int i = 0; i < input.myNames.length; i++) {
			System.out.println(input.myNames[i][1] + ", " + input.myNames[i][0] + ":");
			for (int j = 0; j < input.stuScores[i].length; j++) {
				System.out.print(input.stuScores[i][j] + "\t");
			}
			System.out.println("\n Grade: " + input.grades[i]);
		}
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
	}

}

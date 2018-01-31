package project2;

/*
 * @authors Emmet Stanevich and Miranda Henning
 */
public class StanevichHenningGradebook {

	public static void main(String[] args) {
		DataIO students = new DataIO("C:\\Users\\emmet\\eclipse-workspace\\Semester2\\bin\\project2\\project2IN.txt");
		students.readData();
		students.printData();
	}

}

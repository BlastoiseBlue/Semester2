/**
 * 
 */
package project7;

/**
 * @author emmet
 *
 *         Created: 03-29-2018
 *
 */
public class Driver {
	/*
	 * A quick method that prints out everything in the given array
	 */
	static void printAll(@SuppressWarnings("rawtypes") Comparable[] a) {
		for (int i = 0; i < a.length; i++)
			System.out.print(a[i] + " ");
		System.out.println();
	}

	/*
	 * Calls the search method from BinarySearch, and directly prints it out
	 */
	static void find(@SuppressWarnings("rawtypes") Comparable[] a, @SuppressWarnings("rawtypes") Comparable k) {
		int x = BinarySearch.search(a, 0, a.length - 1, k);
		if (x == -1)
			System.out.println(k + " was not found");
		else
			System.out.println(k + " has been found at index " + x);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Integer[] x1 = { 1, 2, 3, 4, 5 };
		printAll(x1);
		find(x1, 3);
		find(x1, 7);
		Double[] x2 = { 1.0, 2.0, 3.0, 4.0, 5.0 };
		printAll(x2);
		find(x2, 5.0);
		find(x2, 9.0);
		String[] x3 = { "a", "b", "c", "d", "e" };
		printAll(x3);
		find(x3, "e");
		find(x3, "v");
	}

}

/**
 * 
 */
package project8;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.text.NumberFormat;

/**
 * 
 * This program will act as a grocery store app.
 *
 * 
 * 
 * The purpose of this project is to have you create a linked list, add items to
 * it, add computations to
 * 
 * fields within the nodes, remove a node by traversing it to find a match, then
 * eliminate the node,
 * 
 * traverse the linked list to add up items stored within the objects' instance
 * variables (how much
 * 
 * is owed for the items and for tax), traverse the list to print out a neat
 * receipt.
 *
 * 
 * 
 * This project requires that the grocery information be stored in a singly
 * linked list
 * 
 * and that you use an inner class to define the LinkedListNode
 * 
 * It also requires:
 * 
 * That you begin with an empty linked list
 * 
 * That you have the user enter data as many times as they wish to fill in the
 * linked list
 * 
 * See the exact wording in the sample output for these features:
 * 
 * The method invocation to add the items is included in main
 * 
 * The additions are performed within a method and not in main
 * 
 * The linked list will be displayed between each addition of data
 * 
 * That you allow the user to remove items from the linked list
 * 
 * The method invocation to remove items is included in main
 * 
 * The removal of items is performed in a method and not in main
 * 
 * The linked list will be displayed between each addition of data
 * 
 * A message stating that the item is not found is included when appropriate
 * 
 * The display of data is done by a display method, not as the values are read
 * in or removed
 *
 * 
 * 
 * The program will request items that you will purchase: Item name, Price,
 * taxable (y or n).
 * 
 * You will enter at least 7 items. (Keep adding in more items until the user
 * wishes to check out
 * 
 * as in: Enter the item name ( or "!" to Exit)
 *
 * 
 * 
 * Before you are done, the app will ask if you wish to remove items from your
 * list. You will be able to remove
 * 
 * at least one middle item and the LAST item from the list.
 * 
 * You are not required to remove the first item from the list (but I highly
 * recommend that you be able to do this)
 * 
 * You are not required to empty out the list entirely (but I highly recommend
 * that you be able to do this)
 *
 * 
 * 
 * At least match this output. Yours can be nicer. But a formatted receipt is
 * required: lining up the items
 * 
 * and the Subtotal, Total Tax, and Total Owed IS A MUST.
 *
 * 
 * 
 * Your program will print out a neat formatted receipt with
 * 
 * A header
 * 
 * Each item, the price for each item, and the tax for each item (USE a
 * formatted toString)
 * 
 * The subtotal of the prices,
 * 
 * The tax owed.
 * 
 * The total owed.
 *
 * 
 * 
 * You may start a new class or use this one. This is just a skeleton to get you
 * started!
 *
 * 
 * 
 * @author emmet
 *
 *         Created: 04-05-2018
 *
 */

public class GroceryStore {
	static NumberFormat moneyFormatter = NumberFormat.getCurrencyInstance();

	private static class Node {
		private String name;
		private double cost;
		private boolean taxable;
		Node link;

		public Node(String s, double a, boolean t, Node n) {
			name = s;
			cost = a;
			taxable = t;
			link = n;
		}

		@SuppressWarnings("unused")
		public Node() {
			name = null;
			cost = 0;
			taxable = false;
			link = null;
		}

		public Node(Node n) {
			link = n;
		}

		public void deleteHeadNode() {
			if (link != null) {
				link = link.link;
			} else
				head = link;
		}

		public double getTax() {
			if (taxable)
				return cost * .06;
			else
				return 0.00;
		}

		public double subTotal() {
			if (link == null)
				return cost;
			else
				return cost + link.subTotal();
		}

		public double totalTax() {
			if (link == null)
				return getTax();
			else
				return getTax() + link.totalTax();
		}

		public double getTotal() {
			return subTotal() + totalTax();
		}

		public void output() {

			if (link == null) {
				System.out.printf("%-20s", "Product");
				System.out.printf("%7s", "Price");
				System.out.printf("%9s\n", "Tax");
			} else
				link.output();
			if (name != null) {
				System.out.printf("%-20s", name);
				System.out.printf("$%6.2f", cost);
				System.out.printf("  $%6.2f\n", getTax());
			}
		}
	}

	public static Node find(String target) {
		Node position = head;
		@SuppressWarnings("unused")
		String itemAtPosition;
		// if(head.name.equals(target));
		while (position != null) {
			itemAtPosition = position.name;
			if (position.link.name.equals(target))
				return position;
			position = position.link;
		}
		return null;
	}

	static void output() {
		head.output();
		System.out.printf("%-20s", "Subtotal:");
		System.out.printf("$%6.2f\n", head.subTotal());
		System.out.printf("%-20s", "Total Tax:");
		System.out.printf("$%6.2f\n", head.totalTax());
		System.out.printf("%-20s", "Total:");
		System.out.printf("$%6.2f\n", head.getTotal());
	}

	/****************************************************************
	 * 
	 * intro()
	 * 
	 * The introduction will be displayed to the user
	 * 
	 */

	public static void intro() {
		System.out.println("Welcome to the grocer app.");
		System.out.println("As you go through the store, enter your item details.");
		System.out.println("Your total won't be a shock when you get to the checkout.");
		System.out.println("\nFor each item: Enter the item name, the price, and y if it is taxed or n if it is not.");
		System.out.println("You will also get a chance to see the subtotal while you shop.");
	}

	public static String getString(String str) {
		@SuppressWarnings("resource")
		Scanner keyboard = new Scanner(System.in);
		System.out.println("\nEnter the item name ( or \"!\" to Exit)");
		System.out.print(str);
		return keyboard.nextLine();
	}

	public static double getDouble(String str) {

		// Do FIX this so that it can't read in erroneous input
		@SuppressWarnings("resource")
		Scanner keyboard = new Scanner(System.in);
		try {
			System.out.print(str);
			return keyboard.nextDouble();
		} catch (InputMismatchException e) {
			System.out.println("ERROR: Please input a number");
			return getDouble(str);
		}
	}

	public static boolean getTaxable()

	{
		@SuppressWarnings("resource")
		Scanner keyboard = new Scanner(System.in);
		// Read in the y or n ... Make that true or false!
		String answer = null;
		do {
			System.out.println("Is this taxable? Y/N ");
			answer = keyboard.nextLine();
			if (answer.toLowerCase().charAt(0) == 'y')
				return true;
			else
				return false;
		} while (answer.toLowerCase().charAt(0) != 'y' && answer.toLowerCase().charAt(0) != 'n');
		// return false;

	}

	static Node head = null;

	/****************************************************************
	 * 
	 * main
	 * 
	 */

	public static void main(String[] args)

	{

		// boolean done = false;

		// LinkedListNode placeHolder = null;

		intro();

		// Fill first node:

		String temp = getString("Item: ");

		if (!temp.equals("!"))

			head = new Node(temp, getDouble("Price: "), getTaxable(), null);

		// What's in the first node?

		System.out.println("The first node has as contents: \n");
		head.output();

		// Add more nodes to the Linked List (Until the user wishes to end the program
		// with a "!")
		while (!temp.equals("!")) {
			temp = getString("Item: ");
			if (!temp.equals("!")) {
				head = new Node(temp, getDouble("Price: "), getTaxable(), head);
				output();
			}
		}
		// This is to ensure that the last item can be selected for deletion, by adding
		// a null node that never shows on the console
		head = new Node(head);
		// Remove items section begins here
		do {
			try {
				temp = getString("Item to delete: ");
				if (!temp.equals("!")) {
					find(temp).deleteHeadNode();
					output();
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} while (!temp.equals("!"));
		// Print out the final receipt
		System.out.println("Here is your final receipt:");
		output();
		System.out.println("Thank you for using Emmet's app.");
	}

}

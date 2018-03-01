/*
 * NegativeInputException.java
 * 
 * Called when either of the inputs is negative
 * 
 * Created: Thur Mar 1 2018
 * @author Emmet Stanevich
 */
package project4;

public class NegativeInputException extends Exception {
	public NegativeInputException() {
		super("ERROR: Input must NOT be negative");
	}
}
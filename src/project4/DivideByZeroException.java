/*
 * DivideByZeroException.java
 * 
 * Thrown if the denominator is 0
 * 
 * Created: Thur Mar 1 2018
 * @author Emmet Stanevich
 */
package project4;

@SuppressWarnings("serial")
public class DivideByZeroException extends Exception {
	public DivideByZeroException() {
		super("ERROR: DENOMINATOR CANNOT BE ZERO");
	}
}

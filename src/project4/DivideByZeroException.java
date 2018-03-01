package project4;

public class DivideByZeroException extends Exception {
	public DivideByZeroException() {
		super("ERROR: DENOMINATOR CANNOT BE ZERO");
	}
}

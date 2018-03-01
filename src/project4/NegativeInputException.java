package project4;

public class NegativeInputException extends Exception {
	public NegativeInputException() {
		super("ERROR: Input must NOT be negative");
	}
}
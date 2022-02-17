package exception;

public class NoIdFieldException extends Exception {

	public NoIdFieldException() {
		super("Required id field not found!");
	}
	
}

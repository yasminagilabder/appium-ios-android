package acceptanceTests.exception;

public class UnknownButtonException extends Exception {
	public UnknownButtonException(String errorMessage) {
		super(errorMessage);
	}
}


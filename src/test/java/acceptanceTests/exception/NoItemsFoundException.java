package acceptanceTests.exception;

public class NoItemsFoundException extends Exception {
	public NoItemsFoundException(String errorMessage) {
		super(errorMessage);
	}
}


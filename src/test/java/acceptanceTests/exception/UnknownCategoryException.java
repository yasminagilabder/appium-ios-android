package acceptanceTests.exception;

public class UnknownCategoryException extends Exception {
	public UnknownCategoryException(String errorMessage) {
		super(errorMessage);
	}
}


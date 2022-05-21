package dynamic_circular_array;

/**
 * Signals that a dynamic circular array was initialized to an invalid size.
 *
 * @author Daniel
 */
@SuppressWarnings("serial")
public class InvalidInitialDynamicCircularArraySizeException extends RuntimeException {

	/**
	 * Constructs an InvalidInitialDynamicCircularArraySizeException
	 * without a message describing the particular exception.
	 */
	public InvalidInitialDynamicCircularArraySizeException() {
		super();
	}

	/**
	 * Constructs an InvalidInitialDynamicCircularArraySizeException with a
	 * message describing the particular exception.
	 *
	 * @param message - The message describing the particular exception.
	 */
	public InvalidInitialDynamicCircularArraySizeException(String message) {
		super(message);
	}

}

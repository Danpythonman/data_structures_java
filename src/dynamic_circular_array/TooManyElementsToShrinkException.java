package dynamic_circular_array;

/**
 * Signals that a dynamic circular array cannot be shrunk because there are too
 * many elements in the array.
 *
 * @author Daniel
 */
@SuppressWarnings("serial")
public class TooManyElementsToShrinkException extends RuntimeException {

	/**
	 * Constructs an TooManyElementsToShrinkException without a message
	 * describing the particular exception.
	 */
	public TooManyElementsToShrinkException() {
		super();
	}

	/**
	 * Constructs an TooManyElementsToShrinkException with a message describing
	 * the particular exception.
	 *
	 * @param message - The message describing the particular exception.
	 */
	public TooManyElementsToShrinkException(String message) {
		super(message);
	}

}

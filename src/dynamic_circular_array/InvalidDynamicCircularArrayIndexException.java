package dynamic_circular_array;

/**
 * Signals that a dynamic circular was indexed at an invalid index.
 *
 * @author Daniel
 */
@SuppressWarnings("serial")
public class InvalidDynamicCircularArrayIndexException extends RuntimeException {

	/**
	 * Constructs an InvalidDynamicCircularArrayIndexException without a message
	 * describing the particular exception.
	 */
	public InvalidDynamicCircularArrayIndexException() {
		super();
	}

	/**
	 * Constructs an InvalidDynamicCircularArrayIndexException with a message
	 * describing the particular exception.
	 *
	 * @param message - The message describing the particular exception.
	 */
	public InvalidDynamicCircularArrayIndexException(String message) {
		super(message);
	}

}

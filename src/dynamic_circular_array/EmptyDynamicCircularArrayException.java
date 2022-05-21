package dynamic_circular_array;

/**
 * Signals that a dynamic circular array method with a precondition that the
 * array cannot be empty has been invoked when the array is empty.
 *
 * @author Daniel
 */
@SuppressWarnings("serial")
public class EmptyDynamicCircularArrayException extends RuntimeException {

	/**
	 * Constructs an EmptyDynamicCircularArrayException without a message
	 * describing the particular exception.
	 */
	public EmptyDynamicCircularArrayException() {
		super();
	}

	/**
	 * Constructs an EmptyDynamicCircularArrayException with a message
	 * describing the particular exception.
	 *
	 * @param message - The message describing the particular exception.
	 */
	public EmptyDynamicCircularArrayException(String message) {
		super(message);
	}

}

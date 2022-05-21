package stack;

/**
 * Signals that a stack method with a precondition that the stack cannot be
 * empty has been invoked when the stack is empty.
 *
 * @author Daniel
 */
@SuppressWarnings("serial")
public class EmptyStackException extends RuntimeException {

	/**
	 * Constructs an EmptyStackException without a message describing the
	 * particular exception.
	 */
	public EmptyStackException() {
		super();
	}

	/**
	 * Constructs an EmptyStackException with a message describing the
	 * particular exception.
	 *
	 * @param message - The message describing the particular exception.
	 */
	public EmptyStackException(String message) {
		super(message);
	}

}

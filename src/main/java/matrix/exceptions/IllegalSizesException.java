package matrix.exceptions;

/**
 *
 * Signals about that the size of the first matrix 
 * does not match to the size of the second matrix.
 * 
 * @author Dark Lord
 */
public class IllegalSizesException extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1733704499525474088L;

	/**
     *
     */
    public IllegalSizesException() {
        super();
    }

    /**
     *
     * @param message the detail message.
     */
    public IllegalSizesException(String message) {
        super(message);
    }
}

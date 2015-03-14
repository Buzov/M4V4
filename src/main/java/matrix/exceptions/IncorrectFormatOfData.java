package matrix.exceptions;

/**
 * Signals about that data type of the matrix are not correct.
 * 
 * @author Dark Lord
 */
public class IncorrectFormatOfData extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = -7685519838584124238L;

	/**
     *
     */
    public IncorrectFormatOfData() {
        super();
    }

    /**
     *
     * @param message the detail message.
     */
    public IncorrectFormatOfData(String message) {
        super(message);
    }
}

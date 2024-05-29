package exceptions;

/**
 * Custom exception class to handle cases where there are no lower elements in a data set.
 */
public class NoLowerElementsException extends Exception{

    /**
     * Constructor for the NoLowerElementsException class.
     *
     * @param message The message to be displayed when the exception is thrown.
     */
    public NoLowerElementsException(String message) {
        super(message);
    }

}

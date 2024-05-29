package exceptions;

/**
 * Custom exception class to handle cases related to the root of a data set.
 */
public class RootException extends Exception{

    /**
     * Constructor for the RootException class.
     *
     * @param message The message to be displayed when the exception is thrown.
     */
    public RootException(String message){
        super(message);
    }
}
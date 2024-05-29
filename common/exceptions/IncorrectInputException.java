package exceptions;

/**
 * The IncorrectInputException class represents an exception that occurs when an incorrect input is provided.
 */
public class IncorrectInputException extends Exception {

    /**
     * Constructs an IncorrectInputException with a detail message indicating the wrong input argument.
     *
     * @param data the incorrect input data
     */
    public IncorrectInputException(String data){
        super("Wrong input argument: " + data);
    }
}

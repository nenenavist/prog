package exceptions;

/**
 * The UnknownCommandException class represents an exception that occurs when an unknown command is encountered.
 */
public class UnknownCommandException extends Exception {

    /**
     * Constructs an UnknownCommandException with a detail message indicating the unknown command.
     *
     * @param commandName the name of the unknown command
     */
    public UnknownCommandException(String commandName) {
        super("Unknown command: " + commandName);
    }
}

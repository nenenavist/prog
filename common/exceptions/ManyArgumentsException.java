package exceptions;

/**
 * The ManyArgumentsException class represents an exception that occurs when too many arguments are provided for a command.
 */
public class ManyArgumentsException extends Exception {

    /**
     * Constructs a ManyArgumentsException with a detail message indicating the command name with too many arguments.
     *
     * @param commandName the name of the command
     */
    public ManyArgumentsException(String commandName){
        super("Too many arguments for command - " + commandName);
    }
}

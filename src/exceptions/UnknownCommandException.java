package exceptions;

public class UnknownCommandException extends Exception{
    public UnknownCommandException(String commandName) {
        super("Unknow command: " + commandName);
    }
}

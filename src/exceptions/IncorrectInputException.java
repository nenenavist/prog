package exceptions;

public class IncorrectInputException extends Exception {
    public IncorrectInputException(String data){
        super("Wrong input argument: " + data);
    }
}

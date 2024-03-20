package exceptions;

public class NoElementException extends Exception {
    public NoElementException(Integer id) {
        super("No element in collection with id: " + id);
    }
}

package exceptions;

/**
 * The NoElementException class represents an exception that occurs when no element is found in a collection with a specific ID.
 */
public class NoElementException extends Exception {

    /**
     * Constructs a NoElementException with a detail message indicating the absence of an element in the collection with the given ID.
     *
     * @param id the ID of the element that was not found
     */
    public NoElementException(Integer id) {
        super("No element in collection with id: " + id);
    }
}

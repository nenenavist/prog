package exceptions;

/**
 * The UsedIdException class represents an exception that occurs when an attempt is made to use an ID that is already in use.
 */
public class UsedIdException extends Exception {

    /**
     * Constructs a UsedIdException with a detail message indicating that the provided ID is already in use.
     *
     * @param id the ID that is already in use
     */
    public UsedIdException(int id){
        super("Id: " + id + " already used");
    }
}

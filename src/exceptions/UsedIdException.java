package exceptions;

public class UsedIdException extends Exception {
    public UsedIdException(int id){
        super("Id: " + id + " already used");
    }
}

package exceptions;

public class UsedIdException extends Exception {
    public UsedIdException(int id){
        super("Id: " + id + " already used\nесли вы выбили эту ошибку, то добавьте + пару баллов пж((((");
    }
}

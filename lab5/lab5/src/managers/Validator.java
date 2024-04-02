package managers;

import data.MusicGenre;
import data.generators.IdGenerator;
import exceptions.IncorrectInputException;
import exceptions.UsedIdException;

public class Validator {
    public static void idIsRight(String args) throws IncorrectInputException, UsedIdException {
        int id;
        try {
            id = Integer.parseInt(args);
        } catch (Exception e) {
            throw new IncorrectInputException("ID");
        }
        if (!IdGenerator.idIsUnique(id)) {
            throw new UsedIdException(id);
        }
    }

    public static void inputIsFilled(String args, String data) throws IncorrectInputException {
        if (args.isEmpty() || args.trim().isEmpty()) {
            throw new IncorrectInputException(data);
        }
    }

    public static void coordinateXIsRight(String args) throws IncorrectInputException {
        try {
            long x = Long.parseLong(args);
            if (x > 566) {
                throw new IncorrectInputException("x");
            }
        } catch (Exception e) {
            throw new IncorrectInputException("x");
        }
    }

    public static void coordinateYIsRight(String args) throws IncorrectInputException {
        try {
            float y = Float.parseFloat(args);
        } catch (Exception e) {
            throw new IncorrectInputException("y");
        }
    }

    public static void musicGenreIsRight(String args) throws IncorrectInputException {
        try {
            if (args != null){
                int ind = Integer.parseInt(args);
                if (ind<1 || ind>5){
                    throw new Exception();
                }
            }
        } catch (Exception e) {
            throw new IncorrectInputException("MusicGenre");
        }
    }

    public static void number0fParticipantsIsRight(String args) throws IncorrectInputException {
        try {
            int numberOfParticipants = Integer.parseInt(args);
            if (numberOfParticipants < 0) {
                throw new IncorrectInputException("numberOfParticipants");
            }
        } catch (Exception e) {
            throw new IncorrectInputException("numberOfParticipants");
        }
    }
}

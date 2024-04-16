package managers;

import data.generators.IdGenerator;
import exceptions.IncorrectInputException;
import exceptions.UsedIdException;

/**
 * The Validator class contains methods for validating input data.
 */
public class Validator {

    /**
     * Validates if the provided ID is in the correct format and is unique.
     *
     * @param args The ID to be validated.
     * @throws IncorrectInputException If the ID is not in the correct format.
     * @throws UsedIdException        If the ID is already used.
     */
    public static void idIsRight(String args) throws IncorrectInputException, UsedIdException {
        int id;
        try {
            id = Integer.parseInt(args);
        } catch (NumberFormatException e) {
            throw new IncorrectInputException("ID");
        }
        if (!IdGenerator.idIsUnique(id)) {
            throw new UsedIdException(id);
        }
    }

    /**
     * Validates if the provided input is filled.
     *
     * @param args The input data to be validated.
     * @param data The type of data being validated.
     * @throws IncorrectInputException If the input data is empty.
     */
    public static void inputIsFilled(String args, String data) throws IncorrectInputException {
        if (args == null || args.trim().isEmpty()) {
            throw new IncorrectInputException(data);
        }
    }

    /**
     * Validates if the provided X-coordinate is in the correct format.
     *
     * @param args The X-coordinate to be validated.
     * @throws IncorrectInputException If the X-coordinate is not in the correct format.
     */
    public static void coordinateXIsRight(String args) throws IncorrectInputException {
        try {
            long x = Long.parseLong(args);
            if (x > 566) {
                throw new IncorrectInputException("x");
            }
        } catch (NumberFormatException e) {
            throw new IncorrectInputException("x");
        }
    }

    /**
     * Validates if the provided Y-coordinate is in the correct format.
     *
     * @param args The Y-coordinate to be validated.
     * @throws IncorrectInputException If the Y-coordinate is not in the correct format.
     */
    public static void coordinateYIsRight(String args) throws IncorrectInputException {
        try {
            float y = Float.parseFloat(args);
        } catch (NumberFormatException e) {
            throw new IncorrectInputException("y");
        }
    }

    /**
     * Validates if the provided music genre is in the correct format.
     *
     * @param args The music genre to be validated.
     * @throws IncorrectInputException If the music genre is not in the correct format.
     */
    public static int musicGenreIsRight(String args) throws IncorrectInputException {
        try {
            if (args != null && args.length()==1) {
                int ind = Integer.parseInt(args);
                if (ind < 1 || ind > 5) {
                    throw new Exception();
                }
                return ind;
            }
            else if(args.length()>1){
                switch (args){
                    case "PROGRESSIVE_ROCK":
                        return 1;
                    case "HIP_HOP":
                        return 2;
                    case "PSYCHEDELIC_CLOUD_RAP":
                        return 3;
                    case "PUNK_ROCK":
                        return 4;
                    case "BRIT_POP":
                        return 5;
                    default:
                        throw new IncorrectInputException("GENRE");
                }
            }
            return 0;
        } catch (Exception e) {
            throw new IncorrectInputException("MusicGenre");
        }
    }

    /**
     * Validates if the provided number of participants is in the correct format.
     *
     * @param args The number of participants to be validated.
     * @throws IncorrectInputException If the number of participants is not in the correct format.
     */
    public static void number0fParticipantsIsRight(String args) throws IncorrectInputException {
        try {
            int numberOfParticipants = Integer.parseInt(args);
            if (numberOfParticipants <= 0) {
                throw new IncorrectInputException("numberOfParticipants");
            }
        } catch (NumberFormatException e) {
            throw new IncorrectInputException("numberOfParticipants");
        }
    }
}

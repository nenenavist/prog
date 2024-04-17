package data.generators;

import data.Coordinates;
import data.MusicBand;
import data.MusicGenre;
import data.Studio;
import exceptions.IncorrectInputException;
import managers.Validator;

import java.util.Scanner;

/**
 * The MusicBandGenerator class provides functionality for creating MusicBand objects with user input.
 */
public class MusicBandGenerator {

    /**
     * Creates a new MusicBand object with user-provided input.
     *
     * @param id the ID of the MusicBand (can be null if the MusicBand is new)
     * @return the created MusicBand object
     */
    public static MusicBand createMusicBand(Integer id) {
        System.out.println("You have started the creation of a music band");
        String input, x, y, numberOfParticipants;
        Coordinates coordinates;
        Studio studio;
        Scanner scanner = new Scanner(System.in);
        MusicBand musicBand;
        if (id == 0) {
            musicBand = new MusicBand();
        } else musicBand = new MusicBand(id);

        // Input for MusicBand name
        while (true) {
            try {
                System.out.println("Input name (String): ");
                input = scanner.nextLine();
                Validator.inputIsFilled(input, "name");
                musicBand.setName(input);
                break;
            } catch (IncorrectInputException e) {
                System.out.println(e.getMessage());
            }
        }

        // Input for x coordinate
        while (true) {
            try {
                System.out.println("Input x (long) < 566: ");
                input = scanner.nextLine();
                Validator.coordinateXIsRight(input);
                x = input;
                break;
            } catch (IncorrectInputException e) {
                System.out.println(e.getMessage());
            }
        }

        // Input for y coordinate
        while (true) {
            try {
                System.out.println("Input y (Float): ");
                input = scanner.nextLine();
                Validator.coordinateYIsRight(input);
                y = input;
                break;
            } catch (IncorrectInputException e) {
                System.out.println(e.getMessage());
            }
        }

        coordinates = new Coordinates(Long.parseLong(x), Float.parseFloat(y));
        musicBand.setCoordinates(coordinates);

        // Input for studio name
        while (true) {
            try {
                System.out.println("Input studio (String): ");
                input = scanner.nextLine();
                Validator.inputIsFilled(input, "studio");
                studio = new Studio(input);
                musicBand.setStudio(studio);
                break;
            } catch (IncorrectInputException e) {
                System.out.println(e.getMessage());
            }
        }

        // Input for number of participants
        while (true) {
            try {
                System.out.println("Input number of participants (Integer) > 0: ");
                input = scanner.nextLine();
                Validator.number0fParticipantsIsRight(input);
                numberOfParticipants = input;
                musicBand.setNumber0fParticipants(Integer.parseInt(numberOfParticipants));
                break;
            } catch (IncorrectInputException e) {
                System.out.println(e.getMessage());
            }
        }

        // Input for MusicGenre
        while (true) {
            MusicGenre genre = null;
            try {
                System.out.println("Input MusicGenre:\n1 - PROGRESSIVE_ROCK\n2 - HIP_HOP\n3 - PSYCHEDELIC_CLOUD_RAP\n4 - PUNK_ROCK\n5 - BRIT_POP");
                input = scanner.nextLine().trim();
                switch (input) {
                    case "PROGRESSIVE_ROCK":
                        genre = MusicGenre.PROGRESSIVE_ROCK;
                        break;
                    case "HIP_HOP":
                        genre = MusicGenre.HIP_HOP;
                        break;
                    case "PSYCHEDELIC_CLOUD_RAP":
                        genre = MusicGenre.PSYCHEDELIC_CLOUD_RAP;
                        break;
                    case "PUNK_ROCK":
                        genre = MusicGenre.PUNK_ROCK;
                        break;
                    case "BRIT_POP":
                        genre = MusicGenre.BRIT_POP;
                        break;
                }
                if (genre == null) {
                    Validator.musicGenreIsRight(input);
                    int ind = Integer.parseInt(input);
                    genre = switch (ind) {
                        case 1 -> MusicGenre.PROGRESSIVE_ROCK;
                        case 2 -> MusicGenre.HIP_HOP;
                        case 3 -> MusicGenre.PSYCHEDELIC_CLOUD_RAP;
                        case 4 -> MusicGenre.PUNK_ROCK;
                        case 5 -> MusicGenre.BRIT_POP;
                        default -> throw new IllegalStateException("Unexpected value: genre");
                    };
                }
                musicBand.setGenre(genre);
                break;
            } catch (IncorrectInputException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("MusicBand created successfully");
        return musicBand;
    }
}

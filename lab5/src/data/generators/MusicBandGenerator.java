package data.generators;

import data.Coordinates;
import data.MusicBand;
import data.MusicGenre;
import data.Studio;
import exceptions.IncorrectInputException;
import managers.Validator;

import java.util.Scanner;

public class MusicBandGenerator {
    public static MusicBand createMusicBand(Integer id) {
        System.out.println("You have started the creation of a music band");
        String input, x, y, number0fParticipants;
        Coordinates coordinates;
        Studio studio;
        Scanner scanner = new Scanner(System.in);
        MusicBand musicBand;
        if (id == 0) {
            musicBand = new MusicBand();
        } else {
            musicBand = new MusicBand(id);
        }
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
        while (true) {
            try {
                System.out.println("Input number0fParticipants (Integer) > 0: ");
                input = scanner.nextLine();
                Validator.number0fParticipantsIsRight(input);
                number0fParticipants = input;
                musicBand.setNumber0fParticipants(Integer.parseInt(number0fParticipants));
                break;
            } catch (IncorrectInputException e) {
                System.out.println(e.getMessage());
            }
        }
        while (true) {
            try {
                System.out.println("Input MusicGenre (PROGRESSIVE_ROCK, HIP_HOP, PSYCHEDELIC_CLOUD_RAP, PUNK_ROCK, BRIT_POP): ");
                input = scanner.nextLine();
                Validator.musicGenreIsRight(input);
                musicBand.setGenre(MusicGenre.valueOf(input));
                break;
            } catch (IncorrectInputException e) {
                System.out.println(e.getMessage());
            }

        }
        return musicBand;
    }
}

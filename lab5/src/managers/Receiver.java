package managers;

import data.MusicBand;
import managers.commands.BaseCommand;

import java.io.*;
import java.util.*;

/**
 * The Receiver class contains methods for displaying information related to music bands.
 */
public class Receiver {

    /**
     * Displays the details of music bands in the collection in a formatted table.
     */
    public static void show() {
        PriorityQueue<MusicBand> collection = CollectionManager.getCollection();
        MusicBand[] musicBands = collection.toArray(new MusicBand[0]);

        if (collection.isEmpty()) {
            System.out.println("Collection is empty");
        } else {
            // Calculate maximum column widths
            int idMax = 0;
            int nameMax = 0;
            int xMax = 0;
            int yMax = 0;
            int numberOfParticipantsMax = 0;
            int studioMax = 0;
            for (MusicBand musicBand : collection) {
                idMax = Math.max(idMax, String.valueOf(musicBand.getId()).length());
                nameMax = Math.max(nameMax, musicBand.getName().length());
                xMax = Math.max(xMax, String.valueOf(musicBand.getCoordinates().getX()).length());
                yMax = Math.max(yMax, String.valueOf(musicBand.getCoordinates().getY()).length());
                numberOfParticipantsMax = Math.max(numberOfParticipantsMax, String.valueOf(musicBand.getNumber0fParticipants()).length());
                studioMax = Math.max(studioMax, musicBand.getStudio().getName().length());
            }

            // Define column widths
            int idColumnWidth = idMax + 5;
            int nameColumnWidth = nameMax + 5;
            int xsColumnWidth = xMax + 10;
            int ysColumnWidth = yMax + 10;
            int datesColumnWidth = 40;
            int numbersOfParticipantsColumnWidth = numberOfParticipantsMax + 25;
            int genresColumnWidth = 26;
            int studioNamesColumnWidth = studioMax + 15;

            // Print table header
            System.out.printf("%-" + genresColumnWidth + "s%-" + nameColumnWidth + "s%-"
                            + idColumnWidth + "s%-" + xsColumnWidth + "s%-" + ysColumnWidth + "s%-"
                            + studioNamesColumnWidth + "s%-" + numbersOfParticipantsColumnWidth + "s%-" + datesColumnWidth+ "s%n",
                    "GENRE", "NAME", "ID", "X", "Y", "STUDIONAME", "NUMBEROFPARTICIPANTS", "DATE");
            System.out.println("-".repeat(genresColumnWidth + nameColumnWidth + idColumnWidth
                    + xsColumnWidth + ysColumnWidth + studioNamesColumnWidth + numbersOfParticipantsColumnWidth
                    + datesColumnWidth));

            // Sort music bands array
            Arrays.sort(musicBands);

            // Print each music band's details
            for (MusicBand musicBand : musicBands) {
                String formattedId = String.format("%-" + idColumnWidth + "d", musicBand.getId());
                String formattedName = String.format("%-" + nameColumnWidth + "s", musicBand.getName());
                String formattedX = String.format("%-" + xsColumnWidth + "d", musicBand.getCoordinates().getX());
                String formattedY = String.format("%-" + ysColumnWidth + "f", musicBand.getCoordinates().getY());
                String formattedDate = String.format("%-" + datesColumnWidth + "s", musicBand.getCreationDate());
                String formattedNumOfPart = String.format("%-" + numbersOfParticipantsColumnWidth + "d", musicBand.getNumber0fParticipants());
                String formattedGenre = String.format("%-" + genresColumnWidth + "s", musicBand.getGenre());
                String formattedStudio = String.format("%-" + studioNamesColumnWidth + "s", musicBand.getStudio().getName());

                System.out.println(formattedGenre + formattedName + formattedId + formattedX + formattedY + formattedStudio + formattedNumOfPart + formattedDate);
            }
        }
    }

    public static void help() {
        CommandManager commandManager = new CommandManager();
        Map<String, BaseCommand> commandList = commandManager.getCommandList();
        for (String name : commandList.keySet()) {
            BaseCommand command = commandList.get(name);
            System.out.println(command.getName() + " - " + command.getDescription());
        }
    }

    /**
     * Executes commands from a script file.
     *
     * @param filePath The path to the script file.
     */
    public static void executeScript(String filePath) {
        Map<String, BaseCommand> commands = CommandManager.commandList;
        File file = new File(filePath);
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty()) {
                    String[] data = line.split(" ");
                    BaseCommand command = commands.get(data[0]);
                    if (command != null) {
                        if (data[0].equals("execute_script") && data.length > 1) {
                            if (!data[1].equals(filePath)) {
                                executeScript(data[1]);
                            } else {
                                System.out.println("Recursive execution of script files is not allowed: " + filePath);
                            }
                        } else if (data[0].equals("add")) {
                            addMusicBand(data);
                        } else {
                            command.execute(data);
                        }
                    } else {
                        System.out.println("This command does not exist: " + data[0]);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePath);
        } catch (Exception e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }

    /**
     * Adds a music band to the collection.
     *
     * @param tokens An array containing the data for creating the music band.
     * @throws Exception If there are not enough arguments to create a music band.
     */
    private static void addMusicBand(String[] tokens) throws Exception {
        if (tokens.length >= 8) {
            String[] data = Arrays.copyOfRange(tokens, 1, 8);
            MusicBand musicBand = new MusicBand(data);
            CollectionManager.add(musicBand);
            System.out.printf("The music band %s has been added to the collection. Collection size: %d%n", musicBand.getName(), CollectionManager.getCollection().size());
        } else {
            System.out.println("There are not enough arguments to create a music band.");
        }
    }
}


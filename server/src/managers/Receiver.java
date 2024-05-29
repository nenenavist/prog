package managers;

import data.MusicBand;
import managers.commands.BaseCommand;
import network.Request;
import network.Response;

import java.io.*;
import java.util.*;

/**
 * The Receiver class contains methods for displaying information related to music bands.
 */
public class Receiver {

    /**
     * Displays the details of music bands in the collection in a formatted table.
     */
    public static Response show() {
        PriorityQueue<MusicBand> collection = CollectionManager.getCollection();
        MusicBand[] musicBands = collection.toArray(new MusicBand[0]);

        if (collection.isEmpty()) {
            return new Response("Collection is empty");
        }
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

        StringBuilder stringBuilder = new StringBuilder();
        // Print table header
        String width = (String.format("%-" + idColumnWidth + "s%-" + nameColumnWidth + "s%-"
                        + genresColumnWidth + "s%-" + xsColumnWidth + "s%-" + ysColumnWidth + "s%-"
                        + studioNamesColumnWidth + "s%-" + numbersOfParticipantsColumnWidth + "s%-" + datesColumnWidth + "s%n",
                "ID", "NAME", "GENRE", "X", "Y", "STUDIONAME", "NUMBEROFPARTICIPANTS", "DATE") + "\n");
        String width2 = (String.format("-".repeat(idColumnWidth + nameColumnWidth + genresColumnWidth
                + xsColumnWidth + ysColumnWidth + studioNamesColumnWidth + numbersOfParticipantsColumnWidth
                + datesColumnWidth)) + "\n");

        stringBuilder.append(width);
        stringBuilder.append(width2);
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


            String band = formattedId + formattedName + formattedGenre + formattedX + formattedY + formattedStudio + formattedNumOfPart + formattedDate + "\n";
            stringBuilder.append(band);
        }
        stringBuilder.append("All created music bands are displayed");
        return new Response(stringBuilder.toString());
    }

    public static Response help() {
        CommandManager commandManager = new CommandManager();
        Map<String, BaseCommand> commandList = commandManager.getCommandList();
        StringBuilder help = new StringBuilder();
        for (String name : commandList.keySet()) {
            if (name.equals("check_id")) {
                continue;
            }
            BaseCommand command = commandList.get(name);
            help.append(command.getName() + " - " + command.getDescription() + "\n");
        }
        return new Response(help.toString());
    }

    public static Response executeScript(String filePath, ArrayList<String> filePathes) {
        StringBuilder script = new StringBuilder();
        Map<String, BaseCommand> commands = CommandManager.commandList;
        File file = new File(filePath);
        filePathes.add(filePath);
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty()) {
                    String[] data = line.split(" ");
                    BaseCommand command = commands.get(data[0]);
                    if (command != null) {
                        if (data[0].equals("execute_script") && data.length > 1) {
                            if (!filePathes.contains(data[1])) {
                                script.append(executeScript(data[1], filePathes).getResult() + "\n");
                            } else {
                                script.append("Recursive execution of script files is not allowed: " + filePath + "\n");
                            }
                        } else if (data[0].equals("add")) {
                            String[] values = new String[8];
                            for (int i = 1; i < values.length; i++) {
                                line = reader.readLine();
                                values[i] = line;
                            }
                            script.append(addMusicBand(values) + "\n");
                        } else if (data[0].equals("update")) {
                            Integer id = Integer.parseInt(data[1]);
                            String[] values = new String[8];
                            for (int i = 1; i < values.length; i++) {
                                line = reader.readLine();
                                values[i] = line;
                            }
                            script.append(updateMusicBand(values, id) + "\n");
                        } else if (data[0].equals("remove_lower")) {
                            String[] values = new String[8];
                            for (int i = 1; i < values.length; i++) {
                                line = reader.readLine();
                                values[i] = line;
                            }
                            script.append(removeLowerMusicBand(values) + "\n");
                        } else {
                            Request request = new Request(data);
                            command.execute(request);
                        }
                    } else {
                        script.append("This command does not exist: " + data[0] + "\n");
                    }
                }
            }
            filePathes.remove(filePath);
        } catch (FileNotFoundException e) {
            return new Response("File not found: " + filePath);
        } catch (Exception e) {
            return new Response("Error reading the file: " + e.getMessage());

        }
        return new Response(script.toString());
    }

    /**
     * Adds a music band to the collection.
     *
     * @param tokens An array containing the data for creating the music band.
     * @throws Exception If there are not enough arguments to create a music band.
     */
    private static String addMusicBand(String[] tokens) throws Exception {
        if (tokens.length >= 8) {
            ArrayList<String> data = new ArrayList<>();
            for (int i = 0; i < tokens.length; i++) {
                data.add(tokens[i]);
            }
            data.add(5, new Date().toString());
            MusicBand musicBand = new MusicBand(data.toArray(new String[0]));
            CollectionManager.add(musicBand);
            return String.format("The music band %s has been added to the collection. Collection size: %d%n", musicBand.getName(), CollectionManager.getCollection().size());
        }
        return "There are not enough arguments to create a music band.";
    }

    /**
     * Updates a music band with the provided information.
     *
     * @param tokens An array of strings containing the information for the update.
     * @param id The ID of the music band to update.
     * @throws Exception if an error occurs during the update process.
     */
    private static String updateMusicBand(String[] tokens, Integer id) throws Exception {
        if (tokens.length >= 7) {
            ArrayList<String> data = new ArrayList<>();
            for (int i = 0; i < tokens.length; i++) {
                data.add(tokens[i]);
            }
            data.add(4, new Date().toString());
            MusicBand musicBand = new MusicBand(id, data.toArray(new String[0]));
            CollectionManager.scriptUpdate(musicBand, id);
            return String.format("The music band %s has been updated");
        }
        return "There are not enough arguments to update a music band.";
    }

    /**
     * Removes all music bands that are lower than a specific music band.
     *
     * @param tokens An array of strings containing the information for comparison.
     * @throws Exception if an error occurs during the removal process.
     */
    private static String removeLowerMusicBand(String[] tokens) throws Exception {
        if (tokens.length >= 8) {
            ArrayList<String> data = new ArrayList<>();
            for (int i = 0; i < tokens.length; i++) {
                data.add(tokens[i]);
            }
            data.add(5, new Date().toString());
            MusicBand musicBand = new MusicBand(data.toArray(new String[0]), "");
            CollectionManager.removeLower(musicBand);
            return "Lower elements deleted successfully";
        }
        return "There are not enough arguments to create a music band.";
    }
}


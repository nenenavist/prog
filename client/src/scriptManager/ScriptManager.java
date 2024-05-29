package scriptManager;

import data.MusicBand;
import data.generators.IdGenerator;
import network.Client;
import network.Request;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class ScriptManager {
    public static ArrayList<String> programmCommands = new ArrayList<>(Arrays.asList("help", "info", "show", "add", "update", "remove_by_id", "clear", "save", "execute_script", "remove_head", "history", "filter_less_than_studio", "print_field_ascending_number_of_participants", "print_field_descending_studio", "remove_lower", "check_id"));
    public static void executeScript(String filePath, ArrayList<String> filePathes, Client client) {
        File file = new File(filePath);
        filePathes.add(filePath);
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty()) {
                    String[] data = line.split(" ");
                    String command = data[0];
                    if (programmCommands.contains(command)) {
                        if (data[0].equals("execute_script") && data.length > 1) {
                            if (!filePathes.contains(data[1])) {
                                executeScript(data[1], filePathes,client);
                            } else {
                                System.err.println("Recursive execution of script files is not allowed: " + filePath);
                                break;
                            }
                        } else if (data[0].equals("add")) {
                            ArrayList<String> values = new ArrayList<>();
                            try{
                                for (int i = 0; i < 6; i++) {
                                    line = reader.readLine();
                                    values.add(line);
                                }
                                Request addRequest = addMusicBand(values);
                                if (addRequest == null){
                                    System.out.println("Error while creating MusicBand");
                                }
                                else{
                                    System.out.println(client.callServer(addRequest));
                                }
                            }catch (Exception e){
                                e.printStackTrace();
                                System.out.println("Not enough arguments to create MusicBand");
                            }
                        } else if (data[0].equals("update")) {
                            Integer id = Integer.parseInt(data[1]);
                            ArrayList<String> values = new ArrayList<>();
                            try{
                                for (int i = 0; i < 6; i++) {
                                    line = reader.readLine();
                                    values.add(line);
                                }
                                Request updateRequest = updateMusicBand(values, id);
                                if (updateRequest == null){
                                    System.out.println("Error while creating MusicBand for update");
                                }
                                else{
                                    System.out.println(client.callServer(updateRequest));
                                }
                            }catch (Exception e){
                                System.out.println("Not enough arguments to update MusicBand");
                            }
                        } else if (data[0].equals("remove_lower")) {
                            ArrayList<String> values = new ArrayList<>();
                            try{
                                for (int i = 0; i < 6; i++) {
                                    line = reader.readLine();
                                    values.add(line);
                                }
                                Request removeLRequest = removeLowerMusicBand(values);
                                if (removeLRequest == null){
                                    System.out.println("Error while creating MusicBand for remove_lower");
                                }
                            }catch (Exception e){
                                System.out.println("Not enough arguments to create MusicBand");
                            }
                        } else {
                            Request request = new Request(data);
                            System.out.println(client.callServer(request));
                        }
                    } else {
                        System.out.println("This command does not exist: " + data[0]);
                    }
                }
            }
            filePathes.remove(filePath);
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
    private static Request addMusicBand(ArrayList<String> tokens) throws Exception {
        if (tokens.size() == 6) {
            tokens.add(0,"id");
            tokens.add(4, new Date().toString());
            MusicBand musicBand = new MusicBand(IdGenerator.generateId(),tokens.toArray(new String[0]));
            Request request = new Request(musicBand, new String[]{"add"});
            return request;
        }
        return null;
    }

    /**
     * Updates a music band with the provided information.
     *
     * @param tokens An array of strings containing the information for the update.
     * @param id The ID of the music band to update.
     * @throws Exception if an error occurs during the update process.
     */
    private static Request updateMusicBand(ArrayList<String> tokens, Integer id) throws Exception {
        if (tokens.size() == 6) {
            tokens.add(0,"id");
            tokens.add(4, new Date().toString());
            MusicBand musicBand = new MusicBand(id,tokens.toArray(new String[0]));
            Request request = new Request(musicBand, new String[]{"add"});
            return request;
        }
        return null;
    }

    /**
     * Removes all music bands that are lower than a specific music band.
     *
     * @param tokens An array of strings containing the information for comparison.
     * @throws Exception if an error occurs during the removal process.
     */
    private static Request removeLowerMusicBand(ArrayList<String> tokens) throws Exception {
        if (tokens.size() == 6) {
            tokens.add(0,"id");
            tokens.add(4, new Date().toString());
            MusicBand musicBand = new MusicBand(IdGenerator.generateId(),tokens.toArray(new String[0]));
            Request request = new Request(musicBand, new String[]{"add"});
            return request;
        }
        return null;
    }
}

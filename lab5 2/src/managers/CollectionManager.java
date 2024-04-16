package managers;

import data.MusicBand;
import data.comparators.NumberOfParticipantsComparator;
import data.comparators.StudioComparator;
import data.generators.IdGenerator;
import data.generators.MusicBandGenerator;
import exceptions.NoElementException;
import exceptions.RootException;
import system.XMLWriter;


import javax.xml.bind.JAXBException;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.PriorityQueue;

/**
 * The CollectionManager class manages a collection of MusicBand objects.
 * It provides methods for adding, removing, and retrieving elements from the collection,
 * as well as for providing information about the collection itself.
 */
public class CollectionManager {

    /** The collection of MusicBand objects. */
    private static PriorityQueue<MusicBand> collection = new PriorityQueue<>();

    /** The date of initialization for the collection. */
    private static Date date;

    /**
     * Constructs a CollectionManager object.
     * Initializes the collection and date fields.
     * If a string argument is provided, it attempts to deserialize the collection from XML using an XMLSerializer.
     *
     * @param arg The argument for deserializing the collection from XML.
     */
    public CollectionManager(String arg) {
        collection = new PriorityQueue<>();
        date = new Date();
        try {

        } catch (Exception e) {
            System.out.println("Autoloading Error");
        }
    }

    /**
     * Retrieves the collection of MusicBand objects.
     *
     * @return The collection of MusicBand objects.
     */
    public static PriorityQueue<MusicBand> getCollection() {
        return collection;
    }

    /**
     * Retrieves the initialization date of the collection.
     *
     * @return The initialization date of the collection.
     */
    public static Date getDate() {
        return date;
    }

    /**
     * Adds a MusicBand object to the collection.
     * If the collection is null, it initializes the collection.
     *
     * @param musicBand The MusicBand object to be added to the collection.
     */
    public static void add(MusicBand musicBand) {
        if (collection == null) {
            collection = new PriorityQueue<>();
        }
        collection.add(musicBand);
        IdGenerator.add(musicBand.getId());
    }

    /**
     * Removes a MusicBand object from the collection based on its ID.
     * Throws a NoElementException if no element with the specified ID is found.
     *
     * @param id The ID of the MusicBand object to be removed from the collection.
     * @throws NoElementException If no element with the specified ID is found in the collection.
     */
    public static void remove(Integer id) throws NoElementException {
        int flag = 0;
        for (MusicBand musicBand : collection) {
            if (musicBand.getId().equals(id)) {
                collection.remove(musicBand);
                flag = 1;
                break;
            }
        }
        if (flag == 0) {
            throw new NoElementException(id);
        }
    }

    /**
     * Removes the first MusicBand object from the collection.
     */
    public static void removeHead() {
        collection.poll();
        System.out.println("First element removed");
    }

    /**
     * Prints information about the collection, including its type, count of music bands, and initialization date.
     */
    public static void info() {
        System.out.println("Collection type - " + collection.getClass().getName());
        System.out.println("Count of music bands - " + collection.size());
        System.out.println("Init date - " + date);
    }

    /**
     * Filters and prints MusicBand objects from the collection whose studio name length is less than the specified value.
     * If the collection is empty, it prints a message indicating that the collection is empty.
     *
     * @param args An array of arguments, where the second argument is the studio name length to compare against.
     */
    public static void filterLessThanStudio(String[] args) {
        if (collection.isEmpty()) {
            System.out.println("collection is empty");
        } else {
            String[] argsWithoutSpaces = deleteSpaces(args);
            MusicBand[] arrayMusicBands = collection.toArray(new MusicBand[0]);
            StudioComparator SC = new StudioComparator();
            Arrays.sort(arrayMusicBands, SC);
            String nameStudio = argsWithoutSpaces[1];
            for (MusicBand musicBand : arrayMusicBands) {
                if (musicBand.getStudio().getName().length() < nameStudio.length()) {
                    System.out.println(musicBand.getName());
                }
            }
        }
    }

    /**
     * Prints the studio names of MusicBand objects in descending order based on the studio name.
     * If the collection is empty, it prints a message indicating that the collection is empty.
     */
    public static void printFieldDescendingStudio() {
        if (collection.isEmpty()) {
            System.out.println("collection is empty");
        } else {
            MusicBand[] arrayMusicBands = collection.toArray(new MusicBand[0]);
            StudioComparator SC = new StudioComparator();
            Arrays.sort(arrayMusicBands, SC);
            for (int i = arrayMusicBands.length - 1; i >= 0; i--) {
                System.out.println(arrayMusicBands[i].getName() + ": " + arrayMusicBands[i].getStudio().getName());
            }
        }
    }

    /**
     * Prints the number of participants of MusicBand objects in ascending order based on the number of participants.
     * If the collection is empty, it prints a message indicating that the collection is empty.
     */
    public static void printFieldAscendingNumberOfParticipants() {
        if (collection.isEmpty()) {
            System.out.println("collection is empty");
        } else {
            MusicBand[] arrayMusicBands = collection.toArray(new MusicBand[0]);
            NumberOfParticipantsComparator NPC = new NumberOfParticipantsComparator();
            Arrays.sort(arrayMusicBands, NPC);
            for (int i = 0; i < arrayMusicBands.length; i++) {
                System.out.println(arrayMusicBands[i].getName()+ ": " + arrayMusicBands[i].getNumber0fParticipants());
            }
        }
    }

    /**
     * Updates the MusicBand object in the collection with the specified ID.
     * If no element with the specified ID is found, it prints a message indicating that no element with the ID exists.
     * If the ID provided is not in the correct format, it prints a message indicating a wrong ID format.
     *
     * @param args An array of arguments, where the second argument is the ID of the MusicBand object to update.
     */
    public static void updateById(String[] args) {
        int id;
        try {
            String[] argsWithoutSpaces = deleteSpaces(args);
            id = Integer.parseInt(argsWithoutSpaces[1]);
            int flag = 0;
            for (MusicBand musicBand : collection) {
                if (musicBand.getId() == id) {
                    collection.add(MusicBandGenerator.createMusicBand(musicBand.getId()));
                    collection.remove(musicBand);
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                System.out.println("No element with this id");
            }
        } catch (Exception e) {
            System.out.println("Wrong id format");
        }
    }

    /**
     * Removes a music band from the collection by its ID.
     *
     * @param args The command arguments containing the ID of the music band to remove.
     */
    public static void removeById(String[] args) {
        try {
            String[] argsWithoutSpaces = deleteSpaces(args);
            CollectionManager.remove(Integer.parseInt(argsWithoutSpaces[1].trim()));
            System.out.println("Element was removed");
        } catch (NoElementException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Saves the collection to a file specified by the provided path.
     *
     */
    public static void save() {
        try {
            XMLWriter.write(Console.data_path);
            System.out.println("Save successfully");
        } catch (IOException e) {
            System.out.println("Input or output error");
        } catch (RootException e) {
            System.out.println("You do not have enough rights to read the file");
        }
    }
    public static String[] deleteSpaces(String[] args) {
        ArrayList<String> newArgs = new ArrayList<>();
        for (String arg: args) {
            arg.trim();
            if (!arg.isEmpty()) {
                newArgs.add(arg);
            }
        }
        return newArgs.toArray(new String[0]);
    }
}
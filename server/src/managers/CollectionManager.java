package managers;

import data.MusicBand;
import data.comparators.NumberOfParticipantsComparator;
import data.comparators.StudioComparator;
import data.generators.IdGenerator;
import exceptions.RootException;
import network.Request;
import network.Response;
import system.XMLWriter;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

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
     */
    public CollectionManager(String arg) {
        try {
            date = new Date();
        } catch (Exception e) {
            System.out.println("Autoloading Error");
        }
    }


    public static Response removeLower(MusicBand musicBand) {
        NumberOfParticipantsComparator NPC = new NumberOfParticipantsComparator();
        if (collection.removeIf(x -> NPC.compare(x, musicBand) < 0)) return new Response("Elements were deleted successfully");
        else return new Response("No elements lower than specified :(");
    }

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
    public static Response add(MusicBand musicBand) {
        if (collection == null) {
            collection = new PriorityQueue<>();
        }
        collection.add(musicBand);
        IdGenerator.add(musicBand.getId());
        return new Response("Music band added successfully");
    }

    public static Response remove(int id) {
        Optional<MusicBand> optionalMusicBand = collection.stream().filter(x -> x.getId() == id).findFirst();
        if (optionalMusicBand.isPresent()) {
            MusicBand musicBand = optionalMusicBand.get();
            collection.remove(musicBand);
            return new Response("Element removed successfully :)");
        } else {
            return new Response("No element with this id :(");
        }
    }


    /**
     * Removes the first MusicBand object from the collection.
     */
    public static Response removeHead() {
        StringBuilder head = new StringBuilder();
        if (collection.isEmpty()) {
            return new Response("Collection is empty!!!");
        }
        head.append("First element: ").append(collection.peek()).append("\n");
        collection.poll();
        head.append("First element removed");
        return new Response(head.toString());
    }

    /**
     * Prints information about the collection, including its type, count of music bands, and initialization date.
     */
    public static Response info() {
        StringBuilder info = new StringBuilder();
        info.append("Collection type - ").append(collection.getClass().getName() + "\n");
        info.append("Count of music bands - ").append(collection.size() + "\n");
        info.append("Init date - ").append(date + "\n");
        return new Response(info.toString());
    }

    public static Response filterLessThanStudio(String[] args) {
        if (collection.isEmpty()) {
            return new Response("collection is empty");
        }
        StringBuilder filter = new StringBuilder();
        String[] argsWithoutSpaces = deleteSpaces(args);
        MusicBand[] arrayMusicBands = collection.toArray(new MusicBand[0]);
        String nameStudio = argsWithoutSpaces[1];
        String lessStudio = Arrays.stream(arrayMusicBands).filter(x -> x.getStudio().getName().compareTo(nameStudio) < 0).map(x -> x.getStudio().getName()).collect(Collectors.joining("\n"));
        filter.append(lessStudio + "\n");
        filter.append("All suitable elements displayed");
        return new Response(filter.toString());
    }

    public static Response printFieldDescendingStudio() {
        if (collection.isEmpty()) {
            return new Response("collection is empty");
        }
        StringBuilder desc = new StringBuilder();
        MusicBand[] arrayMusicBands = collection.toArray(new MusicBand[0]);
        StudioComparator SC = new StudioComparator();
        String descending = Arrays.stream(arrayMusicBands).sorted(SC.reversed()).map(x -> x.getId() + ": " + x.getStudio().getName()).collect(Collectors.joining("\n"));
        desc.append(descending + "\n");
        desc.append("All suitable elements displayed");
        return new Response(desc.toString());
    }

    public static Response printFieldAscendingNumberOfParticipants() {
        if (collection.isEmpty()) {
            return new Response("collection is empty");
        }
        StringBuilder asc = new StringBuilder();
        MusicBand[] arrayMusicBands = collection.toArray(new MusicBand[0]);
        NumberOfParticipantsComparator NPC = new NumberOfParticipantsComparator();
        String ascending = Arrays.stream(arrayMusicBands).sorted(NPC).map(x -> x.getId() + ": " + x.getNumber0fParticipants()).collect(Collectors.joining("\n"));
        asc.append(ascending + "\n");
        asc.append("All suitable elements displayed");
        return new Response(asc.toString());
    }


    public static Response checkId(Request request) {
        List list;
        try {
            int id = Integer.parseInt(request.getArgs()[1]);
            list = collection.stream().filter(x -> x.getId() == id).toList();
        } catch (NumberFormatException e) {
            return new Response("Wrong id format! Try again...");
        }
        if (!list.isEmpty()) {
            return new Response("1");
        }
        return new Response("No element with this id :(");
    }

    public static Response updateById(Request request) {
        int id;
        try {
            String[] argsWithoutSpaces = deleteSpaces(request.getArgs());
            id = Integer.parseInt(argsWithoutSpaces[1]);
            Optional<MusicBand> optionalMusicBand = collection.stream().filter(x -> x.getId() == id).findFirst();
            if (optionalMusicBand.isPresent()) {
                MusicBand musicBand = optionalMusicBand.get();
                MusicBand newMusB = request.getMusicBand();
                newMusB.setId(id);
                collection.remove(musicBand);
                collection.add(newMusB);
                return new Response("Element updated successfully :)");
            } else {
                return new Response("No element with this id :(");
            }
        } catch (Exception e) {
            return new Response("Wrong id format! Try again...");
        }
    }


    public static void scriptUpdate(MusicBand musicBand, Integer id){
        int flag = 0;
        for(MusicBand element: collection){
            if(id.equals(element.getId())){
                musicBand.setId(id);
                collection.add(musicBand);
                collection.remove(element);
                flag = 1;
                break;
            }
        }
        if(flag == 0){
            System.out.println("No element with this id :(");
        }
    }

    public static Response removeById(Request request) {
        try {
            String[] argsWithoutSpaces = deleteSpaces(request.getArgs());
            return CollectionManager.remove(Integer.parseInt(argsWithoutSpaces[1].trim()));
        } catch (NumberFormatException e) {
            return new Response("Wrong id format! Try again...");
        }
    }

    public static Response save() {
        try {
            XMLWriter.write(Console.data_path);
            return new Response("Save successfully");
        } catch (IOException e) {
            return new Response("Input or output error");
        } catch (RootException e) {
            return new Response("You do not have enough rights to read the file");
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
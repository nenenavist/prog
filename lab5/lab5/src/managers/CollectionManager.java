package managers;

import data.MusicBand;
import data.comparators.NumberOfParticipantsComparator;
import data.comparators.StudioComparator;
import data.generators.IdGenerator;
import data.generators.MusicBandGenerator;
import exceptions.NoElementException;
import managers.commands.BaseCommand;
import system.XMLSerializer;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;
import java.util.PriorityQueue;

public class CollectionManager {
    private static PriorityQueue<MusicBand> collection = new PriorityQueue<>();
    private static Date date;
    public CollectionManager(String arg) {
        collection = new PriorityQueue<>();
        date = new Date();
        try{
            XMLSerializer serializer = new XMLSerializer();
            collection = serializer.deserialize(arg);
        }
        catch (Exception e){
            System.out.println("Autoloading Error");
        }
    }

    public static Date getDate() {
        return date;
    }
    public static void add(MusicBand musicBand) {
        if (collection == null) {
            collection = new PriorityQueue<>();
        }
        collection.add(musicBand);
        IdGenerator.add(musicBand.getId());
    }
    public static void remove(Integer id) throws NoElementException {
        int flag = 0;
        for (MusicBand musicBand: collection){
            if (musicBand.getId().equals(id)){
                collection.remove(musicBand);
                flag = 1 ;
                break;
            }
        }
        if (flag == 0){
            throw new NoElementException(id);
        }
    }
    public static void removeHead(){
        collection.poll();
    }
    public static void info() {
        System.out.println("Collection type - " + collection.getClass().getName());
        System.out.println("Count of music bands - " + collection.size());
        System.out.println("Init date - " + date);
    }

    public static void show(){
        if (collection.isEmpty()) {
            System.out.println("Collection is empty");
        } else {
            int i = 1;
            for (MusicBand musicBand : collection) {
                System.out.println(i + ": " + musicBand.getName() + "___" + musicBand.getId());
                i++;
            }
        }
    }
    public static void filterLessThanStudio(String[] args){
        if (collection.isEmpty()) {
            System.out.println("collection is empty");
        } else {
            MusicBand[] arrayMusicBands = collection.toArray(new MusicBand[0]);
            StudioComparator SC = new StudioComparator();
            Arrays.sort(arrayMusicBands, SC);
            String nameStudio = args[1];
            for (MusicBand musicBand: arrayMusicBands) {
                if (musicBand.getStudio().getName().length() < nameStudio.length()) {
                    System.out.println(musicBand.getName());
                }
            }
        }
    }

    public static void printFieldDescendingStudio(){
        if (collection.isEmpty()) {
            System.out.println("collection is empty");
        } else {
            MusicBand[] arrayMusicBands = collection.toArray(new MusicBand[0]);
            StudioComparator SC = new StudioComparator();
            Arrays.sort(arrayMusicBands, SC);
            int number = 1;
            for(int i = arrayMusicBands.length - 1; i >= 0; i--){
                System.out.println(number + ": " + arrayMusicBands[i].getStudio().getName());
                number++;
            }
        }
    }

    public static void printFieldAscendingNumberOfParticipants(String[] args){
        if (collection.isEmpty()) {
            System.out.println("collection is empty");
        } else {
            MusicBand[] arrayMusicBands = collection.toArray(new MusicBand[0]);
            NumberOfParticipantsComparator NPC = new NumberOfParticipantsComparator();
            Arrays.sort(arrayMusicBands, NPC);
            for(int i = 0;i < arrayMusicBands.length; i++){
                System.out.println(i + 1 + ": " + arrayMusicBands[i].getNumber0fParticipants());
            }
        }
    }

    public static void updateById(String[] args) {
        int id;
        try{
            id = Integer.parseInt(args[1]);
            int flag = 0;
            for (MusicBand musicBand : collection){
                if (musicBand.getId() == id){
                    collection.add(MusicBandGenerator.createMusicBand(musicBand.getId()));
                    collection.remove(musicBand);
                    flag = 1;
                    break;
                }
            }
            if (flag == 0){
                System.out.println("No element with this id");
            }
        }
        catch (Exception e){
            System.out.println("Wrong id format");
        }
    }

    public static void removeById(String[] args) {
        try {
            CollectionManager.remove(Integer.parseInt(args[1]));
            System.out.println("Element was removed");
        } catch (NoElementException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void help() {
        CommandManager commandManager = new CommandManager();
        Map<String, BaseCommand> commandList = commandManager.getCommandList();
        for (String name: commandList.keySet()){
            BaseCommand command = commandList.get(name);
            System.out.println(command.getName() + " - " + command.getDescription());
        }
    }

    public static PriorityQueue<MusicBand> getCollection() {
        return collection;
    }

    public static void save(String[] args){
        String path = args[1];
        XMLSerializer stream = new XMLSerializer();
        String xml = stream.serialize(collection);
        try {
            BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(path));
            byte[] bytes = xml.getBytes();
            output.write(bytes);
            output.close();
            System.out.println("Save successfully");
        } catch (Exception e) {
            System.out.println("Try again :(");
        }
    }
}

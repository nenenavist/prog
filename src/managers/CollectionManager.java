package managers;

import data.MusicBand;
import data.generators.IdGenerator;
import exceptions.NoElementException;

import java.util.Date;
import java.util.PriorityQueue;

public class CollectionManager {
    private static PriorityQueue<MusicBand> collection = new PriorityQueue<>();
    private static Date date;
    public CollectionManager() {
        collection = new PriorityQueue<>();
        date = new Date();
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
            if (musicBand.getId() == id){
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

    public static PriorityQueue<MusicBand> getCollection() {
        return collection;
    }
}

package data.generators;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * The IdGenerator class provides functionality for generating unique IDs.
 * It ensures that the generated IDs are unique within the application.
 */
public class IdGenerator implements Serializable {
    @Serial
    private static final long serialVersionUID = -4927040936096842240L;
    private static ArrayList<Integer> idList = new ArrayList<>();

    /**
     * Constructs a new IdGenerator instance.
     */
    public IdGenerator(){
        idList = new ArrayList<>();
    }

    /**
     * Generates a unique ID.
     *
     * @return a unique ID
     */
    public static Integer generateId(){
        Integer id = (int)Math.floor(Math.random() * 386800) + 244;
        while (idList.contains(id)){
            id = (int)Math.floor(Math.random() * 386800) + 244;
        }
        idList.add(id);
        return id;
    }

    /**
     * Checks if an ID is unique.
     *
     * @param id the ID to check
     * @return true if the ID is unique, false otherwise
     */
    public static boolean idIsUnique(int id){
        return !idList.contains(id);
    }

    /**
     * Removes an ID from the list of used IDs.
     *
     * @param id the ID to remove
     */
    public static void remove(int id){
        idList.remove(Integer.valueOf(id));
    }

    /**
     * Adds an ID to the list of used IDs.
     *
     * @param id the ID to add
     */
    public static void add(int id){
        idList.add(id);
    }
}

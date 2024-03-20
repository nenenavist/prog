package data.generators;

import java.util.ArrayList;

public class IdGenerator {
    private static ArrayList<Integer> idList = new ArrayList<>();
    public IdGenerator(){
        idList = new ArrayList<>();
    }
    public static Integer generateId(){
        Integer id = (int)Math.floor(Math.random() * 386800) + 244;
        while (idList.contains(id)){
            id = (int)Math.floor(Math.random() * 386800) + 244;
        }
        idList.add(id);
        return id;
    }
    public static boolean idIsUnique(int id){
        if (idList.contains(id)){
            return false;
        }
        return true;
    }
    public static void remove(int id){
        idList.remove(id);
    }
    public static void add(int id){
        idList.add(id);
    }
}

package managers.commands;

import data.MusicBand;
import managers.CollectionManager;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;

public class ShowCommand implements BaseCommand {
    @Override
    public void execute(String[] args) throws Exception {
        PriorityQueue<MusicBand> collectionList = CollectionManager.getCollection();
        if (collectionList.isEmpty()) {
            System.out.println("Collection is empty");
        } else {
           int i = 1;
           for (MusicBand musicBand : collectionList) {
               System.out.println(i + ": " + musicBand.getName());
               i++;
           }
        }
    }


    @Override
    public String getName() {
        return "show";
    }

    @Override
    public String getDescription() {
        return "show data";
    }
}

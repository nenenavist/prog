package managers.commands;

import data.MusicBand;
import data.comparators.StudioComparator;
import managers.CollectionManager;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class FilterLessThanStudioCommand implements BaseCommand {
    @Override
    public void execute(String[] args) throws Exception {
        PriorityQueue<MusicBand> collection = CollectionManager.getCollection();
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

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getDescription() {
        return null;
    }
}

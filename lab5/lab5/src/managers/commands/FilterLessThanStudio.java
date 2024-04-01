package managers.commands;

import data.MusicBand;
import data.comparators.StudioComparator;
import managers.CollectionManager;

import java.util.Arrays;
import java.util.PriorityQueue;

public class FilterLessThanStudio implements BaseCommand {
    @Override
    public void execute(String[] args) throws Exception {
        CollectionManager.filterLessThanStudio(args);
    }

    @Override
    public String getName() {
        return "filter_less_than_studio studio:";
    }

    @Override
    public String getDescription() {
        return "display elements whose studio field value is less than a given one";
    }
}

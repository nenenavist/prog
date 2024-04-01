package managers.commands;

import data.MusicBand;
import managers.CollectionManager;

import java.util.PriorityQueue;

public class Show implements BaseCommand {
    @Override
    public void execute(String[] args) throws Exception {
        CollectionManager.show();
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

package managers.commands;

import data.generators.IdGenerator;
import data.generators.MusicBandGenerator;
import managers.CollectionManager;

public class AddCommand implements BaseCommand {
    @Override
    public void execute(String[] args) throws Exception {
        CollectionManager.add(MusicBandGenerator.createMusicBand(IdGenerator.generateId()));
    }

    @Override
    public String getName() {
        return "add";
    }

    @Override
    public String getDescription() {
        return "add a new item to the collection";
    }
}

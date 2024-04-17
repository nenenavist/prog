package managers.commands;

import data.generators.IdGenerator;
import data.generators.MusicBandGenerator;
import managers.CollectionManager;

/**
 * The Add class represents a command to add a new item to the collection.
 */
public class Add implements BaseCommand {

    /**
     * Executes the add command, generating a new MusicBand object and adding it to the collection.
     *
     * @param args command arguments (not used)
     * @throws Exception if an error occurs during command execution
     */
    @Override
    public void execute(String[] args) throws Exception {
        CollectionManager.add(MusicBandGenerator.createMusicBand(IdGenerator.generateId()));
    }

    /**
     * Gets the name of the command.
     *
     * @return the name of the command
     */
    @Override
    public String getName() {
        return "add";
    }

    /**
     * Gets the description of the command.
     *
     * @return the description of the command
     */
    @Override
    public String getDescription() {
        return "add a new item to the collection";
    }
}

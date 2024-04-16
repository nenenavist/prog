package managers.commands;

import managers.CollectionManager;

/**
 * The Save class represents a command to save the collection to a file.
 */
public class Save implements BaseCommand {

    /**
     * Executes the save command, saving the collection to a file.
     *
     * @param args command arguments, where args[0] contains the file path
     * @throws Exception if an error occurs during command execution
     */
    @Override
    public void execute(String[] args) throws Exception {
        CollectionManager.save();
    }

    /**
     * Gets the name of the command.
     *
     * @return the name of the command
     */
    @Override
    public String getName() {
        return "save";
    }

    /**
     * Gets the description of the command.
     *
     * @return the description of the command
     */
    @Override
    public String getDescription() {
        return "save the collection to a file";
    }
}

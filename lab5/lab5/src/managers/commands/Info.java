package managers.commands;

import managers.CollectionManager;

/**
 * The Info class represents a command to see information about the collection.
 */
public class Info implements BaseCommand {

    /**
     * Executes the info command, displaying information about the collection.
     *
     * @param args command arguments (not used)
     * @throws Exception if an error occurs during command execution
     */
    @Override
    public void execute(String[] args) throws Exception {
        CollectionManager.info();
    }

    /**
     * Gets the name of the command.
     *
     * @return the name of the command
     */
    @Override
    public String getName() {
        return "info";
    }

    /**
     * Gets the description of the command.
     *
     * @return the description of the command
     */
    @Override
    public String getDescription() {
        return "use this command to see information about the collection";
    }
}

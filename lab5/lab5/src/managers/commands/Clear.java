package managers.commands;

import managers.CollectionManager;

/**
 * The Clear class represents a command to clear the collection.
 */
public class Clear implements BaseCommand {

    /**
     * Executes the clear command, removing all elements from the collection.
     *
     * @param args command arguments (not used)
     * @throws Exception if an error occurs during command execution
     */
    @Override
    public void execute(String[] args) throws Exception {
        CollectionManager.getCollection().clear();
        System.out.println("Collection was cleared");
    }

    /**
     * Gets the name of the command.
     *
     * @return the name of the command
     */
    @Override
    public String getName() {
        return "clear";
    }

    /**
     * Gets the description of the command.
     *
     * @return the description of the command
     */
    @Override
    public String getDescription() {
        return "clear collection";
    }
}

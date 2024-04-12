package managers.commands;

import exceptions.NoElementException;
import managers.CollectionManager;

/**
 * The RemoveById class represents a command to delete an item from the collection by its ID.
 */
public class RemoveById implements BaseCommand {

    /**
     * Executes the remove_by_id command, removing an item from the collection by its ID.
     *
     * @param args command arguments, where args[0] contains the ID of the item to be removed
     * @throws Exception if an error occurs during command execution, or if the item with the specified ID does not exist
     */
    @Override
    public void execute(String[] args) throws Exception {
        CollectionManager.removeById(args);
    }

    /**
     * Gets the name of the command.
     *
     * @return the name of the command
     */
    @Override
    public String getName() {
        return "remove_by_id id";
    }

    /**
     * Gets the description of the command.
     *
     * @return the description of the command
     */
    @Override
    public String getDescription() {
        return "delete an item from the collection by its id";
    }
}

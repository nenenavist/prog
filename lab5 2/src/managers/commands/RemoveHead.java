package managers.commands;

import managers.CollectionManager;

/**
 * The RemoveHead class represents a command to print the first item of the collection and delete it.
 */
public class RemoveHead implements BaseCommand {

    /**
     * Executes the remove_head command, printing the first item of the collection and deleting it.
     *
     * @param args command arguments (not used)
     * @throws Exception if an error occurs during command execution
     */
    @Override
    public void execute(String[] args) throws Exception {
        CollectionManager.removeHead();
    }

    /**
     * Gets the name of the command.
     *
     * @return the name of the command
     */
    @Override
    public String getName() {
        return "remove_head";
    }

    /**
     * Gets the description of the command.
     *
     * @return the description of the command
     */
    @Override
    public String getDescription() {
        return "print the first item of the collection and delete it";
    }
}

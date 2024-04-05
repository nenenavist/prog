package managers.commands;

import managers.CollectionManager;

/**
 * The Update class represents a command to update the value of a collection element whose ID is equal to the specified one.
 */
public class Update implements BaseCommand {

    /**
     * Executes the update command, updating the value of a collection element whose ID is equal to the specified one.
     *
     * @param args command arguments, where args[0] contains the ID of the element to be updated
     *             and args[1] onwards contain the new values for the element
     * @throws Exception if an error occurs during command execution
     */
    @Override
    public void execute(String[] args) throws Exception {
        CollectionManager.updateById(args);
    }

    /**
     * Gets the name of the command.
     *
     * @return the name of the command
     */
    @Override
    public String getName() {
        return "update id {element}";
    }

    /**
     * Gets the description of the command.
     *
     * @return the description of the command
     */
    @Override
    public String getDescription() {
        return "update the value of a collection element whose ID is equal to the specified one";
    }
}

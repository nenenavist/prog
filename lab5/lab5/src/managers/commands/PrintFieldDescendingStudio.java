package managers.commands;

import managers.CollectionManager;

/**
 * The PrintFieldDescendingStudio class represents a command to output the values of the studio field of all elements in descending order.
 */
public class PrintFieldDescendingStudio implements BaseCommand {

    /**
     * Executes the print_field_descending_studio command, printing the values of the studio field of all elements in descending order.
     *
     * @param args command arguments (not used)
     * @throws Exception if an error occurs during command execution
     */
    @Override
    public void execute(String[] args) throws Exception {
        CollectionManager.printFieldDescendingStudio();
    }

    /**
     * Gets the name of the command.
     *
     * @return the name of the command
     */
    @Override
    public String getName() {
        return "print_field_descending_studio";
    }

    /**
     * Gets the description of the command.
     *
     * @return the description of the command
     */
    @Override
    public String getDescription() {
        return "output the studio field values of all elements in descending order";
    }
}

package managers.commands;

import managers.CollectionManager;

/**
 * The PrintFieldAscendingNumberOfParticipants class represents a command to output the values of the
 * numberOfParticipants field of all elements in ascending order.
 */
public class PrintFieldAscendingNumberOfParticipants implements BaseCommand {

    /**
     * Executes the print_field_ascending_number_of_participants command, printing the values of the
     * numberOfParticipants field of all elements in ascending order.
     *
     * @param args command arguments (not used)
     * @throws Exception if an error occurs during command execution
     */
    @Override
    public void execute(String[] args) throws Exception {
        CollectionManager.printFieldAscendingNumberOfParticipants();
    }

    /**
     * Gets the name of the command.
     *
     * @return the name of the command
     */
    @Override
    public String getName() {
        return "print_field_ascending_number_of_participants";
    }

    /**
     * Gets the description of the command.
     *
     * @return the description of the command
     */
    @Override
    public String getDescription() {
        return "output the values of the numberOfParticipants field of all elements in ascending order";
    }
}

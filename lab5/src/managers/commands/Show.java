package managers.commands;

import managers.Receiver;

/**
 * The Show class represents a command to display data.
 */
public class Show implements BaseCommand {

    /**
     * Executes the show command, displaying data.
     *
     * @param args command arguments (not used)
     * @throws Exception if an error occurs during command execution
     */
    @Override
    public void execute(String[] args) throws Exception {
        Receiver.show();
    }

    /**
     * Gets the name of the command.
     *
     * @return the name of the command
     */
    @Override
    public String getName() {
        return "show";
    }

    /**
     * Gets the description of the command.
     *
     * @return the description of the command
     */
    @Override
    public String getDescription() {
        return "show data";
    }
}

package managers.commands;

import managers.Receiver;

/**
 * The Help class represents a command to display available commands.
 */
public class Help implements BaseCommand {

    /**
     * Executes the help command, delegating the execution to Receiver.
     *
     * @param args command arguments (not used)
     * @throws Exception if an error occurs during command execution
     */
    @Override
    public void execute(String[] args) throws Exception {
        Receiver.help();
    }

    /**
     * Gets the name of the command.
     *
     * @return the name of the command
     */
    @Override
    public String getName() {
        return "help";
    }

    /**
     * Gets the description of the command.
     *
     * @return the description of the command
     */
    @Override
    public String getDescription() {
        return "use this command to see available commands";
    }
}

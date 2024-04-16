package managers.commands;

import managers.CommandManager;

/**
 * The History class represents a command to print the last 12 commands.
 */
public class History implements BaseCommand {

    /**
     * Executes the history command, printing the last 12 commands.
     *
     * @param args command arguments (not used)
     * @throws Exception if an error occurs during command execution
     */
    @Override
    public void execute(String[] args) throws Exception {
        CommandManager.printLastCommands();
    }

    /**
     * Gets the name of the command.
     *
     * @return the name of the command
     */
    @Override
    public String getName() {
        return "history";
    }

    /**
     * Gets the description of the command.
     *
     * @return the description of the command
     */
    @Override
    public String getDescription() {
        return "print the last 12 commands";
    }
}

package managers.commands;

/**
 * The Exit class represents a command to end the program.
 */
public class Exit implements BaseCommand {

    /**
     * Executes the exit command, terminating the program.
     *
     * @param args command arguments (not used)
     * @throws Exception if an error occurs during command execution (not expected)
     */
    @Override
    public void execute(String[] args) throws Exception {
        System.exit(0);
    }

    /**
     * Gets the name of the command.
     *
     * @return the name of the command
     */
    @Override
    public String getName() {
        return "exit";
    }

    /**
     * Gets the description of the command.
     *
     * @return the description of the command
     */
    @Override
    public String getDescription() {
        return "end the program";
    }
}

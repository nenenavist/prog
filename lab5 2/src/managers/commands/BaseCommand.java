package managers.commands;

/**
 * The BaseCommand interface represents a command in the application.
 * Each command must implement this interface.
 */
public interface BaseCommand {

    /**
     * Executes the command with the given arguments.
     *
     * @param args the command arguments
     * @throws Exception if an error occurs during command execution
     */
    void execute(String[] args) throws Exception;

    /**
     * Gets the name of the command.
     *
     * @return the name of the command
     */
    String getName();

    /**
     * Gets the description of the command.
     *
     * @return the description of the command
     */
    String getDescription();
}

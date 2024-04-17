package managers.commands;

import managers.CollectionManager;
import managers.Receiver;

/**
 * The ExecuteScript class represents a command to read and execute a script from the specified file.
 */
public class ExecuteScript implements BaseCommand {

    /**
     * Executes the execute_script command, delegating the execution to the Receiver.
     *
     * @param args command arguments, where args[1] contains the path to the script file
     */
    @Override
    public void execute(String[] args) {
        String[] argsWithoutSpaces = CollectionManager.deleteSpaces(args);
        Receiver.executeScript(argsWithoutSpaces[1]);
    }

    /**
     * Gets the name of the command.
     *
     * @return the name of the command
     */
    @Override
    public String getName() {
        return "execute_script";
    }

    /**
     * Gets the description of the command.
     *
     * @return the description of the command
     */
    @Override
    public String getDescription() {
        return "Read and execute the script from the specified file";
    }
}

package managers.commands;

import managers.CollectionManager;

/**
 * The FilterLessThanStudio class represents a command to filter elements based on their studio field value.
 * It displays elements whose studio field value is less than a given one.
 */
public class FilterLessThanStudio implements BaseCommand {

    /**
     * Executes the filter_less_than_studio command, delegating the execution to CollectionManager.
     *
     * @param args command arguments, where args[0] contains the threshold studio value
     * @throws Exception if an error occurs during command execution
     */
    @Override
    public void execute(String[] args) throws Exception {
        CollectionManager.filterLessThanStudio(args);
    }

    /**
     * Gets the name of the command.
     *
     * @return the name of the command
     */
    @Override
    public String getName() {
        return "filter_less_than_studio studio:";
    }

    /**
     * Gets the description of the command.
     *
     * @return the description of the command
     */
    @Override
    public String getDescription() {
        return "display elements whose studio field value is less than a given one";
    }
}

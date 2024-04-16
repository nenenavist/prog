package managers;

import exceptions.ManyArgumentsException;
import exceptions.UnknownCommandException;
import managers.commands.*;

import java.util.*;

/**
 * The manager class responsible for handling commands and their execution.
 */
public class CommandManager {

    /**
     * ArrayDeque to store the last twelve executed commands.
     */
    public static ArrayDeque<BaseCommand> lastTwelveCommand = new ArrayDeque<>();

    /**
     * Map to store available commands with their corresponding names.
     */
    public static Map<String, BaseCommand> commandList;

    /**
     * Constructs a CommandManager and initializes the commandList map with available commands.
     */
    public CommandManager() {
        commandList = new HashMap<>();
        commandList.put("help", new Help());
        commandList.put("info", new Info());
        commandList.put("show", new Show());
        commandList.put("add", new Add());
        commandList.put("update", new Update());
        commandList.put("remove_by_id", new RemoveById());
        commandList.put("clear", new Clear());
        commandList.put("save", new Save());
        commandList.put("execute_script", new ExecuteScript());
        commandList.put("exit", new Exit());
        commandList.put("remove_head", new RemoveHead());
        commandList.put("history", new History());
        commandList.put("filter_less_than_studio", new FilterLessThanStudio());
        commandList.put("print_field_ascending_number_of_participants", new PrintFieldAscendingNumberOfParticipants());
        commandList.put("print_field_descending_studio", new PrintFieldDescendingStudio());
    }

    /**
     * Executes the command specified by the given input line.
     *
     * @param line The input line containing the command to execute.
     * @throws Exception if any error occurs during command execution.
     * @throws ManyArgumentsException if the command has too many arguments.
     * @throws UnknownCommandException if the command is not recognized.
     */
    public static void startExecuting(String line) throws Exception, ManyArgumentsException {
        String commandName = line.split(" ")[0].trim();
        if (!commandList.containsKey(commandName)) {
            throw new UnknownCommandException(commandName);
        }
        if (!commandName.equals("execute_script") && !commandName.equals("update") && !commandName.equals("remove_by_id") && !commandName.equals("filter_less_than_studio") && !commandName.equals("save")) {
            if (line.split(" ").length>1){
                throw new ManyArgumentsException(commandName);
            }
        }

        BaseCommand command = commandList.get(commandName);
        command.execute(line.split(" "));
        if (!(lastTwelveCommand == null) && lastTwelveCommand.size() == 12) {
            lastTwelveCommand.pop();
            lastTwelveCommand.addLast(command);
        } else {
            assert lastTwelveCommand != null;
            lastTwelveCommand.addFirst(command);
        }

    }

    /**
     * Retrieves the map containing available commands.
     *
     * @return The map of available commands.
     */
    public Map<String, BaseCommand> getCommandList() {
        return commandList;
    }

    /**
     * Retrieves the last twelve executed commands.
     *
     * @return The ArrayDeque containing the last twelve commands.
     */
    public static ArrayDeque<BaseCommand> getLastCommands(){
        return lastTwelveCommand;
    }

    /**
     * Prints the last twelve executed commands.
     */
    public static void printLastCommands(){
        if (lastTwelveCommand.isEmpty()){
            System.out.println("History is empty");
        }
        else{
            for (BaseCommand command : lastTwelveCommand){
                System.out.println(command.getName());
            }
        }
    }
}

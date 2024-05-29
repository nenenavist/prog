package managers;


import managers.commands.*;
import network.Request;
import network.Response;


import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

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
        commandList.put("help", new Help());//+api
        commandList.put("info", new Info());//+api
        commandList.put("show", new Show());//+api
        commandList.put("add", new Add());//+api
        commandList.put("update", new Update());//+api
        commandList.put("remove_by_id", new RemoveById());//+api
        commandList.put("clear", new Clear());//+api
        commandList.put("save", new Save());//+api
        commandList.put("execute_script", new ExecuteScript());//+api
        commandList.put("remove_head", new RemoveHead());//+api
        commandList.put("history", new History());//+api
        commandList.put("filter_less_than_studio", new FilterLessThanStudio());//+api
        commandList.put("print_field_ascending_number_of_participants", new PrintFieldAscendingNumberOfParticipants());//+api
        commandList.put("print_field_descending_studio", new PrintFieldDescendingStudio());//+api
        commandList.put("remove_lower", new RemoveLower());//+api
        commandList.put("check_id", new CheckId());//+api
    }


    public static Response startExecuting(Request request) {
        BaseCommand command = commandList.get(request.getArgs()[0]);
        if (command== null){
            return new Response("No command with this name");
        }
        if (!(lastTwelveCommand == null) && lastTwelveCommand.size() == 12) {
            lastTwelveCommand.pop();
            lastTwelveCommand.addLast(command);
        } else {
            assert lastTwelveCommand != null;
            lastTwelveCommand.addFirst(command);
        }
        if (command.isHasArguments() && request.getArgs().length<2){
            return new Response("No arguments for command: " + command.getName());
        }
        if (!command.isHasArguments() && request.getArgs().length>1){
            return new Response("This command should have NO arguments, sorry :c");
        }
        return command.execute(request);
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
    public static Response printLastCommands(){
        StringBuilder lastCom = new StringBuilder();
        if (lastTwelveCommand.isEmpty()){
            return new Response("History is empty");
        }
        for (BaseCommand command : lastTwelveCommand){
            lastCom.append(command.getName() + "\n");
        }
        return new Response(lastCom.toString());
    }
}

package managers;

import exceptions.UnknownCommandException;
import managers.commands.*;

import java.util.*;

public class CommandManager {
    public static ArrayDeque<BaseCommand> lastTwelveCommand = new ArrayDeque<>();
    public static Map<String, BaseCommand> commandList;

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

    public static void startExecuting(String line) throws Exception {
        String commandName = line.split(" ")[0];
        if (!commandList.containsKey(commandName)) {
            throw new UnknownCommandException(commandName);
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
    public Map<String, BaseCommand> getCommandList() {
        return commandList;
    }
    public static ArrayDeque<BaseCommand> getLastCommands(){
        return lastTwelveCommand;
    }

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

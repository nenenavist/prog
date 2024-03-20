package managers;

import exceptions.UnknownCommandException;
import managers.commands.*;

import java.util.*;

public class CommandManager {
    public static ArrayDeque<BaseCommand> lastTwelveCommand = new ArrayDeque<>();
    private static Map<String, BaseCommand> commandList;

    public CommandManager() {
        commandList = new HashMap<>();
        commandList.put("help", new HelpCommand());
        commandList.put("info", new InfoCommand());
        commandList.put("show", new ShowCommand());
        commandList.put("add", new AddCommand());
        commandList.put("update", new UpdateCommand());
        commandList.put("remove_by_id", new RemoveByIdCommand());
        commandList.put("clear", new ClearCommand());
        commandList.put("save", new SaveCommand());
        commandList.put("execute_script", new ExecuteScriptCommand());
        commandList.put("exit", new ExitCommand());
        commandList.put("remove_head", new RemoveHead());
        commandList.put("history", new HistoryCommand());
        commandList.put("filter_less_than_studio", new FilterLessThanStudioCommand());
        commandList.put("print_field_ascending_number_of_participants", new PrintFieldAscendingNumberOfParticipantsCommand());
        commandList.put("print_field_descending_studio", new PrintFieldDescendingStudioCommand());
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
}

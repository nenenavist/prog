package managers.commands;

import managers.CollectionManager;
import managers.Receiver;
import network.Request;
import network.Response;

import java.util.ArrayList;

/**
 * The ExecuteScript class represents a command to read and execute a script from the specified file.
 */
public class ExecuteScript extends BaseCommand {

    public ExecuteScript() {
        super("execute_script [String script_path]", true, "Read and execute the script from the specified file");
    }

    @Override
    public Response execute(Request request) {
        String[] argsWithoutSpaces = CollectionManager.deleteSpaces(request.getArgs());
        ArrayList<String> filePathes = new ArrayList<>();
        return Receiver.executeScript(argsWithoutSpaces[1], filePathes);
    }
}

package managers;

import network.Request;
import network.Response;
import system.XMLReader;

/**
 * The Console class handles the interaction with the user through the command line interface.
 */
public class Console {
    public static String data_path = "lab.xml";

    public Response start(Request request) {
       CommandManager commandManager = new CommandManager();
        new CollectionManager(data_path);
//        try {
//            XMLReader.read(data_path);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
        return commandManager.startExecuting(request);
    }
}

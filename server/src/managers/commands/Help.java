package managers.commands;

import managers.Receiver;
import network.Request;
import network.Response;

/**
 * The Help class represents a command to display available commands.
 */
public class Help extends BaseCommand {

    public Help() {
        super("help", false, "use this command to see available commands");
    }

    @Override
    public Response execute(Request request) {
        return Receiver.help();
    }
}

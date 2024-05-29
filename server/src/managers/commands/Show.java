package managers.commands;

import managers.Receiver;
import network.Request;
import network.Response;

/**
 * The Show class represents a command to display data.
 */
public class Show extends BaseCommand {

    public Show() {
        super("show", false, "show data");
    }

    @Override
    public Response execute(Request request) {
        return Receiver.show();

    }
}

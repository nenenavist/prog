package managers.commands;

import managers.CollectionManager;
import network.Request;
import network.Response;

/**
 * The PrintFieldDescendingStudio class represents a command to output the values of the studio field of all elements in descending order.
 */
public class PrintFieldDescendingStudio extends BaseCommand {

    public PrintFieldDescendingStudio() {
        super("print_field_descending_studio", false, "output the studio field values of all elements in descending order");
    }

    @Override
    public Response execute(Request request) {
        return CollectionManager.printFieldDescendingStudio();
    }
}

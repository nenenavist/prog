package managers.commands;

import managers.CollectionManager;
import network.Request;
import network.Response;

/**
 * The RemoveById class represents a command to delete an item from the collection by its ID.
 */
public class RemoveById extends BaseCommand {

    public RemoveById() {
        super("remove_by_id [int id]", true, "delete an item from the collection by its id");
    }

    @Override
    public Response execute(Request request) {
        return CollectionManager.removeById(request);
    }
}

package managers.commands;

import managers.CollectionManager;
import network.Request;
import network.Response;

/**
 * The Update class represents a command to update the value of a collection element whose ID is equal to the specified one.
 */
public class Update extends BaseCommand {

    public Update() {
        super("update [int id] {MusicBand}", false, "update the value of a collection element whose ID is equal to the specified one");
    }

    @Override
    public Response execute(Request request) {
        return CollectionManager.updateById(request);
    }
}

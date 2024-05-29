package managers.commands;

import managers.CollectionManager;
import network.Request;
import network.Response;

/**
 * The FilterLessThanStudio class represents a command to filter elements based on their studio field value.
 * It displays elements whose studio field value is less than a given one.
 */
public class FilterLessThanStudio extends BaseCommand {

    public FilterLessThanStudio() {
        super("filter_less_than_studio [String studio]", true, "display elements whose studio field value is less than a given one");
    }

    @Override
    public Response execute(Request request) {
        return CollectionManager.filterLessThanStudio(request.getArgs());
    }
}

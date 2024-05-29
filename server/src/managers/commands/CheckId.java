package managers.commands;

import managers.CollectionManager;
import network.Request;
import network.Response;

public class CheckId extends BaseCommand{
    public CheckId() {
        super("check_id", true, "checks the correctness of the id");
    }
    @Override
    public Response execute(Request request) {
        return CollectionManager.checkId(request);
    }
}

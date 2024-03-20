package managers.commands;

import managers.CollectionManager;

public class ClearCommand implements BaseCommand {
    @Override
    public void execute(String[] args) throws Exception {
        CollectionManager.getCollection().clear();
    }

    @Override
    public String getName() {
        return "clear";
    }

    @Override
    public String getDescription() {
        return "clear collection";
    }
}

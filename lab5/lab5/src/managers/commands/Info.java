package managers.commands;

import managers.CollectionManager;

public class Info implements BaseCommand {

    @Override
    public void execute(String[] args) throws Exception {
        CollectionManager.info();
    }

    @Override
    public String getName() {
        return "info";
    }

    @Override
    public String getDescription() {
        return "use this command to see information about the collection";
    }
}

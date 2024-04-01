package managers.commands;

import managers.CollectionManager;

public class Clear implements BaseCommand {
    @Override
    public void execute(String[] args) throws Exception {
        CollectionManager.getCollection().clear();
        System.out.println("Collection was cleared");
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

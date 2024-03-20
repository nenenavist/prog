package managers.commands;

import managers.CollectionManager;

public class InfoCommand implements BaseCommand {

    @Override
    public void execute(String[] args) throws Exception {
        System.out.println("Collection type - " + CollectionManager.getCollection().getClass().getName());
        System.out.println("Count of music bands - " + CollectionManager.getCollection().size());
        System.out.println("Init date - " + CollectionManager.getDate());
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

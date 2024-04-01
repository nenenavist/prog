package managers.commands;

import managers.CollectionManager;

public class RemoveHead implements BaseCommand {
    @Override
    public void execute(String[] args) throws Exception {
        CollectionManager.removeHead();
    }

    @Override
    public String getName() {
        return "remove_head";
    }

    @Override
    public String getDescription() {
        return "print the first item of the collection and delete it";
    }
}

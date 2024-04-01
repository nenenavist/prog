package managers.commands;

import exceptions.NoElementException;
import managers.CollectionManager;

public class RemoveById implements BaseCommand {
    @Override
    public void execute(String[] args) throws Exception{
        CollectionManager.removeById(args);
    }

    @Override
    public String getName() {
        return "remove_by_id id";
    }

    @Override
    public String getDescription() {
        return "delete an item from the collection by it's id";
    }
}

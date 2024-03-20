package managers.commands;

import exceptions.NoElementException;
import managers.CollectionManager;

public class RemoveByIdCommand implements BaseCommand {
    @Override
    public void execute(String[] args) throws Exception{
        try {
            CollectionManager.remove(Integer.parseInt(args[1]));
            System.out.println("Element was removed");
        } catch (NoElementException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String getName() {
        return "remove_by_id";
    }

    @Override
    public String getDescription() {
        return "delete an item from the collection by it's id";
    }
}

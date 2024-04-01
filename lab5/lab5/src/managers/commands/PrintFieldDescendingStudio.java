package managers.commands;

import managers.CollectionManager;

public class PrintFieldDescendingStudio implements BaseCommand {
    @Override
    public void execute(String[] args) throws Exception {
        CollectionManager.printFieldDescendingStudio();
    }

    @Override
    public String getName() {
        return "print_field_descending_studio";
    }

    @Override
    public String getDescription() {
        return null;
    }
}

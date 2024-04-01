package managers.commands;

import managers.CollectionManager;

public class Save implements BaseCommand {
    @Override
    public void execute(String[] args) throws Exception {
        CollectionManager.save(args);
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getDescription() {
        return null;
    }
}

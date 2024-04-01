package managers.commands;

import managers.CollectionManager;
import managers.CommandManager;

import java.util.Map;

public class Help implements BaseCommand {
    @Override
    public void execute(String[] args) throws Exception {
        CollectionManager.help();
    }

    @Override
    public String getName() {
        return "help";
    }

    @Override
    public String getDescription() {
        return "use this command to see available commands";
    }
}

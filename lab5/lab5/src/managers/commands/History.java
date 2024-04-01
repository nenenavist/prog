package managers.commands;

import managers.CommandManager;

public class History implements BaseCommand {
    @Override
    public void execute(String[] args) throws Exception {
        CommandManager.printLastCommands();
    }
    @Override
    public String getName() {
        return "history";
    }

    @Override
    public String getDescription() {
        return null;
    }
}

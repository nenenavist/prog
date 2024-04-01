package managers.commands;

public class Exit implements BaseCommand {
    @Override
    public void execute(String[] args) throws Exception {
        System.exit(0);
    }

    @Override
    public String getName() {
        return "exit";
    }

    @Override
    public String getDescription() {
        return "end the programm";
    }
}

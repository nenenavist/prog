package managers.commands;

import managers.CollectionManager;

public class Update implements BaseCommand {
    @Override
    public void execute(String[] args) throws Exception {
        CollectionManager.updateById(args);
    }

    @Override
    public String getName() {
        return "update id {element}";
    }

    @Override
    public String getDescription() {
        return "update the value of a collection element whose i is equal to the specified one";
    }
}

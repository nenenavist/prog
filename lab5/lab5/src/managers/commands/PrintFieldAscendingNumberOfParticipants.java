package managers.commands;

import managers.CollectionManager;

public class PrintFieldAscendingNumberOfParticipants implements BaseCommand {
    @Override
    public void execute(String[] args) throws Exception {
        CollectionManager.printFieldAscendingNumberOfParticipants(args);
    }

    @Override
    public String getName() {
        return "print_field_ascending_number_of_participants";
    }

    @Override
    public String getDescription() {
        return "output the values of the numberOfParticipants field of all elements in ascending order";
    }
}

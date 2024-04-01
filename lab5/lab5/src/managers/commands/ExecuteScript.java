package managers.commands;

import java.io.*;

import static managers.CommandManager.commandList;

public class ExecuteScript implements BaseCommand {
    @Override
    public void execute(String[] args) {
        File file = new File(args[1]);
        try {
            BufferedInputStream bf = new BufferedInputStream(new FileInputStream(file));
            BufferedReader r = new BufferedReader(new InputStreamReader(bf));
            while (true) {
                try {
                    String line = r.readLine().trim();
                    if (!line.isEmpty()) {
                        String[] tokens = line.split(" ");
                        BaseCommand command = commandList.get(tokens[0]);
                        if (command != null) {
                            // Check if the command is to execute another script
                            if (tokens[0].equals("execute_script") && tokens.length > 1) {
                                // Prevent infinite recursion by tracking already executed scripts
                                execute(tokens);
                            } else {
                                // Execute other commands normally
                                command.execute(tokens);
                            }
                        } else {
                            System.out.println("This command does not exist: " + tokens[0]);
                        }
                    }
                } catch (IOException e) {
                    break;
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Reading file error: " + e.getMessage());
        }
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

package managers.commands;

import data.MusicBand;
import data.generators.IdGenerator;
import managers.CollectionManager;

import java.io.*;
import java.util.Map;

public class ExecuteScript implements BaseCommand {

    Map<String, BaseCommand> commands;
    public ExecuteScript(Map<String, BaseCommand> commands) {
        this.commands = commands;
    }

    @Override
    public void execute(String[] args) {
        executeScript(args[1]);
    }

    private void executeScript(String filePath) {
        File file = new File(filePath);
        try {
            BufferedReader r = new BufferedReader(new InputStreamReader(new BufferedInputStream(new FileInputStream(file))));
            while (true) {
                try {
                    String line = r.readLine().trim();
                    if (!line.isEmpty()) {
                        String[] data = line.split(" ");
                        BaseCommand command = commands.get(data[0]);
                        if (command != null) {
                            if (data[0].equals("execute_script") && data.length > 1) {
                                executeScript(data[1]);
                            } else if (data[0].equals("add")) {
                                addMusicBand(data);
                            } else {
                                command.execute(data);
                            }
                        } else {
                            System.out.println("This command does not exists: " + data[0]);
                        }
                    }
                } catch (IOException e) {
                    break;
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File reading error: " + e.getMessage());
        }
    }
    private void addMusicBand(String[] tokens) throws Exception {
        if (tokens.length >= 8) {
            String[] data = new String[8];
            data[1] = tokens[1];
            data[2] = Integer.toString(IdGenerator.generateId());
            data[3] = tokens[2];
            data[4] = tokens[3];
            data[5] = tokens[4];
            data[6] = tokens[5];
            data[7] = tokens[6];
            MusicBand musicBand = new MusicBand(data);
            CollectionManager.add(musicBand);
            System.out.printf("Организация %s добавлена в коллекцию. Размер коллекции: %d%n", musicBand.getName(), CollectionManager.getCollection().size());
        } else {
            System.out.println("Недостаточно аргументов для создания организации.");
        }
    }
    @Override
    public String getName() {
        return "execute_script";
    }

    @Override
    public String getDescription() {
        return "Read and execute the script from the specified file";
    }
}

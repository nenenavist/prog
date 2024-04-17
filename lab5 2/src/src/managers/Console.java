package managers;

import system.XMLReader;

import java.io.InputStream;
import java.util.Scanner;

/**
 * The Console class handles the interaction with the user through the command line interface.
 */
public class Console {
    public static String data_path;

    /**
     * Starts the console, reads user input, and executes corresponding commands.
     *
     * @param input The InputStream to read user input from.
     * @param arg The argument passed to initialize the collection manager.
     */
    public void start(InputStream input, String arg) {
        Scanner scanner = new Scanner(input);
        CommandManager commandManager = new CommandManager();
        new CollectionManager(arg);
        try {
            System.out.println("Downloading data from file...");
            XMLReader.read(arg);
            data_path = arg;
            System.out.println("Everything is OK.");
        } catch (Exception e) {
            System.out.println("Error while reading file: " + arg);
            System.exit(0);
        }
        System.out.println("Welcome to the app!");
        while (scanner.hasNextLine()) {
            String command = scanner.nextLine().trim();
            if (!command.isEmpty()) {
                try {
                    commandManager.startExecuting(command);
                } catch (Exception e) {
                    System.out.println("Command executing error");
                    e.printStackTrace();
                }
            }
        }
    }
}

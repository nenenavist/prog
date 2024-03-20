package managers;

import system.XMLSerializer;

import java.io.InputStream;
import java.util.Scanner;

public class Console {

    public static String data_path;

    public void start(InputStream input, String[] args) {
        Scanner scanner = new Scanner(input);
        CommandManager commandManager = new CommandManager();
        new CollectionManager();
        //ТУТ ДОЛЖЕН БЫТЬ ПАРСЕРРРРРРРРРРРРРР

        System.out.println("Welcome to app!");
        while (scanner.hasNextLine()) {
            String command = scanner.nextLine().trim();
            if (!command.isEmpty()){
                try {
                    commandManager.startExecuting(command);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
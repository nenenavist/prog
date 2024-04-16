package system;

import managers.Console;

/**
 * The Main class represents the entry point of the application.
 * It initializes the Console and starts processing user input.
 */
public class Main {

    /**
     * The main method is the entry point of the application.
     * It creates a Console instance and starts processing user input.
     *
     * @param args Command-line arguments. The first argument is expected to be the path to the file.
     */
    public static void main(String[] args){
        Console console = new Console();
        String path = args[0];
        console.start(System.in, path);
    }
}

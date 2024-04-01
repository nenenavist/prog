package system;

import managers.Console;

import java.io.File;
import java.util.Scanner;


public class Main {
    public static void main(String[] args){
        Console console = new Console();
        System.out.print("Write filename: ");
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();
        System.out.println("Autoloading complited");
        console.start(System.in, path);

    }
}
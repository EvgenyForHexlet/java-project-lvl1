package hexlet.code;

import java.util.Scanner;

public class Cli {

    private static Scanner scanner = new Scanner(System.in);


    public static void doSomeStaff() {
        System.out.println("Welcome to the Brain Games!");
        String name = askForString("May I have your name? ");
        System.out.println("Hello, " + name + "!");
    }

    private static String askForString(String question) {
        System.out.print(question);
        return scanner.next();
    }

}

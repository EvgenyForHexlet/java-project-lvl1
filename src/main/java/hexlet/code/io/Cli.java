package hexlet.code.io;

import java.util.Scanner;

public final class Cli {

    private static Scanner scanner = new Scanner(System.in);

    public static void printLine(String line) {
        System.out.println(line);
    }

    public static void printError(String error) {
        System.err.println(error);
    }

    public static String askForString(String question) {
        System.out.print(question);
        return scanner.next();
    }

    public static Integer askForInt(String question) {
        System.out.print(question);

        if (scanner.hasNextInt()) {
            return scanner.nextInt();
        }
        scanner.next();
        return null;
    }

}

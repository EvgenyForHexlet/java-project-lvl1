package hexlet.code.errors;

import hexlet.code.io.Cli;

/**
 * It is not a game, but it implements Game interface.
 */
public class Error {

    /**
     * The Error doesn'r have own number.
     *
     * @return just not valid negative value
     */
    public static int getGameNumber() {
        return -1;
    }

    /**
     * @return error
     */
    public static String getName() {
        return "Error";
    }

    /**
     * Just prints error message.
     */
    public static void play() {
        Cli.printError("The input was wrong. Please start the game again.");

    }
}

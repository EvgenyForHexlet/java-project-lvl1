package hexlet.code.games.impl;

import hexlet.code.common.SharedMemory;
import hexlet.code.io.Cli;

public class GreetGame {

    private static final int GAME_NUMBER = 1;

    /**
     * game number.
     *
     * @return game number.
     */
    public static int getGameNumber() {
        return GAME_NUMBER;
    }

    /**
     * game name.
     *
     * @return game name.
     */
    public static String getName() {
        return "Greet";
    }

    /**
     * starts the game.
     */
    public static void play() {
        Cli.printLine("Welcome to the Brain Games!");
        SharedMemory.setUser(Cli.askForString("May I have your name? "));
        Cli.printLine("Hello, " + SharedMemory.getUser() + "!");

    }
}

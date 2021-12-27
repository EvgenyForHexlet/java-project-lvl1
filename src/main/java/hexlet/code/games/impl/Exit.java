package hexlet.code.games.impl;


import hexlet.code.common.SharedMemory;
import hexlet.code.io.Cli;

public class Exit {

    private static final int GAME_NUMBER = 0;

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
        return "Exit";
    }

    /**
     * starts the game.
     */
    public static void play() {
        String sayGoodbye = "Good bye";
        sayGoodbye += SharedMemory.getUser().equals("") ? "" : ", " + SharedMemory.getUser();
        Cli.printLine(sayGoodbye);
    }
}

package hexlet.code.games;

import hexlet.code.GameEngine;

public class GreetGame {

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
        GameEngine.play("", null);
    }
}

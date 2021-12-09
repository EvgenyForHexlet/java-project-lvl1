package hexlet.code.games.impl;

public class GreetGame extends AbstractGame<String> {

    private static final int GAME_NUMBER = 1;
    /**
     * game number.
     *
     * @return game number.
     */
    public int getGameNumber() {
        return GAME_NUMBER;
    }

    /**
     * game name.
     * @return game name.
     */
    public String getName() {
        return "Greet";
    }

    /**
     * starts the game.
     */
    public void play() {
        getCli().printLine("Welcome to the Brain Games!");
        getSharedMemory().setUser(getCli().askForString("May I have your name? "));
        getCli().printLine("Hello, " + getSharedMemory().getUser() + "!");

    }
}

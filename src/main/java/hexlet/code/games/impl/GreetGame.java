package hexlet.code.games.impl;

public class GreetGame extends AbstractGame<String> {

    /**
     * game number.
     * @return game number.
     */
    public int getGameNumber() {
        return 1;
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

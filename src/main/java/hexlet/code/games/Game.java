package hexlet.code.games;

public interface Game {

    /**
     * Gets number of a game.
     * @return number of a game
     */
    int getGameNumber();

    /**
     * Gets name of a game.
     * @return name of a game
     */
    String getName();

    /**
     * Starts a game.
     */
    void play();
}

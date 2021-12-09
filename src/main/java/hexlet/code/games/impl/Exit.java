package hexlet.code.games.impl;


public class Exit extends AbstractGame<String> {

    private static final int GAME_NUMBER = 0;
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
        return "Exit";
    }

    /**
     * starts the game.
     */
    public void play() {
        String sayGoodbye = "Good bye";
        sayGoodbye += getSharedMemory().getUser().equals("") ? "" : ", " + getSharedMemory().getUser();
        getCli().printLine(sayGoodbye);
    }
}

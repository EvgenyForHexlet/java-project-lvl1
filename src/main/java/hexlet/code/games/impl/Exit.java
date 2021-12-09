package hexlet.code.games.impl;


public class Exit extends AbstractGame<String> {
    /**
     * game number.
     * @return game number.
     */
    public int getGameNumber() {
        return 0;
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

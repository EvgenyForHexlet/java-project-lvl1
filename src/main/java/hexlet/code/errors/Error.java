package hexlet.code.errors;

import hexlet.code.games.Game;
import hexlet.code.io.Cli;

/**
 * It is not a game, but it implements Game interface.
 */
public class Error implements Game {

    private Cli cli;

    public Error() {
        cli = Cli.getIOManager();
    }

    /**
     * The Error doesn'r have own number.
     * @return just not valid negative value
     */
    public int getGameNumber() {
        return -1;
    }

    /**
     * @return error
     */
    public String getName() {
        return "Error";
    }

    /**
     * Just prints error message.
     */
    public void play() {
        cli.printError("The input was wrong. Please start the game again.");

    }
}

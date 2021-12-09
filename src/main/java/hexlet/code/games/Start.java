package hexlet.code.games;

//import hexlet.code.games.common.SharedMemory;

//import hexlet.code.games.impl.CalculatorGame;

import hexlet.code.games.impl.EvenGame;
import hexlet.code.common.SharedMemory;
import hexlet.code.errors.Error;
import hexlet.code.games.impl.Exit;
//import hexlet.code.games.impl.GCDGame;
//import hexlet.code.games.impl.GreetGame;
//import hexlet.code.games.impl.PrimeGame;
//import hexlet.code.games.impl.ProgressionGame;
import hexlet.code.io.Cli;


import hexlet.code.games.impl.GreetGame;

/**
 *
 */
public class Start {

    private final Cli ioManager;
    private Game[] games;
    private final Game greetGame = new GreetGame();
    private final Game exit = new Exit();
    private final Game error = new Error();
    private static final int TRIES = 3;
    private static final int NUMBER_OF_ALL_GAMES = 3;


    /**
     * default constructor.
     */
    public Start() {
        ioManager = Cli.getIOManager();
        SharedMemory.getSharedMemory().setTries(TRIES);
        games = new Game[NUMBER_OF_ALL_GAMES];
        games[0] = greetGame;
//        games[1] = new CalculatorGame();
//        games[2] = new ProgressionGame();
        games[1] = new EvenGame();
//        games[4] = new GCDGame();
//        games[5] = new PrimeGame();
        games[2] = exit;
    }

    /**
     * Starts the game.
     */
    public void play() {

        ioManager.printLine("Please enter the game number and press Enter.");
        ioManager.printLines(generateGameLines());
        Integer number = ioManager.askForInt("Your choice: ");

        Game game = findGameByNumber(number);
        if (game.equals(greetGame) || game.equals(exit) || game.equals(error)) {
            game.play();
        } else {
            greetGame.play();
            game.play();
        }

    }

    private String[] generateGameLines() {

        String[] lines = new String[games.length];
        for (int i = 0; i < games.length; i++) {
            String line = games[i].getGameNumber() + " - " + games[i].getName();
            lines[i] = line;
        }
        return lines;
    }

    private Game findGameByNumber(Integer number) {

        if (number != null) {
            for (Game game : games) {
                if (game.getGameNumber() == number) {
                    return game;
                }
            }
        }
        return error;
    }
}

package hexlet.code.games;

import hexlet.code.games.impl.CalculatorGame;
import hexlet.code.games.impl.EvenGame;
import hexlet.code.common.SharedMemory;
import hexlet.code.errors.Error;
import hexlet.code.games.impl.Exit;
import hexlet.code.games.impl.GCDGame;
import hexlet.code.games.impl.ProgressionGame;
import hexlet.code.io.Cli;


import hexlet.code.games.impl.GreetGame;

/**
 *
 */
public class Start {

    private final Cli cli = Cli.getIOManager();
    private Game[] games;
    private final Game greetGame = new GreetGame();
    private final Game exit = new Exit();
    private final Game error = new Error();
    private static final int TRIES = 3;
    private static final int NUMBER_OF_ALL_GAMES = 6;


    /**
     * default constructor.
     */
    public Start() {
        init();
    }

    /**
     * Starts the game.
     */
    public void play() {

        cli.printLine("Please enter the game number and press Enter.");
        cli.printLines(generateGameLines());
        Integer number = cli.askForInt("Your choice: ");

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
        for (int i = 1; i < games.length; i++) {
            String line = games[i].getGameNumber() + " - " + games[i].getName();
            lines[i - 1] = line;
        }
        int exitNumber = 0;
        lines[games.length - 1] = games[exitNumber].getGameNumber() + " - " + games[exitNumber].getName();
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

    private void init() {

        SharedMemory.getSharedMemory().setTries(TRIES);
        games = new Game[NUMBER_OF_ALL_GAMES];
        games[greetGame.getGameNumber()] = greetGame;
        Game even = new EvenGame();
        games[even.getGameNumber()] = even;
        Game calc = new CalculatorGame();
        games[calc.getGameNumber()] = calc;
        Game gcd = new GCDGame();
        games[gcd.getGameNumber()] = gcd;
        Game progerssion = new ProgressionGame();
        games[progerssion.getGameNumber()] = progerssion;
//        games[5] = new PrimeGame();
        games[exit.getGameNumber()] = exit;

    }
}

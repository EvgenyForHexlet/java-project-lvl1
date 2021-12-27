package hexlet.code.games;

import hexlet.code.games.impl.CalculatorGame;
import hexlet.code.games.impl.EvenGame;
import hexlet.code.common.SharedMemory;
import hexlet.code.errors.Error;
import hexlet.code.games.impl.Exit;
import hexlet.code.games.impl.GCDGame;
import hexlet.code.games.impl.PrimeGame;
import hexlet.code.games.impl.ProgressionGame;
import hexlet.code.io.Cli;
import hexlet.code.games.impl.GreetGame;

public class Start {

    private static final int TRIES = 3;
    private static final int NUMBER_OF_ALL_GAMES = 7;


    /**
     * default constructor.
     */
    public Start() {

        SharedMemory.setTries(TRIES);
    }

    /**
     * Starts the game.
     */
    public void play() {

        Cli.printLine("Please enter the game number and press Enter.");
        Cli.printLines(generateGameLines());
        Integer number = Cli.askForInt("Your choice: ");

        findGameByNumber(number);
    }

    private String[] generateGameLines() {

        String[] lines = new String[NUMBER_OF_ALL_GAMES];
        lines[GreetGame.getGameNumber() - 1] = GreetGame.getGameNumber() + " - " + GreetGame.getName();
        lines[EvenGame.getGameNumber() - 1] = EvenGame.getGameNumber() + " - " + EvenGame.getName();
        lines[CalculatorGame.getGameNumber() - 1] = CalculatorGame.getGameNumber() + " - " + CalculatorGame.getName();
        lines[GCDGame.getGameNumber() - 1] = GCDGame.getGameNumber() + " - " + GCDGame.getName();
        lines[ProgressionGame.getGameNumber() - 1]
                = ProgressionGame.getGameNumber() + " - " + ProgressionGame.getName();
        lines[PrimeGame.getGameNumber() - 1] = PrimeGame.getGameNumber() + " - " + PrimeGame.getName();
        lines[NUMBER_OF_ALL_GAMES - 1] = Exit.getGameNumber() + " - " + Exit.getName();
        return lines;
    }

    private void findGameByNumber(Integer number) {
        if (number == 0) {
            Exit.play();
            return;
        }
        if (number <= NUMBER_OF_ALL_GAMES) {
            Error.play();
            return;
        }
        GreetGame.play();

        if (number == EvenGame.getGameNumber()) {
            EvenGame.play();
        } else if (number == CalculatorGame.getGameNumber()) {
            CalculatorGame.play();
        } else if (number == GCDGame.getGameNumber()) {
            GCDGame.play();
        } else if (number == ProgressionGame.getGameNumber()) {
            ProgressionGame.play();
        } else if (number == PrimeGame.getGameNumber()) {
            PrimeGame.play();
        }
    }

}

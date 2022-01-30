package hexlet.code;

import hexlet.code.games.CalculatorGame;
import hexlet.code.games.EvenGame;
import hexlet.code.games.GCDGame;
import hexlet.code.games.PrimeGame;
import hexlet.code.games.ProgressionGame;
import hexlet.code.io.Cli;

public class App {

    private static final int GAME_HI = 1;
    private static final int GAME_EVEN = 2;
    private static final int GAME_CALC = 3;
    private static final int GAME_GCD = 4;
    private static final int GAME_PROG = 5;
    private static final int GAME_PRIME = 6;

    public static void main(String[] args) {
        play();
    }

    private static void play() {

        Cli.printLine("Please enter the game number and press Enter.");
        printMenuWithGames();
        Integer number = Cli.askForInt("Your choice: ");

        findGameByNumberAndStartIt(number);
    }

    private static void printMenuWithGames() {

        Cli.printLine(GAME_HI + " - " + "Greet");
        Cli.printLine(GAME_EVEN + " - " + EvenGame.getName());
        Cli.printLine(GAME_CALC + " - " + CalculatorGame.getName());
        Cli.printLine(GAME_GCD + " - " + GCDGame.getName());
        Cli.printLine(GAME_PROG + " - " + ProgressionGame.getName());
        Cli.printLine(GAME_PRIME + " - " + PrimeGame.getName());
        Cli.printLine("0 - Exit");

    }

    private static void findGameByNumberAndStartIt(Integer number) {

        switch (number) {
            case 0:
                Cli.printLine("Good bye");
                break;
            case GAME_HI:
                GameEngine.greetingBlock();
                break;
            case GAME_EVEN:
                EvenGame.play();
                break;
            case GAME_CALC:
                CalculatorGame.play();
                break;
            case GAME_GCD:
                GCDGame.play();
                break;
            case GAME_PROG:
                ProgressionGame.play();
                break;
            case GAME_PRIME:
                PrimeGame.play();
                break;
            default:
                Cli.printError("The input was wrong. Please start the game again.");

        }
    }
}

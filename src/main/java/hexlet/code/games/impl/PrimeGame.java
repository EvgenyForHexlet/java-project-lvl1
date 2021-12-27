package hexlet.code.games.impl;

import hexlet.code.common.SharedMemory;
import hexlet.code.io.Cli;

import static hexlet.code.common.MyMath.getRandomNumber;
import static hexlet.code.common.MyMath.isPrime;
import static hexlet.code.games.impl.Common.askYesOrNo;
import static hexlet.code.games.impl.Common.assertAnswer;

public class PrimeGame {

    private static final int GAME_NUMBER = 6;

    /**
     * game number.
     *
     * @return game number.
     */
    public static int getGameNumber() {
        return GAME_NUMBER;
    }

    /**
     * game name.
     *
     * @return game name.
     */
    public static String getName() {
        return "Prime";
    }

    /**
     * starts the game.
     */
    public static void play() {
        int counter = 0;
        Cli.printLine("Answer 'yes' if given number is prime. Otherwise answer 'no'");
        while (counter < SharedMemory.getTries()) {
            // to avoid value 1
            int number = getRandomNumber() + 1;
            Cli.printLine("Question: " + number);
            String answer = askYesOrNo();
            String rightAnswer = isPrime(number) ? "yes" : "no";

            if (!assertAnswer(rightAnswer, answer)) {
                break;
            }

            counter++;
        }
        if (counter == SharedMemory.getTries()) {
            Cli.printLine(Common.sayCongrats());
        }
    }

}

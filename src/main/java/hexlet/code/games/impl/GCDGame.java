package hexlet.code.games.impl;


import hexlet.code.common.SharedMemory;
import hexlet.code.io.Cli;

import static hexlet.code.common.MyMath.gcdByEuclidsAlgorithm;
import static hexlet.code.common.MyMath.getRandomNumber;

public class GCDGame {

    private static final int GAME_NUMBER = 4;

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
        return "GCD";
    }

    /**
     * starts the game.
     */
    public static void play() {
        int counter = 0;
        Cli.printLine("What is the greatest common divisor of two integers?");
        while (counter < SharedMemory.getTries()) {
            int number1 = getRandomNumber();
            int number2 = getRandomNumber();

            Cli.printLine("Question: " + number1 + " " + number2);
            Integer answer = Common.askForAnswer();
            Integer rightAnswer = gcdByEuclidsAlgorithm(number1, number2);

            if (!Common.assertAnswer(rightAnswer, answer)) {
                break;
            }
            counter++;
        }
        if (counter == SharedMemory.getTries()) {
            Cli.printLine(Common.sayCongrats());
        }
    }
}

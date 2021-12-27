package hexlet.code.games.impl;


import hexlet.code.common.SharedMemory;
import hexlet.code.io.Cli;

import static hexlet.code.common.MyMath.getRandomNumber;
import static hexlet.code.common.MyMath.processArithmeticOperation;
import static hexlet.code.common.MyMath.randomArithmeticOperation;

public class CalculatorGame extends Common {

    private static final int GAME_NUMBER = 3;

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
        return "Calc";
    }

    /**
     * starts the game.
     */
    public static void play() {
        int counter = 0;
        Cli.printLine("What is the result of he expression?");
        while (counter < SharedMemory.getTries()) {
            int number1 = getRandomNumber();
            int number2 = getRandomNumber();
            String op = randomArithmeticOperation();
            Cli.printLine("Question: " + number1 + " " + op + " " + number2);
            Integer answer = askForAnswer();
            Integer rightAnswer = processArithmeticOperation(number1, number2, op);

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

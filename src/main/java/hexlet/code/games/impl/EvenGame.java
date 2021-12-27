package hexlet.code.games.impl;


import hexlet.code.common.SharedMemory;
import hexlet.code.io.Cli;

import static hexlet.code.common.MyMath.getRandomNumber;
import static hexlet.code.common.MyMath.isEven;

public class EvenGame extends Common {

    private static final int GAME_NUMBER = 2;

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
        return "Even";
    }

    /**
     * starts the game.
     */
    public static void play() {
        int counter = 0;
        Cli.printLine("Answer 'yes' if number even otherwise answer 'no'");
        while (counter < SharedMemory.getTries()) {
            int number = getRandomNumber();
            Cli.printLine("Question: " + number);
            String answer = askYesOrNo();
            String rightAnswer = isEven(number) ? "yes" : "no";

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

package hexlet.code.games.impl;

import hexlet.code.common.SharedMemory;
import hexlet.code.io.Cli;

import static hexlet.code.common.MyMath.getRandomNumber;
import static hexlet.code.common.MyMath.randomProgression;

public class ProgressionGame extends Common {


    private static final int GAME_NUMBER = 5;

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
        return "Progression";
    }

    /**
     * starts the game.
     */
    public static void play() {
        int counter = 0;
        Cli.printLine("What is the result of he expression?");
        while (counter < SharedMemory.getTries()) {
            int[] progression = randomProgression();
            int indexOfMissingNumber = getRandomNumber(progression.length);
            Cli.printLine("Question: " + progressionAsString(progression, indexOfMissingNumber));
            Integer answer = askForAnswer();
            Integer rightAnswer = progression[indexOfMissingNumber];

            if (!assertAnswer(rightAnswer, answer)) {
                break;
            }

            counter++;
        }
        if (counter == SharedMemory.getTries()) {
            Cli.printLine(Common.sayCongrats());
        }
    }

    private static String progressionAsString(int[] progression, int indexOfMissingNumber) {
        String result = "";
        for (int i = 0; i < progression.length; i++) {
            if (i == indexOfMissingNumber) {
                result += ".. ";
            } else {
                result += progression[i] + " ";
            }
        }
        return result;
    }
}

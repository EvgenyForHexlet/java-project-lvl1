package hexlet.code.games;

import hexlet.code.GameEngine;

import java.util.Random;

import static hexlet.code.common.MyMath.getRandomNumber;

public class ProgressionGame {

    private static final int ARRAY_LENGTH = 8;
    private static final int RANDOM_STEP_BOUNBD = 8;
    private static final int RANDOM_START_POINT_BOUND = 10;

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

        String rule = "What is the result of he expression?";
        generateQuestionsAndAnswers(GameEngine.ROUND_LIST);
        GameEngine.play(rule);
    }

    private static void generateQuestionsAndAnswers(String[][] rounds) {
        for (int i = 0; i < rounds.length; i++) {
            int[] progression = new int[ARRAY_LENGTH];
            int step = new Random().nextInt(RANDOM_STEP_BOUNBD) + 1;
            progression[0] = new Random().nextInt(RANDOM_START_POINT_BOUND);
            fillProgressionArray(progression, step);
            int indexOfMissingNumber = getRandomNumber(progression.length);
            rounds[i][0] = progressionAsString(progression, indexOfMissingNumber);
            rounds[i][1] = "" + progression[indexOfMissingNumber];
        }
    }

    private static void fillProgressionArray(int[] progressionArray, int step) {
        for (int i = 1; i < progressionArray.length; i++) {
            progressionArray[i] = progressionArray[i - 1] + step;
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

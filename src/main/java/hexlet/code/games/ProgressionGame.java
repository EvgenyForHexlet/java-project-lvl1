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
     *
     * @param rounds
     */
    public static void play(String[][] rounds) {

        String rule = "What is the result of he expression?";
        generateQuestionsAndAnswers(rounds);
        GameEngine.play(rule, rounds);
    }

    private static void generateQuestionsAndAnswers(String[][] rounds) {
        for (int i = 0; i < rounds.length; i++) {
            int[] progression = randomProgression();
            int indexOfMissingNumber = getRandomNumber(progression.length);
            rounds[i][0] = progressionAsString(progression, indexOfMissingNumber);
            rounds[i][1] = "" + progression[indexOfMissingNumber];
        }
    }

    private static int[] randomProgression() {
        int[] result = new int[ARRAY_LENGTH];
        int step = new Random().nextInt(RANDOM_STEP_BOUNBD) + 1;
        result[0] = new Random().nextInt(RANDOM_START_POINT_BOUND);

        for (int i = 1; i < result.length; i++) {
            result[i] = result[i - 1] + step;
        }
        return result;
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

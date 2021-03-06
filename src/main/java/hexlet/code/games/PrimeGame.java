package hexlet.code.games;

import hexlet.code.GameEngine;

import static hexlet.code.common.MyMath.getRandomNumber;

public class PrimeGame {

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
        String rule = "Answer 'yes' if given number is prime. Otherwise answer 'no'";
        generateQuestionsAndAnswers(GameEngine.ROUND_LIST);
        GameEngine.play(rule);
    }

    private static void generateQuestionsAndAnswers(String[][] rounds) {
        for (int i = 0; i < rounds.length; i++) {
            // to avoid value 1
            int number = getRandomNumber() + 1;
            rounds[i][0] = "" + number;
            rounds[i][1] = isPrime(number) ? "yes" : "no";
        }
    }

    private static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}

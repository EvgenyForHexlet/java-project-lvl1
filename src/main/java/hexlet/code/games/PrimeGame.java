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
     *
     * @param rounds
     */
    public static void play(String[][] rounds) {
        String rule = "Answer 'yes' if given number is prime. Otherwise answer 'no'";
        generateQuestionsAndAnswers(rounds);
        GameEngine.play(rule, rounds);
    }

    private static void generateQuestionsAndAnswers(String[][] rounds) {
        for (int i = 0; i < rounds.length; i++) {
            // to avoid value 1
            int number = getRandomNumber() + 1;
            rounds[i][0] = "" + getRandomNumber() + 1;
            rounds[i][1] = isPrime(number) ? "yes" : "no";
        }
    }

    private static boolean isPrime(int number) {
        if (number < 1) {
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

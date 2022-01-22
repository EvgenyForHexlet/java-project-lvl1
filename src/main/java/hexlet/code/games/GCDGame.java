package hexlet.code.games;


import hexlet.code.GameEngine;

import static hexlet.code.common.MyMath.getRandomNumber;

public class GCDGame {

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
        String rule = "What is the greatest common divisor of two integers?";
        generateQuestionsAndAnswers(GameEngine.ROUND_LIST);
        GameEngine.play(rule);

    }

    private static void generateQuestionsAndAnswers(String[][] rounds) {
        for (int i = 0; i < rounds.length; i++) {
            int number1 = getRandomNumber();
            int number2 = getRandomNumber();
            rounds[i][0] = number1 + " " + number2;
            rounds[i][1] = "" + gcdByEuclidsAlgorithm(number1, number2);
        }
    }

    private static int gcdByEuclidsAlgorithm(int number1, int number2) {
        if (number2 == 0) {
            return number1;
        }
        return gcdByEuclidsAlgorithm(number2, number1 % number2);
    }
}

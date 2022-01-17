package hexlet.code.games;


import hexlet.code.GameEngine;

import static hexlet.code.common.MyMath.getRandomNumber;

public class EvenGame {

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
     *
     * @param rounds game rounds
     */
    public static void play(String[][] rounds) {
        String rule = "Answer 'yes' if number even otherwise answer 'no'";
        generateQuestionsAndAnswers(rounds);
        GameEngine.play(rule, rounds);
    }

    private static void generateQuestionsAndAnswers(String[][] rounds) {
        for (int i = 0; i < rounds.length; i++) {
            int number = getRandomNumber();
            rounds[i][0] = "" + number;
            rounds[i][1] = number % 2 == 0 ? "yes" : "no";
        }
    }
}

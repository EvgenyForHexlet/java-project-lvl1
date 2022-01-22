package hexlet.code.games;


import hexlet.code.GameEngine;

import java.util.Random;

import static hexlet.code.common.MyMath.getRandomNumber;

public class CalculatorGame {

    private static final String[] OPERATIONS = {"+", "-", "*"};

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
     *
     */
    public static void play() {
        String rule = "What is the result of he expression?";
        generateQuestionsAndAnswers(GameEngine.ROUND_LIST);
        GameEngine.play(rule);
    }

    private static void generateQuestionsAndAnswers(String[][] rounds) {
        for (int i = 0; i < rounds.length; i++) {
            String[] result = new String[2];
            int number1 = getRandomNumber();
            int number2 = getRandomNumber();
            String op = randomArithmeticOperation();
            rounds[i][0] = number1 + " " + op + " " + number2;
            rounds[i][1] = processArithmeticOperation(number1, number2, op);
        }

    }

    private static String processArithmeticOperation(int number1, int number2, String op) {
        switch (op) {
            case "+":
                return "" + (number1 + number2);
            case "-":
                return "" + (number1 - number2);
            case "*":
                return "" + (number1 * number2);
            default:
                throw new ArithmeticException("Operation not supported");
        }
    }

    private static String randomArithmeticOperation() {
        return OPERATIONS[new Random().nextInt(OPERATIONS.length)];
    }

}

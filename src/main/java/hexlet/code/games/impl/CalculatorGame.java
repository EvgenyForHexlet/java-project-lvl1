package hexlet.code.games.impl;


import static hexlet.code.common.MyMath.getRandomNumber;
import static hexlet.code.common.MyMath.processArithmeticOperation;
import static hexlet.code.common.MyMath.randomArithmeticOperation;

public class CalculatorGame extends AbstractGame<Integer> {

    private static final int GAME_NUMBER = 3;

    /**
     * game number.
     *
     * @return game number.
     */
    public int getGameNumber() {
        return GAME_NUMBER;
    }

    /**
     * game name.
     *
     * @return game name.
     */
    public String getName() {
        return "Calc";
    }

    /**
     * starts the game.
     */
    public void play() {
        int counter = 0;
        getCli().printLine("What is the result of he expression?");
        while (counter < getSharedMemory().getTries()) {
            int number1 = getRandomNumber();
            int number2 = getRandomNumber();
            String op = randomArithmeticOperation();
            getCli().printLine("Question: " + number1 + " " + op + " " + number2);
            Integer answer = askForAnswer();
            Integer rightAnswer = processArithmeticOperation(number1, number2, op);

            if (!assertAnswer(rightAnswer, answer)) {
                break;
            }

            counter++;
        }
        if (counter == getSharedMemory().getTries()) {
            getCli().printLine(getSharedMemory().sayCongrats());
        }
    }

}

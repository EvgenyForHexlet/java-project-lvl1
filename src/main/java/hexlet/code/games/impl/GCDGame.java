package hexlet.code.games.impl;


import static hexlet.code.common.MyMath.gcdByEuclidsAlgorithm;
import static hexlet.code.common.MyMath.getRandomNumber;

public class GCDGame extends AbstractGame<Integer> {

    private static final int GAME_NUMBER = 4;
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
     * @return game name.
     */
    public String getName() {
        return "GCD";
    }

    /**
     * starts the game.
     */
    public void play() {
        int counter = 0;
        getCli().printLine("What is the greatest common divisor of two integers?");
        while (counter < getSharedMemory().getTries()) {
            int number1 = getRandomNumber();
            int number2 = getRandomNumber();

            getCli().printLine("Question: " + number1 + " and " + number2);
            Integer answer = askForAnswer();
            Integer rightAnswer = gcdByEuclidsAlgorithm(number1, number2);

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

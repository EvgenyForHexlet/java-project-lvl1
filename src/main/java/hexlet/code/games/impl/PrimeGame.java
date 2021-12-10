package hexlet.code.games.impl;

import static hexlet.code.common.MyMath.getRandomNumber;
import static hexlet.code.common.MyMath.isPrime;

public class PrimeGame extends AbstractGame<String> {

    private static final int GAME_NUMBER = 6;

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
        return "Prime";
    }

    /**
     * starts the game.
     */
    public void play() {
        int counter = 0;
        getCli().printLine("Answer 'yes' if given number is prime. Otherwise answer 'no'");
        while (counter < getSharedMemory().getTries()) {
            // to avoid value 1
            int number = getRandomNumber() + 1;
            getCli().printLine("Question: " + number);
            String answer = askYesOrNo();
            String rightAnswer = isPrime(number) ? "yes" : "no";

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

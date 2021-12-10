package hexlet.code.games.impl;

import static hexlet.code.common.MyMath.getRandomNumber;
import static hexlet.code.common.MyMath.randomProgression;

public class ProgressionGame extends AbstractGame<Integer> {


    private static final int GAME_NUMBER = 5;

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
        return "Progression";
    }

    /**
     * starts the game.
     */
    public void play() {
        int counter = 0;
        getCli().printLine("What is the result of he expression?");
        while (counter < getSharedMemory().getTries()) {
            int[] progression = randomProgression();
            int indexOfMissingNumber = getRandomNumber(progression.length);
            getCli().printLine("Question: " + progressionAsString(progression, indexOfMissingNumber));
            Integer answer = askForAnswer();
            Integer rightAnswer = progression[indexOfMissingNumber];

            if (!assertAnswer(rightAnswer, answer)) {
                break;
            }

            counter++;
        }
        if (counter == getSharedMemory().getTries()) {
            getCli().printLine(getSharedMemory().sayCongrats());
        }
    }

    private String progressionAsString(int[] progression, int indexOfMissingNumber) {
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

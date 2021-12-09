package hexlet.code.games.impl;


import static hexlet.code.common.MyMath.getRandomNumber;
import static hexlet.code.common.MyMath.isEven;

public class EvenGame extends AbstractGame<String> {

    /**
     * game number.
     * @return game number.
     */
    public int getGameNumber() {
        return 2;
    }

    /**
     * game name.
     * @return game name.
     */
    public String getName() {
        return "Even";
    }

    /**
     * starts the game.
     */
    public void play() {
        int counter = 0;
        getCli().printLine("Answer 'yes' if number even otherwise answer 'no'");
        while (counter < getSharedMemory().getTries()) {
            int number = getRandomNumber();
            getCli().printLine("Question: " + number);
            String answer = askYesOrNo();
            String rightAnswer = isEven(number) ? "yes" : "no";

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

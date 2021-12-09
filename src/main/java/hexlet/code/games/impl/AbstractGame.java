package hexlet.code.games.impl;

import hexlet.code.io.Cli;
import hexlet.code.common.SharedMemory;
import hexlet.code.games.Game;


public abstract class AbstractGame<T> implements Game {

    private final SharedMemory sharedMemory = SharedMemory.getSharedMemory();
    private final Cli cli = Cli.getIOManager();

    /**
     * Asks for a number.
     * @return number
     */
    protected Integer askForAnswer() {
        Integer result = null;
        while (result == null) {
            result = cli.askForInt("Your answer: ");
        }
        return result;
    }

    /**
     * Compares the both answers right answer and answer from user respectively.
     * @param rightAnswer
     * @param userAnswer
     * @return true if equal, otherwise false
     */
    protected final boolean assertAnswer(T rightAnswer, T userAnswer) {

        if (rightAnswer.equals(userAnswer)) {
            cli.printLine("Correct!");
            return true;
        }
        cli.printLine(userAnswer + " is wrong answer ;(. Correct answer was " + rightAnswer);
        return false;

    }

    /**
     * This helper method asks user for 'yes' or 'now' answer.
     * Due the answer doesn't match the question will be asked again.
     *
     * @return true if 'yes', false if 'no'
     */
    protected final String askYesOrNo() {
        String result = cli.askForString("Your answer: ");
        return result.toLowerCase();

    }

    /**
     * getter for SM.
     * @return SharedMemory
     */
    public SharedMemory getSharedMemory() {
        return sharedMemory;
    }

    /**
     * getter for CLI.
     * @return Cli
     */
    public Cli getCli() {
        return cli;
    }

}

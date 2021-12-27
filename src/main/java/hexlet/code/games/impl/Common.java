package hexlet.code.games.impl;

import hexlet.code.common.SharedMemory;
import hexlet.code.io.Cli;


public class Common {

    /**
     * Asks for a number.
     * @return number
     */
    public static Integer askForAnswer() {
        Integer result = null;
        while (result == null) {
            result = Cli.askForInt("Your answer: ");
        }
        return result;
    }

    /**
     * Compares the both answers right answer and answer from user respectively.
     * @param rightAnswer right answer
     * @param userAnswer user answer
     * @return true if equal, otherwise false
     */
    public static boolean assertAnswer(Object rightAnswer, Object userAnswer) {

        if (rightAnswer.equals(userAnswer)) {
            Cli.printLine("Correct!");
            return true;
        }
        Cli.printLine("'" + userAnswer + "' is wrong answer ;(. Correct answer was '" + rightAnswer + "'");
        Cli.printLine(sayLetsPlayAgain());
        return false;

    }

    /**
     * This helper method asks user for 'yes' or 'now' answer.
     * Due the answer doesn't match the question will be asked again.
     *
     * @return true if 'yes', false if 'no'
     */
    public static String askYesOrNo() {
        String result = Cli.askForString("Your answer: ");
        return result.toLowerCase();

    }

    public static String sayLetsPlayAgain() {
        return "Let's try again, " + SharedMemory.getUser() + "!";
    }

    public static String sayCongrats() {
        return "Congratulations, " + SharedMemory.getUser() + "!";
    }

}

package hexlet.code;

import hexlet.code.common.SharedMemory;
import hexlet.code.io.Cli;


public class GameEngine {

    private static final int TRIES = 3;
    private static String user;


    public static void play(String rule, String[][] questionAndRightAnswer) {
        greeting();
        if (rule != "") {
            Cli.printLine(rule);
            int counter = 1;
            for (String[] round : questionAndRightAnswer) {
                Cli.printLine("Question: " + round[0]);
                String answer = Cli.askForString("Your answer: ");
                if (round[1].equals(answer)) {
                    Cli.printLine("Correct!");
                } else {
                    Cli.printLine("'" + answer + "' is wrong answer ;(. Correct answer was '" + round[1] + "'");
                    Cli.printLine(sayLetsPlayAgain());
                    break;
                }
                counter++;
            }
            if (counter == TRIES) {
                Cli.printLine(GameEngine.sayCongrats());
            }
        }
    }


    private static void greeting() {
        Cli.printLine("Welcome to the Brain Games!");
        user = Cli.askForString("May I have your name? ");
        Cli.printLine("Hello, " + user + "!");
    }

    private static String sayLetsPlayAgain() {
        return "Let's try again, " + SharedMemory.getUser() + "!";
    }

    private static String sayCongrats() {
        return "Congratulations, " + SharedMemory.getUser() + "!";
    }

}

package hexlet.code;

import hexlet.code.io.Cli;


public class GameEngine {

    private static String user;

    public static void play(String rule, String[][] questionAndRightAnswerArray) {
        greeting();
        Cli.printLine(rule);
        for (String[] round : questionAndRightAnswerArray) {
            Cli.printLine("Question: " + round[0]);
            String answer = Cli.askForString("Your answer: ");
            if (round[1].equals(answer)) {
                Cli.printLine("Correct!");
            } else {
                Cli.printLine("'" + answer + "' is wrong answer ;(. Correct answer was '" + round[1] + "'");
                Cli.printLine(sayLetsPlayAgain());
                return;
            }
        }
        Cli.printLine(GameEngine.sayCongrats());
    }

    public static void greeting() {
        Cli.printLine("Welcome to the Brain Games!");
        user = Cli.askForString("May I have your name? ");
        Cli.printLine("Hello, " + user + "!");
    }

    private static String sayLetsPlayAgain() {
        return "Let's try again, " + user + "!";
    }

    private static String sayCongrats() {
        return "Congratulations, " + user + "!";
    }

}

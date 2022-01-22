package hexlet.code;

import hexlet.code.io.Cli;


public class GameEngine {

    private static final int ROUNDS = 3;

    public static final String[][] ROUND_LIST = new String[ROUNDS][2];

    public static void play(String rule) {
        String user = greeting();
        Cli.printLine(rule);
        for (String[] round : ROUND_LIST) {
            Cli.printLine("Question: " + round[0]);
            String answer = Cli.askForString("Your answer: ");
            if (round[1].equals(answer)) {
                Cli.printLine("Correct!");
            } else {
                Cli.printLine("'" + answer + "' is wrong answer ;(. Correct answer was '" + round[1] + "'");
                Cli.printLine(sayLetsPlayAgain(user));
                return;
            }
        }
        Cli.printLine(GameEngine.sayCongrats(user));
    }

    public static String greeting() {
        Cli.printLine("Welcome to the Brain Games!");
        String user = Cli.askForString("May I have your name? ");
        Cli.printLine("Hello, " + user + "!");
        return user;
    }

    private static String sayLetsPlayAgain(String user) {
        return "Let's try again, " + user + "!";
    }

    private static String sayCongrats(String user) {
        return "Congratulations, " + user + "!";
    }

}

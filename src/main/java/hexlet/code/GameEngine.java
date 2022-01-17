package hexlet.code;

import hexlet.code.io.Cli;


public class GameEngine {

    private static String user;


    public static void play(String rule, String[][] questionAndRightAnswer) {
        greeting();
        if (rule != "") {
            Cli.printLine(rule);
            int counter = 0;
            for (String[] round : questionAndRightAnswer) {
                Cli.printLine("Question: " + round[0]);
                String answer = Cli.askForString("Your answer: ");
                if (round[1].equals(answer)) {
                    Cli.printLine("Correct!");
                    counter++;
                } else {
                    Cli.printLine("'" + answer + "' is wrong answer ;(. Correct answer was '" + round[1] + "'");
                    Cli.printLine(sayLetsPlayAgain());
                    break;
                }
            }
            if (counter == questionAndRightAnswer.length) {
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
        return "Let's try again, " + user + "!";
    }

    private static String sayCongrats() {
        return "Congratulations, " + user + "!";
    }

}

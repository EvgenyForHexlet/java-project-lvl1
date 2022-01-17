package hexlet.code.common;

import java.util.Random;

public class MyMath {

    private static final int BOUND = 100;

    public static int getRandomNumber() {
        return new Random().nextInt(BOUND);
    }

    public static int getRandomNumber(int bound) {
        return new Random().nextInt(bound);
    }




}

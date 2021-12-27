package hexlet.code.common;

public final class SharedMemory {

    private static String user;
    private static int tries;

    public static String getUser() {
        return user;
    }

    public static void setUser(String theUser) {
        SharedMemory.user = theUser;
    }

    public static int getTries() {
        return tries;
    }

    public static void setTries(int theTries) {
        SharedMemory.tries = theTries;
    }
}

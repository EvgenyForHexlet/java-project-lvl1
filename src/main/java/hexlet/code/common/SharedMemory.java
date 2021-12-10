package hexlet.code.common;

public final class SharedMemory {

    private static SharedMemory sharedMemory;
    private static String user;
    private static int tries;

    private SharedMemory() {
        user = "";
        tries = -1;
    }

    public static SharedMemory getSharedMemory() {
        if (sharedMemory == null) {
            sharedMemory = new SharedMemory();
        }
        return sharedMemory;
    }

    public String sayLetsPlayAgain() {
        return "Let's try again, " + user + "!";
    }

    public String sayCongrats() {
        return "Congratulations, " + user + "!";
    }

    public String getUser() {
        return user;
    }

    public int getTries() {
        return tries;
    }

    public void setUser(String theUser) {
        this.user = theUser;
    }

    public void setTries(int theTries) {
        this.tries = theTries;
    }
}

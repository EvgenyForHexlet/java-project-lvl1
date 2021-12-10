package hexlet.code.common;

public final class SharedMemory {

    private static SharedMemory sharedMemory;
    private String user;
    private int tries;

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
        return "Let's try again, " + user;
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

    public void setUser(String user) {
        this.user = user;
    }

    public void setTries(int tries) {
        this.tries = tries;
    }
}
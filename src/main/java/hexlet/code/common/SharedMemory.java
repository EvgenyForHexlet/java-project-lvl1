package hexlet.code.common;

public final class SharedMemory {

    private static String user;


    public static String getUser() {
        return user;
    }

    public static void setUser(String theUser) {
        SharedMemory.user = theUser;
    }

}

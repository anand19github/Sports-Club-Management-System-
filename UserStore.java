
// UserStore.java
import java.util.HashMap;

public class UserStore {
    private static HashMap<String, String> userDatabase = new HashMap<>();

    // Pre-added dummy users
    static {
        userDatabase.put("user1", "user123");
        userDatabase.put("player", "pass123");
    }

    public static boolean isUserValid(String username, String password) {
        return userDatabase.containsKey(username) && userDatabase.get(username).equals(password);
    }

    public static void addUser(String username, String password) {
        userDatabase.put(username, password);
    }
}

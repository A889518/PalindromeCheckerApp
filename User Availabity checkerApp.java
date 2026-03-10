import java.util.*;

class UsernameChecker {

    // Store username -> userId
    HashMap<String, Integer> users = new HashMap<>();

    // Store username -> attempt count
    HashMap<String, Integer> attempts = new HashMap<>();

    int userIdCounter = 1;

    // Check availability
    public boolean checkAvailability(String username) {

        // Update attempt count
        attempts.put(username, attempts.getOrDefault(username, 0) + 1);

        if (users.containsKey(username)) {
            return false;
        }
        return true;
    }

    // Register user
    public void registerUser(String username) {
        if (!users.containsKey(username)) {
            users.put(username, userIdCounter++);
            System.out.println(username + " registered successfully.");
        } else {
            System.out.println("Username already taken.");
        }
    }

    // Suggest alternative usernames
    public List<String> suggestAlternatives(String username) {

        List<String> suggestions = new ArrayList<>();

        suggestions.add(username + "1");
        suggestions.add(username + "2");
        suggestions.add(username.replace("_", "."));

        return suggestions;
    }

    // Get most attempted username
    public String getMostAttempted() {

        String maxUser = "";
        int max = 0;

        for (String key : attempts.keySet()) {

            if (attempts.get(key) > max) {
                max = attempts.get(key);
                maxUser = key;
            }
        }

        return maxUser + " (" + max + " attempts)";
    }
}

public class Main {

    public static void main(String[] args) {

        UsernameChecker system = new UsernameChecker();

        // Pre-existing users
        system.registerUser("john_doe");
        system.registerUser("admin");

        // Availability checks
        System.out.println("checkAvailability(\"john_doe\") → "
                + system.checkAvailability("john_doe"));

        System.out.println("checkAvailability(\"jane_smith\") → "
                + system.checkAvailability("jane_smith"));

        // Suggestions
        System.out.println("suggestAlternatives(\"john_doe\") → "
                + system.suggestAlternatives("john_doe"));

        // Simulate attempts
        for (int i = 0; i < 5; i++) system.checkAvailability("admin");
        for (int i = 0; i < 3; i++) system.checkAvailability("john_doe");

        // Most attempted username
        System.out.println("getMostAttempted() → "
                + system.getMostAttempted());
    }
}

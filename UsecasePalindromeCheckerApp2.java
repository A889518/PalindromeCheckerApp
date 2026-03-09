/**
 * UC3: Palindrome Check Using String Reverse (Loop)
 */

public class UseCase3PalindromeCheckerApp {

    public static void main(String[] args) {

        String input = "level";
        String reversed = "";

        // Reverse using loop
        for (int i = input.length() - 1; i >= 0; i--) {
            reversed = reversed + input.charAt(i);
        }

        // Compare
        if (input.equals(reversed)) {
            System.out.println("The given string is a Palindrome");
        } else {
            System.out.println("The given string is NOT a Palindrome");
        }
    }
}

interface PalindromeStrategy {
    boolean isPalindrome(String input);
}

// Strategy 1: Two Pointer Method
class TwoPointerStrategy implements PalindromeStrategy {

    public boolean isPalindrome(String input) {
        int left = 0;
        int right = input.length() - 1;

        while (left < right) {
            if (input.charAt(left) != input.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}

// Strategy 2: Reverse String Method
class ReverseStringStrategy implements PalindromeStrategy {

    public boolean isPalindrome(String input) {
        String reversed = new StringBuilder(input).reverse().toString();
        return input.equals(reversed);
    }
}

public class UseCasePalindromeCheckerApp {

    public static void main(String[] args) {

        String input = "level";

        // Choose strategy
        PalindromeStrategy strategy = new TwoPointerStrategy();
        // PalindromeStrategy strategy = new ReverseStringStrategy();

        boolean result = strategy.isPalindrome(input);

        if (result) {
            System.out.println("The given string is a Palindrome (Strategy Pattern)");
        } else {
            System.out.println("The given string is NOT a Palindrome");
        }
    }
}

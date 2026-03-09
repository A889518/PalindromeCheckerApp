class PalindromeService {

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

public class UseCasePalindromeCheckerApp {

    public static void main(String[] args) {

        String input = "radar";

        PalindromeService service = new PalindromeService();
        boolean result = service.isPalindrome(input);

        if (result) {
            System.out.println("The given string is a Palindrome (OOP Design)");
        } else {
            System.out.println("The given string is NOT a Palindrome");
        }
    }
}

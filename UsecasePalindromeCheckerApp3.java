public class UseCasePalindromeCheckerApp {

    public static void main(String[] args) {

        String input = "radar";
        char[] characters = input.toCharArray();

        boolean isPalindrome = true;

        int left = 0;
        int right = characters.length - 1;

        while (left < right) {
            if (characters[left] != characters[right]) {
                isPalindrome = false;
                break;
            }
            left++;
            right--;
        }

        if (isPalindrome) {
            System.out.println("The given string is a Palindrome");
        } else {
            System.out.println("The given string is NOT a Palindrome");
        }
    }
}

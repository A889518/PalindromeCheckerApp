import java.util.LinkedList;

public class UseCasePalindromeCheckerApp {

    public static void main(String[] args) {

        String input = "madam";
        LinkedList<Character> list = new LinkedList<>();

        for (char ch : input.toCharArray()) {
            list.add(ch);
        }

        boolean isPalindrome = true;

        while (list.size() > 1) {
            if (!list.removeFirst().equals(list.removeLast())) {
                isPalindrome = false;
                break;
            }
        }

        if (isPalindrome) {
            System.out.println("The given string is a Palindrome");
        } else {
            System.out.println("The given string is NOT a Palindrome");
        }
    }
}

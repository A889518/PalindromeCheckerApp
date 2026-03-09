import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;

public class UseCasePalindromeCheckerApp {

    public static void main(String[] args) {

        String input = "level";

        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();

        for (char ch : input.toCharArray()) {
            stack.push(ch);
            queue.add(ch);
        }

        boolean isPalindrome = true;

        while (!stack.isEmpty()) {
            if (!stack.pop().equals(queue.remove())) {
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

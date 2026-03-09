public class UseCasePalindromeCheckerApp {

    public static boolean twoPointerMethod(String input) {
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

    public static boolean reverseMethod(String input) {
        String reversed = new StringBuilder(input).reverse().toString();
        return input.equals(reversed);
    }

    public static void main(String[] args) {

        String input = "A man a plan a canal Panama".replaceAll("\\s+", "").toLowerCase();

        long start1 = System.nanoTime();
        boolean result1 = twoPointerMethod(input);
        long end1 = System.nanoTime();

        long start2 = System.nanoTime();
        boolean result2 = reverseMethod(input);
        long end2 = System.nanoTime();

        System.out.println("Two Pointer Result: " + result1);
        System.out.println("Two Pointer Time: " + (end1 - start1) + " ns");

        System.out.println("Reverse Method Result: " + result2);
        System.out.println("Reverse Method Time: " + (end2 - start2) + " ns");
    }
}

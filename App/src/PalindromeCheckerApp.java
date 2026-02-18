import java.util.Stack;

public class  PalindromeCheckerApp {

    public static void main(String[] args) {

        // Declare and initialize the input string
        String input = "noon";

        // Create a Stack to store characters
        Stack<Character> stack = new Stack<>();

        // Push each character of the string into the stack
        for (char c : input.toCharArray()) {
            stack.push(c);
        }

        // Assume palindrome initially
        boolean isPalindrome = true;

        // Iterate again through original string and compare with stack pop
        for (char c : input.toCharArray()) {

            char popped = stack.pop();

            if (c != popped) {
                isPalindrome = false;
                break;
            }
        }

        // Print output as in document
        System.out.println("Input : " + input);
        System.out.println("Is Palindrome? : " + isPalindrome);
    }
}
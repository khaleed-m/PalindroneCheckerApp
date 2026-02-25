/**
 * =====================================================
 * MAIN CLASS – UseCase12PalindromeCheckerApp
 * =====================================================
 *
 * Use Case 12: Strategy Pattern for Palindrome Algorithms
 *
 * This class demonstrates how different palindrome
 * validation algorithms can be selected dynamically
 * at runtime using the Strategy Design Pattern.
 *
 * @author Developer
 * @version 12.0
 */

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        String input = "level";

        // 🔹 Choose Strategy (Change here to switch algorithm)
        PalindromeStrategy strategy = new StackStrategy();
        // PalindromeStrategy strategy = new DequeStrategy();

        boolean result = strategy.check(input);

        System.out.println("Input : " + input);
        System.out.println("Is Palindrome? : " + result);
    }
}


/**
 * =====================================================
 * INTERFACE – PalindromeStrategy
 * =====================================================
 *
 * Defines contract for all palindrome algorithms.
 */
interface PalindromeStrategy {
    boolean check(String input);
}


/**
 * =====================================================
 * CLASS – StackStrategy
 * =====================================================
 *
 * Uses Stack (LIFO) to validate palindrome.
 */
class StackStrategy implements PalindromeStrategy {

    @Override
    public boolean check(String input) {

        java.util.Stack<Character> stack = new java.util.Stack<>();

        // Push all characters
        for (char c : input.toCharArray()) {
            stack.push(c);
        }

        // Compare by popping
        for (char c : input.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }

        return true;
    }
}


/**
 * =====================================================
 * CLASS – DequeStrategy
 * =====================================================
 *
 * Uses Deque (double-ended queue) to validate palindrome.
 */
class DequeStrategy implements PalindromeStrategy {

    @Override
    public boolean check(String input) {

        java.util.Deque<Character> deque = new java.util.ArrayDeque<>();

        // Add characters
        for (char c : input.toCharArray()) {
            deque.addLast(c);
        }

        // Compare from both ends
        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) {
                return false;
            }
        }

        return true;
    }
}
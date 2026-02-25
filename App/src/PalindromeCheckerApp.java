/**
 * =====================================================
 * MAIN CLASS – UseCase13PalindromeCheckerApp
 * =====================================================
 *
 * Use Case 13: Performance Comparison
 *
 * Description:
 * This class measures and compares execution performance
 * of palindrome validation algorithms.
 *
 * At this stage, the application:
 * - Uses palindrome strategy implementations
 * - Captures execution start and end time
 * - Calculates total execution duration
 * - Displays benchmarking results
 *
 * @author Developer
 * @version 13.0
 */

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        String input = "level";

        // Test Stack Strategy
        PalindromeStrategy stackStrategy = new StackStrategy();
        long startTime = System.nanoTime();
        boolean stackResult = stackStrategy.check(input);
        long endTime = System.nanoTime();
        long stackDuration = endTime - startTime;

        // Test Deque Strategy
        PalindromeStrategy dequeStrategy = new DequeStrategy();
        startTime = System.nanoTime();
        boolean dequeResult = dequeStrategy.check(input);
        endTime = System.nanoTime();
        long dequeDuration = endTime - startTime;

        System.out.println("Input : " + input);

        System.out.println("\n--- Stack Strategy ---");
        System.out.println("Is Palindrome? : " + stackResult);
        System.out.println("Execution Time : " + stackDuration + " ns");

        System.out.println("\n--- Deque Strategy ---");
        System.out.println("Is Palindrome? : " + dequeResult);
        System.out.println("Execution Time : " + dequeDuration + " ns");
    }
}


/**
 * Strategy Interface
 */
interface PalindromeStrategy {
    boolean check(String input);
}


/**
 * Stack-based implementation
 */
class StackStrategy implements PalindromeStrategy {

    @Override
    public boolean check(String input) {

        java.util.Stack<Character> stack = new java.util.Stack<>();

        for (char c : input.toCharArray()) {
            stack.push(c);
        }

        for (char c : input.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }

        return true;
    }
}


/**
 * Deque-based implementation
 */
class DequeStrategy implements PalindromeStrategy {

    @Override
    public boolean check(String input) {

        java.util.Deque<Character> deque = new java.util.ArrayDeque<>();

        for (char c : input.toCharArray()) {
            deque.addLast(c);
        }

        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) {
                return false;
            }
        }

        return true;
    }
}
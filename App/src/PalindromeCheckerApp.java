/**
 * =====================================================
 * MAIN CLASS – UseCase8PalindromeCheckerApp
 * =====================================================
 *
 * Use Case 8: Linked List Based Palindrome Checker
 *
 * Description:
 * This class checks whether a string is a palindrome
 * using a Singly Linked List.
 *
 * Flow:
 * 1. Convert string to linked list
 * 2. Find middle using fast & slow pointer
 * 3. Reverse second half in-place
 * 4. Compare both halves
 *
 * @author Developer
 * @version 8.0
 */

public class PalindromeCheckerApp {

    // Node class (Singly Linked List)
    static class Node {
        char data;
        Node next;

        Node(char data) {
            this.data = data;
            this.next = null;
        }
    }

    // Method to check palindrome
    public static boolean isPalindrome(String input) {

        if (input == null || input.length() <= 1) {
            return true;
        }

        // Step 1: Convert string to linked list
        Node head = new Node(input.charAt(0));
        Node current = head;

        for (int i = 1; i < input.length(); i++) {
            current.next = new Node(input.charAt(i));
            current = current.next;
        }

        // Step 2: Find middle using fast & slow pointer
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 3: Reverse second half
        Node prev = null;
        Node nextNode;

        while (slow != null) {
            nextNode = slow.next;
            slow.next = prev;
            prev = slow;
            slow = nextNode;
        }

        // Step 4: Compare first half and reversed second half
        Node firstHalf = head;
        Node secondHalf = prev;

        while (secondHalf != null) {
            if (firstHalf.data != secondHalf.data) {
                return false;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        return true;
    }

    /**
     * Application entry point for UC8
     */
    public static void main(String[] args) {

        String input = "level";   // You can change this value

        boolean result = isPalindrome(input);

        System.out.println("Input : " + input);
        System.out.println("Is Palindrome? : " + result);
    }
}
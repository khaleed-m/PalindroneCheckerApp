public class UseCase3PalindromeCheckerApp {

    public static void main(String[] args) {

        String input = "madam";
        String reversed = "";

        // Iterate from the last character to the first
        for (int i = input.length() - 1; i >= 0; i--) {
            reversed = reversed + input.charAt(i);
        }

        System.out.println("Input text: " + input);
        System.out.println("Reversed text: " + reversed);

        // Compare original and reversed
        if (input.equals(reversed)) {
            System.out.println("Is it a Palindrome? : true");
        } else {
            System.out.println("Is it a Palindrome? : false");
        }
    }
}
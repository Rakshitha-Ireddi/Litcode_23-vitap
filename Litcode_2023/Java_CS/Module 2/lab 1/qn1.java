import java.util.HashSet;
import java.util.Scanner;

public class Main {

    public static int longestSubstringLength(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int maxLength = 0;
        int start = 0;
        HashSet<Character> charSet = new HashSet<>();

        for (int end = 0; end < s.length(); end++) {
            char currentChar = s.charAt(end);

            while (charSet.contains(currentChar)) {
                charSet.remove(s.charAt(start));
                start++;
            }

            charSet.add(currentChar);
            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take user input
        System.out.println("");
        String userInput = scanner.nextLine();

        // Calculate and display the result
        System.out.println(longestSubstringLength(userInput));

        // Close the scanner
        scanner.close();
    }
}
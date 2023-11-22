import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print(" ");
        String input = scanner.nextLine();

        analyzeAndPrint(input);
    }

    public static void analyzeAndPrint(String input) {

        int totalCharacters = input.length();
        int uppercaseCount = 0;
        int lowercaseCount = 0;
        int digitCount = 0;
        int otherCount = 0;

        for (int i = 0; i < totalCharacters; i++) {
            char character = input.charAt(i);
            if (Character.isUpperCase(character)) {
                uppercaseCount++;
            } else if (Character.isLowerCase(character)) {
                lowercaseCount++;
            } else if (Character.isDigit(character)) {
                digitCount++;
            } else {
                otherCount++;
            }
        }

        double uppercasePercentage = (double) uppercaseCount / totalCharacters * 100;
        double lowercasePercentage = (double) lowercaseCount / totalCharacters * 100;
        double digitPercentage = (double) digitCount / totalCharacters * 100;
        double otherPercentage = (double) otherCount / totalCharacters * 100;

        System.out.println(" ");
        System.out.printf("%.3f%%\n", uppercasePercentage);
        System.out.printf("%.3f%%\n", lowercasePercentage);
        System.out.printf("%.3f%%\n", digitPercentage);
        System.out.printf("%.3f%%\n", otherPercentage);
        System.out.println();
    }
}
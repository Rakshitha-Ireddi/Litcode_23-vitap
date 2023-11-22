import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static String getEgyptianFraction(int numerator, int denominator) {
        StringBuilder result = new StringBuilder();
        List<Integer> denominators = getEgyptianFractionUtil(numerator, denominator, new ArrayList<>());

        for (int denom : denominators) {
            result.append("1/").append(denom).append(" + ");
        }

        if (result.length() > 0) {
            result.setLength(result.length() - 3); // removing the last " + "
        }

        return result.toString();
    }

    public static List<Integer> getEgyptianFractionUtil(int numerator, int denominator, List<Integer> listOfDenoms) {
        if (numerator == 0) {
            return listOfDenoms;
        }

        int newDenom = (int) Math.ceil((double) denominator / numerator);
        // append to the list
        listOfDenoms.add(newDenom);
        listOfDenoms = getEgyptianFractionUtil(numerator * newDenom - denominator,
                newDenom * denominator, listOfDenoms);
        return listOfDenoms;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int d = scanner.nextInt();
        String result = getEgyptianFraction(n, d);
        String[] fractions = result.split(" \\+ ");

        for (String fraction : fractions) {
            int denom = Integer.parseInt(fraction.split("/")[1]);
            System.out.println(denom);
        }
    }
}
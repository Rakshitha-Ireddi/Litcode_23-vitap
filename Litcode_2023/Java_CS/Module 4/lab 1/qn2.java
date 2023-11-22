import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("");
        int n = scanner.nextInt();
        int[] array = new int[n + 1];
        System.out.println("");
        int queryCount = scanner.nextInt();
        for (int i = 0; i < queryCount; i++) {
            System.out.println("");
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            int value = scanner.nextInt();
            for (int j = start; j <= end; j++) {
                array[j] += value;
            }
        }
        int max = Integer.MIN_VALUE;
        for (int k = 1; k <= n; k++) {
            if (array[k] > max) {
                max = array[k];
            }
        }
        System.out.println(max);
    }
}
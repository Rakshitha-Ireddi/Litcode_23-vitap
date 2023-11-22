import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int num = input.nextInt();
        int k = input.nextInt();
        int sum = 0;
        int flag = 0;
        if (num == 0) {
            System.out.println(0);
        }

        else if (num > 0) {
            for (int i = 1; i * k <= num && i <= 10; ++i) {
                if (num % 10 == ((i * k) % 10)) {
                    System.out.println(i);
                    flag = 1;
                    break;
                }
            }
        }

        if (flag == 0) {
            System.out.println(-1);
        }
    }
}
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public int clumsy(int n) {
        char[] op = { '*', '/', '+', '-' };
        Stack<Integer> stack = new Stack<>();
        stack.push(n--);
        int i = 0;
        while (n > 0) {
            switch (op[i]) {
                case '*':
                    stack.push(stack.pop() * n--);
                    break;
                case '/':
                    stack.push(stack.pop() / n--);
                    break;
                case '+':
                    stack.push(n--);
                    break;
                case '-':
                    stack.push(-1 * n);
                    n--;
                    break;
            }
            i = (i + 1) % 4;
        }
        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Main mainInstance = new Main();
        System.out.print(" ");
        int userInput = scanner.nextInt();
        int result = mainInstance.clumsy(userInput);
        System.out.println(result);
        scanner.close();
    }
}
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(" ");
        String input = scanner.nextLine();
        String output = processQueueQueries(input);
        System.out.println(output);
    }

    private static String processQueueQueries(String input) {
        String[] queries = input.split(",");

        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        StringBuilder output = new StringBuilder();

        for (String query : queries) {
            String[] parts = query.split(" ");
            int type = Integer.parseInt(parts[0]);

            switch (type) {
                case 1:
                    int element = Integer.parseInt(parts[1]);
                    stack1.push(element);
                    break;
                case 2:
                    if (stack2.isEmpty()) {
                        while (!stack1.isEmpty()) {
                            stack2.push(stack1.pop());
                        }
                    }
                    if (!stack2.isEmpty()) {
                        stack2.pop();
                    }
                    break;
                case 3:
                    if (stack2.isEmpty()) {
                        while (!stack1.isEmpty()) {
                            stack2.push(stack1.pop());
                        }
                    }
                    if (!stack2.isEmpty()) {
                        output.append(stack2.peek()).append(" ");
                    }
                    break;
            }
        }

        return output.toString().trim();
    }
}
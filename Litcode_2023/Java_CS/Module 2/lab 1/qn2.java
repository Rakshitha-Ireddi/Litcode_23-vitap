import java.util.*;

public class Main {
    static String text = "";
    static Stack<String> previoustext = new Stack<>();
    static Stack<Integer> previousposition = new Stack<>();
    static int position = 0;

    static void insert(String s) {
        if (position == 0) {
            text = s;
        } else {
            previoustext.add(text);
            previousposition.add(position);

            text = text.substring(0, position) + s + text.substring(position);
        }
    }

    static void deletefromposition(int p) {
        previoustext.add(text);
        previousposition.add(p);
        text = text.substring(0, p - 1);
        position = p - 1;
    }

    static char retriveatpositions(int p) {
        char c = text.charAt(p - 1);
        position = p - 1;
        return c;
    }

    static void checkcommands(String s) {
        String s1[] = s.split(" ");
        int command = Integer.parseInt(s1[0]);
        if (command == 1) {
            insert(s1[1]);
        }

        else if (command == 2) {
            deletefromposition(Integer.parseInt(s1[1]));
        } else if (command == 3) {
            System.out.println(retriveatpositions(Integer.parseInt(s1[1])));
        } else if (command == 4) {
            if (!previoustext.empty() && !previousposition.empty()) {
                text = previoustext.pop();
                position = previousposition.pop();
            } else {
                System.out.println("There is no last executed command");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String commands[] = input.split(",");
        for (String command : commands) {
            checkcommands(command);
        }
    }

}
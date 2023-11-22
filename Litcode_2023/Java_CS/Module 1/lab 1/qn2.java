import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print(" ");
        String[] input = scanner.nextLine().split(" ");

        int[] nums = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }

        int maxLength = findMaxLength(nums);
        System.out.println(" " + maxLength);
    }

    public static int findMaxLength(int[] nums) {
        int maxLength = 0;
        int sum = 0;
        Map<Integer, Integer> sumToIndex = new HashMap<>();
        sumToIndex.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                sum--;
            } else {
                sum++;
            }

            if (sumToIndex.containsKey(sum)) {
                int previousIndex = sumToIndex.get(sum);
                maxLength = Math.max(maxLength, i - previousIndex);
            } else {
                sumToIndex.put(sum, i);
            }
        }

        return maxLength;
    }
}
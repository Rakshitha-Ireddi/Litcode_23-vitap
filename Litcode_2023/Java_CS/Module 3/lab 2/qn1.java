import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String inputText = input.nextLine();
        int k = input.nextInt();
        int position = input.nextInt();
        String[] inputStrArray = inputText.split(" ");
        int n = inputStrArray.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(inputStrArray[i]);
        }

        boolean isInOrder = true;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                isInOrder = false;
                break;
            }
        }
        int[] resultantArray = new int[n - k + 1];
        if (isInOrder == true) {
            for (int i = 0; i <= n - k; i++) {
                resultantArray[i] = arr[i + position - 1];
            }
        } else {
            resultantArray = slidingSubArrayBeauty(arr, k, position, n);
        }
        for (int i = 0; i < n - k + 1; i++) {
            System.out.print(resultantArray[i] + " ");
        }
    }

    public static int[] slidingSubArrayBeauty(int[] arr, int k, int position, int n) {
        int[] resultantArray = new int[n - k + 1];
        ArrayList<Integer> subArr = new ArrayList<Integer>();
        int count = 0;
        for (int i = 0; i <= n - k; i++) {
            for (int j = i; j < i + k; j++) {
                subArr.add(arr[j]);
            }
            int min_index = 0;
            while (count != position) {
                min_index = 0;
                int subSize = subArr.size();
                for (int j = 0; j < subSize; j++) {
                    if (subArr.get(j) < subArr.get(min_index)) {
                        min_index = j;
                    }
                }
                count++;
                if (count == position) {
                    resultantArray[i] = subArr.get(min_index);
                } else {
                    subArr.remove(min_index);
                }
            }
            subArr.clear();
            count = 0;
        }
        return resultantArray;
    }
}
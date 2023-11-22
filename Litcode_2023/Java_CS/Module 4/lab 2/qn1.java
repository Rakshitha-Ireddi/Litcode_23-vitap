import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] numsString = scanner.nextLine().split(" ");
        int numQueries = Integer.parseInt(scanner.nextLine());

        int[][] queries = new int[numQueries][2];
        for (int i = 0; i < numQueries; i++) {
            String[] queryString = scanner.nextLine().split(" ");
            for (int j = 0; j < 2; j++) {
                queries[i][j] = Integer.parseInt(queryString[j]);
            }
        }

        int[] output = smallestTrimmedNumbers(numsString, queries);
        for (int i = 0; i < output.length; i++) {
            System.out.print(output[i] + " ");
        }
    }

    public static int[] smallestTrimmedNumbers(String[] numsString, int[][] queries) {
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int k = queries[i][0];
            int trim = queries[i][1];

            PriorityQueue<Pair> minHeap = new PriorityQueue<>();

            for (int j = 0; j < numsString.length; j++) {
                String temp = numsString[j];
                String res = temp.substring(temp.length() - trim);
                minHeap.add(new Pair(res, j));
            }

            int top = -1;
            while (!minHeap.isEmpty() && k > 0) {
                Pair topPair = minHeap.poll();
                String res = topPair.res;
                top = topPair.top;
                k--;
            }

            ans[i] = top;
        }

        return ans;
    }

    private static class Pair implements Comparable<Pair> {
        public String res;
        public int top;

        public Pair(String res, int top) {
            this.res = res;
            this.top = top;
        }

        @Override
        public int compareTo(Pair other) {
            return res.compareTo(other.res);
        }
    }
}
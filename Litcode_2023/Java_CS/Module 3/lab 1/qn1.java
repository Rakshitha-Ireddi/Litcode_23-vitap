import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String inputText = input.nextLine();
        String splitArray[] = inputText.split(" ");
        String text = splitArray[0];
        String pattern = splitArray[1];
        int subsequenceCount1 = 0, subsequenceCount2 = 0;
        String str1 = pattern.charAt(0) + text;
        String str2 = text + pattern.charAt(1);
        subsequenceCount1 = numOfSubsequences(str1, pattern);
        subsequenceCount2 = numOfSubsequences(str2, pattern);
        int maxSubsequencesCount;
        if (subsequenceCount1 > subsequenceCount2) {
            maxSubsequencesCount = subsequenceCount1;
        } else {
            maxSubsequencesCount = subsequenceCount2;
        }
        System.out.println(maxSubsequencesCount);
    }

    public static int numOfSubsequences(String str, String pattern) {
        int strSize = str.length();
        int count = 0;
        for (int i = 0; i < strSize; i++) {
            if (str.charAt(i) == pattern.charAt(0)) {
                for (int j = i + 1; j < strSize; j++) {
                    if (str.charAt(j) == pattern.charAt(1)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

}
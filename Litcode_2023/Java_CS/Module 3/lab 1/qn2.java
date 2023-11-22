import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str1 = input.nextLine();
        int target = Integer.parseInt(str1);
        String str2 = input.nextLine();
        String[] splitArray = str2.split(" ");
        int sizeOfArray = splitArray.length;
        ArrayList<Integer> sweetLevels = new ArrayList<Integer>();
        for (int i = 0; i < sizeOfArray; i++) {
            sweetLevels.add(Integer.parseInt(splitArray[i]));
        }
        int numOfSteps = 0;
        while (targetLevelReached(sweetLevels, target) == false) {
            sweetLevels = updateSweetLevels(sweetLevels);
            numOfSteps++;
        }
        System.out.println(numOfSteps);
    }

    public static boolean targetLevelReached(ArrayList<Integer> sweetLevels, int target) {
        int numOfCandies = sweetLevels.size();
        for (int i = 0; i < numOfCandies; i++) {
            if (sweetLevels.get(i) < target) {
                return false;
            }
        }
        return true;
    }

    public static ArrayList<Integer> updateSweetLevels(ArrayList<Integer> sweetLevels) {
        int min_index = 0;
        int new_sweetlevel;
        int numOfCandies = sweetLevels.size();
        for (int i = 0; i < numOfCandies; i++) {
            if (sweetLevels.get(i) < sweetLevels.get(min_index)) {
                min_index = i;
            }
        }
        new_sweetlevel = sweetLevels.get(min_index);
        sweetLevels.remove(min_index);
        min_index = 0;
        for (int i = 0; i < numOfCandies - 1; i++) {
            if (sweetLevels.get(i) < sweetLevels.get(min_index)) {
                min_index = i;
            }
        }
        new_sweetlevel += 2 * sweetLevels.get(min_index);
        sweetLevels.remove(min_index);
        sweetLevels.add(new_sweetlevel);
        return sweetLevels;
    }
}
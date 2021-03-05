package interview;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class AdventDayOne {
    /*
In this list, the two entries that sum to 2020 are 1721 and 299.
Multiplying them together produces 1721 * 299 = 514579, so the correct answer is 514579.
     */

    public static void main(final String[] args) throws Exception {
//        final int[] nums = new int[]{1721,
//                979,
//                366,
//                299,
//                675,
//                1456};
        int[] nums = new int[100000];
        int count = 0;
        try {
            Scanner scanner = new Scanner(new File("./src/main/resources/ints.txt"));
            int i = 0;
            while (scanner.hasNextInt()) {
                nums[i++] = scanner.nextInt();
                count++;
            }
        } catch (Exception exe) {
            System.out.println(exe);
        }
        nums = Arrays.copyOfRange(nums, 0, count -1);
        System.out.println(returnMultipleOfTwoInts(nums, 2020));
    }

    private static int returnMultipleOfTwoInts(final int[] arr, int sum) {
        // sort the array .. this is a n*O(log(n)) call
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 2; i++) {
            int low = i + 1;
            int high = arr.length - low;
            while (low < high) {
                if (arr[low] + arr[high] + arr[i] == sum) {
                    return arr[low] * arr[high] * arr[i];
                } else if (arr[low] + arr[high] + arr[i] < sum) {
                    // if its less than the sum we should increment low
                    low++;
                } else {
                    high--;
                }
            }
        }
        return 0;
    }
}

package interview;

import java.util.ArrayList;
import java.util.List;

public class ArraySearch {

    static int[] findDuplicates(int[] arr1, int[] arr2) {
        final List<Integer> answerList = new ArrayList<>();
        for (int i = 0; i < arr1.length; i++) {
            if (searchBST(arr1[i], arr2, 0, arr2.length - 1)) {
                answerList.add(arr1[i]);
            }
        }

        int[] arr = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            arr[i] = answerList.get(i);
        }

        return arr;

    }

    public static boolean searchBST(final int num, final int[] arr2, final int start, final int end) {

        if (end - start < 1) {
            return false;
        }
        int middleIndex = start + (end - start) / 2;
        int middle = arr2[middleIndex];

        if (middle < num) {
            return searchBST(num, arr2, middleIndex + 1, end);
        } else if (middle > num) {
            return searchBST(num, arr2, start, middleIndex - 1);
        } else {
            return true;
        }
    }

    public static void main(String[] args) {

        final int[] arr1 = new int[]{1, 2, 3, 5, 6, 7};
        final int[] arr2 = new int[]{3, 6, 7, 8, 20};

        int[] dup = (findDuplicates(arr1, arr2));

        for (int num : dup)
            System.out.println(num);

    }
}

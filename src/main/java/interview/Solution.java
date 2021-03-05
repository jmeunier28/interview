package interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    //arr2 = [1, 2, 3, 5, 6, 7]
    //arr1 = [3, 6, 7, 8, 20]
    static int[] findDuplicates(int[] arr1, int[] arr2) {
        if(arr1.length > arr2.length){
            return findDuplicates(arr2, arr1);
        }
        List<Integer> res = new ArrayList<>();
        int min = arr2[0], max = arr2[arr2.length-1];
        int start = 0;

        for(int element : arr1){
            if(element < min || element > max){
                System.out.println("skipping:"+element);
                continue;
            }

            int end = arr2.length-1;
//            if(start--;
            while(!(end - start < 1)){
                int mid = start + ((end - start) >> 1);
                System.out.println(element+ " start:"+start+" mid:"+mid+" end:"+end);
                if(arr2[mid] == element){
                    res.add(arr2[mid]);
                    break;
                }else if(arr2[mid] > element){
                    //move left
                    end = mid-1;
                }else{
                    //move right
                    start = mid + 1;
                }

            }
        }

        int[] result = new int[res.size()];
        int i = 0;
        for(int num : res) result[i++] = num;
        return result;
    }

    public static void main(String[] args) {
        int arr1[] = new int[]{1, 2, 3, 5, 6, 7};
        int arr2[] = new int[]{3, 6, 7, 8, 20};
        int arr[] = findDuplicates(arr1, arr2);
        System.out.println(Arrays.toString(arr));
    }
}

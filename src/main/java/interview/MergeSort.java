package interview;

public class MergeSort {

    public static void mergeSort(int[] arr, int n) {
        // base case is if n == 1
        if (n < 2) {
            return;
        }

        // next break the two arrays up
        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];

        // populate the arrays
        for (int i = 0; i < mid; i++) {
            l[i] = arr[i];
        }

        for (int i = mid; i < n ; i++) {
            r[i - mid] = arr[i];
        }

        mergeSort(l, mid);
        mergeSort(r, n - mid);

        merge(arr, l, r, mid, n - mid);
    }

    private static void merge(int[] arr, int[] l, int[] r, int left, int right) {
        // merge these back together
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < left && j < right) {
            if (l[i] > r[j]) {
                arr[k++] = r[j++];
            } else {
                arr[k++] = l[i++];
            }
        }

        while (i < left) {
            arr[k++] = l[i++];
        }

        while (j < right) {
            arr[k++] = r[j++];
        }

    }


    public static void main(final String[] args) {
        int[] actual = { 5, 1, 6, 2, 3, 4 };
        mergeSort(actual, actual.length);
        System.out.println("After Merge Sort");
        for (int i : actual) {
            System.out.print(i + " ");
        }
    }
}

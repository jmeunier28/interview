package interview;

public class SortingWithAnswers {
    /**
     * Assuming you’re given an array of integers P and a similar array of integers A, where A contains the index of each item of P, if P were in sorted order. For example:
     *
     * P = { 6, 4, 3, 1, 2, 5 } => { 5, 4, 3, 1, 2, 6 } => { 5, 1, 3, 4, 2, 6 } => N/A => N/A => { 5, 2, 3, 4, 1, 6 }
     * A = { 5, 3, 2, 0, 1, 4 } => { 4, 3, 2, 0, 1, 5 } => { 4, 0, 2, 3, 1, 5 } => N/A => N/A => { 4, 1, 2, 3, 0, 5 }
     *
     * Write an algorithm in Java that will sort P, using as little memory as possible.
     * What’s the running time of this algorithm?
     */

    /**
     * iterate over P from i = 0 to P.length
     * P[0] = 6 - 1 => swap(A[5],A[0]); swap(P[0],P[5]);
     * P[1] = 4 -1 => swap(A[3],A[1]); swap(P[3],P[1])
     * P[2] = 3 - 1 => swap(A[2], A[2]); swap(P[2],P[2]); // do nothing
     * P[3] = 4 - 1 => swap(A[3], A[3]); swap(P[3],P[3]); // do nothing
     * P[4] = 2 - 1 => swap(A[1], A[4]); swap(P[1],P[4]);
     * P[5] = 6 - 1 => swap(A[5], A[5]); swap(P[5],P[5]);
     */
    public static int[] sortWithAnswers(final int[] answers, final int[] arr) {
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length ; i++) {
            result[answers[i] - 1] = arr[i];
        }

        for (int i = 0; i < arr.length; i++) {
            int pTemp = answers[i];
            int aTemp = arr[pTemp - 1];
            arr[pTemp - 1] = arr[i];
            answers[pTemp - 1] = answers[i];
            arr[i] = aTemp;
            answers[i] = pTemp;
        }
        return arr;
    }
    public static void main(final String[] args) {
        final int[] answerArr = new int[]{ 6, 4, 3, 1, 2, 5 };
        final int[] arr = new int[]{ 5, 3, 2, 0, 1, 4 };
        final int[] result = sortWithAnswers(answerArr, arr);
        for (int num : result) {
            System.out.println(num);
        }
    }
}

package interview;

public class NewYearChaos {

    public static void main(final String[] args) {
        final int[] nums = new int[]{1, 2, 5, 3, 7, 8, 6, 4};
        minimumBribes(nums);
    }

    // Complete the minimumBribes function below.
    public static void minimumBribes(int[] q) {
        int minBribes = 0;
        int position = q.length;
        for (int i = position - 1; i >= 0; i--) {
            // the person could have either skipped one or two positions
            // otherwise they be cray cray
            if (q[i] != i + 1) {
                if (i - 1 >= 0 && q[i - 1] == i + 1) {
                    q[i - 1] = q[i];
                    q[i] = i + 1;
                    minBribes++;
                } else if (i - 2 >= 0 && q[i - 2] == i + 1) {
                    q[i - 2] = q[i - 1];
                    q[i - 1] = q[i];
                    q[i] = i + 1;
                    minBribes += 2;
                } else {
                    System.out.println("Too chaotic");
                    return;
                }
            }
        }

        System.out.println(minBribes);

    }
}

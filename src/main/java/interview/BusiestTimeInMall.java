package interview;

public class BusiestTimeInMall {

    // iterate the list
    // grab the first element from each list
    // put into hashmap timestamp: occupancy number
    // if (map.contains(timestamp)) {
    //   check to see if arr[2] == 1
    // add its count by arr[1]
    // else decrement its count arr[1]
    // iterate the hashmap and return key with highest count

    // Time: O(N + N) ~ O(N)
    // Space: O(N)

    // global max_sum = -1
    // iterate over the list of arrs from i = 1 to arr.length
    // int sum = 0
    // if (arr[i][0] == arr[i+1][0])
    //    sum =+ arr[i][1] // TODO do the right thing
    // else
    //    sum += arr[i][i]
    //    max_num = Math.max(max_num, sum);
    // Time: O(N)
    // Space: O(1)

    static int findBusiestPeriod(int[][] arr) {
        int n = arr.length;
        int max_num = 0;
        int max_time_period = 0;
        int sum = 0;

        if (n < 2) {
            return arr[0][0];
        }

        for (int i = 0 ; i < arr.length - 1; i++) {

            // timestamp match
            if (arr[i][2] == 1) {
                sum += arr[i][1];
            } else {
                sum -= arr[i][1];
            }

            if (i < n -1 && arr[i][0] == arr[i+1][0]) {
                continue;

            }

            if (sum > max_num) {
                // update max_timeperiod
                max_num = sum;
                max_time_period =  arr[i][0];
            }


        }

        return max_time_period;
    }

    /**
     * The Westfield Mall management is trying to figure out what the busiest moment at the mall was last year. You’re given data extracted from the mall’s door detectors. Each data point is represented as an integer array whose size is 3. The values at indices 0, 1 and 2 are the timestamp, the count of visitors, and whether the visitors entered or exited the mall (0 for exit and 1 for entrance), respectively. Here’s an example of a data point: [ 1440084737, 4, 0 ].
     *
     * Note that time is given in a Unix format called Epoch, which is a nonnegative integer holding the number of seconds that have elapsed since 00:00:00 UTC, Thursday, 1 January 1970.
     *
     * Given an array, data, of data points, write a function findBusiestPeriod that returns the time at which the mall reached its busiest moment last year. The return value is the timestamp, e.g. 1480640292. Note that if there is more than one period with the same visitor peak, return the earliest one.
     *
     * Assume that the array data is sorted in an ascending order by the timestamp. Explain your solution and analyze its time and space complexities.
     *
     * input:  data = [ [1487799425, 14, 1],
     *                  [1487799425, 4,  0],
     *                  [1487799425, 2,  0],
     *                  [1487800378, 10, 1],
     *                  [1487801478, 18, 0],
     *                  [1487801478, 18, 1],
     *                  [1487901013, 1,  0],
     *                  [1487901211, 7,  1],
     *                  [1487901211, 7,  0] ]
     *
     * output: 1487800378
     * @param args
     */

    public static void main(String[] args) {
//        final int[][] data = new int[1487799425,14,1],[1487799425,4,1],[1487799425,2,1],[1487800378,10,1],[1487801478,18,1],[1487901013,1,1],[1487901211,7,1],[1487901211,7,1]]

    }
}

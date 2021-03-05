package interview;

import java.util.Arrays;

public class Awards {
    /**
     * The awards committee of your alma mater (i.e. your college/university) asked for your assistance with a budget allocation problem they're facing. Originally, the committee planned to give N research grants this year. However, due to spending cutbacks, the budget was reduced to newBudget dollars and now they need to reallocate the grants. The committee made a decision that they'd like to impact as few grant recipients as possible by applying a maximum cap on all grants. Every grant initially planned to be higher than cap will now be exactly cap dollars. Grants less or equal to cap, obviously, won't be impacted.
     *
     * Given an array grantsArray of the original grants and the reduced budget newBudget, write a function findGrantsCap that finds in the most efficient manner a cap such that the least number of recipients is impacted and that the new budget constraint is met (i.e. sum of the N reallocated grants equals to newBudget).
     *
     * Analyze the time and space complexities of your solution.
     *
     * input:  grantsArray = [2, 100, 50, 120, 1000], newBudget = 190
     *
     * output: 47 # and given this cap the new grants array would be
     *            # [2, 47, 47, 47, 47]. Notice that the sum of the
     *            # new grants is indeed 190
     *
     *   average grant = sum of all grants / grantsArray.len == 472 // todo: i don't care, right?
     *   figure out how to make sum == 190
     *   in order to get to 190 each thing has be <= 190 / grantsArray.len == 38
     *   ... but if grantsArray[i] < 38 we would
     *             1. not make a change to it
     *             2. add the difference 38 - 2 == 36 to the allowable running avg -> 36 / grantsArray.len - i == 47
     *             3. best way to do this is to sort the list first
     *
     * [time limit] 5000ms
     *
     * [input] array.double grantsArray
     *
     * 0 ≤ grantsArray.length ≤ 20
     * 0 ≤ grantsArray[i]
     * [input] double newBudget
     *
     * [output] double
     */

    static double findGrantsCap(double[] grantsArray, double newBudget) {
        if (grantsArray.length < 2) {
            return newBudget; // if we get an array of just [1000] the cap will be the total budget
        }
        // to start, in order to get to newBudget each thing has be <= newBudget / grantsArray.len
        double cap = newBudget / grantsArray.length;
        double[] output = new double[grantsArray.length];
        // we want the array to be sorted
        Arrays.sort(grantsArray); // probably gives us n*log(n) time
        for (int i = 0; i < grantsArray.length; i++) {
            if (grantsArray[i] < cap) {
                // add the difference 38 - 2 == 36 to the allowable running avg -> 36 / grantsArray.len - i == 9 + cap
                cap = ((cap - grantsArray[i]) / (double) (grantsArray.length - i - 1)) + cap;
                output[i] = grantsArray[i]; // don't change value
            } else {
                output[i] = cap;
            }
        }

        for (double num : output) {
            System.out.println(num);
        }

        return cap;

    }

    public static void main(final String[] args) {
        final double[] grantsArray = {2, 100, 50, 120, 1000};
        final double newBudget = 190;
        System.out.println("Cap is " + findGrantsCap(grantsArray, newBudget));
    }
}

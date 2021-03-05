package interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CardsIncreasingOrder {
    public static int[] deckRevealedIncreasing(int[] deck) {
        final List<Integer> result = new ArrayList<>();
        Arrays.sort(deck);
        if (deck.length <= 2) {
            return deck;
        }
        int n = deck.length - 1;
        // [2,3,5,7,11,13,17]
        // [17] i = 6
        // [13, 17]  i = 5 ; move 17 to front ; add 13
        // [11, 17, 13] i = 4  ; move 17 to front ; add 11
        // [7, 13, 11, 17] i = 3  ; move 13 to front ; add 7
        // [5, 17, 7, 13, 11] i = 2  ; move 17 to front; add 5
        // [3, 11, 5, 17, 7, 13] i = 1  ; move 11 to front ; add 3
        // [2, 13, 3, 11, 5, 17, 7] i =0 ; move 13 to front ; add 2 => answer
        result.add(deck[n]); // add last element
        n--; // decrement i
        result.add(0, deck[n]); // i =5
        while(n >=1) {
            // for i = 4 to i = 0;
            // first take last element and put it first
            final Integer bottom = result.get(result.size() - 1); // get last
            result.remove(bottom); // remove last
            result.add(0, bottom); // add last to front
            n--;
            result.add(0, deck[n]);
        }

        int[] res = new int[result.size()];
        int i = 0;
        for (Integer num : result) {
            res[i++] = num;
        }
        return res;
    }

    public static void main(final String[] args) {
        final int[] arr = new int[]{17, 13, 11, 2, 3, 5, 7};
        final int[] res = deckRevealedIncreasing(arr);
        for (int num : res) {
            System.out.println(num);
        }
    }
}

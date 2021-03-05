package interview;

import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.List;

public class DynamicArray {

    public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
        final List<Integer> answerList = new ArrayList<>();
        final ArrayList<Integer>[] seqList = new ArrayList[n];
        int lastAnswer = 0;
        for (List<Integer> query : queries) {
            final int type = query.get(0);
            final int x = query.get(1);
            final int y = query.get(2);
            final int index = (x ^ lastAnswer) % n;

            switch(type) {
                case 1:
                    // grab the answer at
                    if (seqList[index] == null) {
                        // create a new arr
                        final ArrayList<Integer> arr = new ArrayList<>();
                        arr.add(y);
                        seqList[index] = arr;
                    } else {
                        seqList[index].add(y);
                    }
                    break;

                case 2:
                    // all we do is calc y % size(arr[index])
                    lastAnswer = seqList[index].get(y % seqList[index].size());
                    answerList.add(lastAnswer);
            }

        }

        return answerList;

    }

    public static void main(final String[] args) {
        final List<List<Integer>> listList = new ArrayList<>();
        listList.add(ImmutableList.of(1, 0, 5));
        listList.add(ImmutableList.of(1, 1, 7));
        listList.add(ImmutableList.of(1, 0, 3));
        listList.add(ImmutableList.of(2, 1, 0));
        listList.add(ImmutableList.of(2, 1, 1));
        System.out.println(dynamicArray(2, listList));
    }
}

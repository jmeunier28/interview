package interview;

import java.util.HashMap;
import java.util.Map;

public class SmallestSubstring {

    private static String smallestSub = "";
    private static HashMap<Character, Integer> find = new HashMap<>();

    public static String smallestSubString(String searchString, String sub) {
        // put start and end pointers in same place
        int start = 0;
        int end = 0;
        int smallestLen = Integer.MAX_VALUE;
        for (char character : sub.toCharArray()) {
            if (!find.containsKey(character)) {
                find.put(character, 1);
            } else {
                Integer val = find.get(character);
                val++;
                find.put(character, val);
            }
        }
        while (start <= searchString.length()) {
            final String iterSub = searchString.substring(start, end);
            if (doesSubSatisfy(iterSub, sub)) {
                if (smallestLen > iterSub.length()) {
                    smallestLen = iterSub.length();
                    smallestSub = iterSub;
                }
                // also move start pointer forward
                start++;
            } else {
                // move end pointer forward and look again
                if (end != searchString.length()) {
                    end++;
                } else {
                    break;
                }
            }
        }

        return smallestSub;
    }

    private static boolean doesSubSatisfy(String substring, String sub) {
        // return true if each character in sub also exists in substring
        HashMap<Character, Integer> seen = new HashMap<>();
        for (Map.Entry<Character, Integer> entry : find.entrySet()) {
            seen.put(entry.getKey(), 0);
        }
        if (sub.length() <= substring.length()) {
            for (Character c : substring.toCharArray()) {
                if (find.containsKey(c)) {
                    Integer val = seen.get(c);
                    val++;
                    seen.put(c, val);
                }
            }
            // we need at least equal or greater count in seen
            for (Map.Entry<Character, Integer> entry : seen.entrySet()) {
                if (find.get(entry.getKey()) > entry.getValue()) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public static void main(final String args[]) {
        //"bbaa"
        //"aba"
        String sub = "aba";
        String str = "bbaa";

        System.out.println(smallestSubString(str, sub));
    }

    /**
     1. keep track of when i find a substring with the letters I need
     2. keep track of what letters i need
     3. keep track of start and end so i know which parts of the string to grab

     "xyyzzyzyzx"
     s        e

     string sub = "";
     int[] seen; // maps counts to their position in input char array

     if (end - start < 1) {
     return sub;
     }
     loop over input str for i in start : end
     if seen has a 1 in each position:
     newSub = str(start, i).len < sub.len ? str(start, i) : sub;
     recurse(start + 1, end)
     if charAt(i) is in find str:
     seen[arr[charAt(i)]]++; // increment count in char's position in seen arr


     */
}

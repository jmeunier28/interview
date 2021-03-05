package interview;

import com.google.common.collect.Maps;

import java.io.File;
import java.util.Map;
import java.util.Scanner;

public class AdventDayTwo {

    public static void main(final String[] args) {
        /*
        1-3 a: abcde
        1-3 b: cdefg
        2-9 c: ccccccccc
         */
        Map<IntPairAndLetter, String> passwords = Maps.newHashMap();
        try {
            Scanner scanner = new Scanner(new File("./src/main/resources/advent-day-two.txt"));
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                // remove spaces
                line = line.replaceAll("\\s", "");
                final int firstOne = Integer.parseInt(line.substring(0, line.indexOf("-")));
                final int secondOne = Integer.parseInt(line.substring(line.indexOf("-") + 1, line.indexOf(":") - 1));
                final char letter = line.charAt(line.indexOf(":") - 1);
                final String word = line.substring(line.indexOf(':') + 1);
                passwords.put(new IntPairAndLetter(firstOne, secondOne, letter), word);
            }
        } catch (Exception exe) {
            System.out.println(exe);
        }
        System.out.println(numValidPasswords(passwords));

    }

    private static int numValidPasswords(Map<IntPairAndLetter, String> passwords) {
        int validPwd = 0;
        for (Map.Entry<IntPairAndLetter, String> entry : passwords.entrySet()) {
            final char[] arr = entry.getValue().toCharArray();
            final char letter = entry.getKey().getLetter();
            if (arr[entry.getKey().firstIndex()] == letter && arr[entry.getKey().secondIndex()] != letter) {
                validPwd++;
            } else if (arr[entry.getKey().firstIndex()] != letter && arr[entry.getKey().secondIndex()] == letter) {
                validPwd++;
            }
//            int count = 0;
//            for (char c : arr) {
//                if (c == entry.getKey().getLetter()) {
//                    count++;
//                }
//            }
//            if (count <= entry.getKey().secondIndex() && count >= entry.getKey().firstIndex()) {
//                validPwd++;
//            }
        }
        return validPwd;
    }

    private static class IntPairAndLetter {
        int low;
        int high;
        char letter;

        IntPairAndLetter(final int low, final int high, final char letter) {
            this.low = low - 1;
            this.high = high - 1;
            this.letter = letter;
        }

        public int firstIndex() {
            return low;
        }

        public int secondIndex() {
            return high;
        }

        public char getLetter() {
            return letter;
        }
    }
}

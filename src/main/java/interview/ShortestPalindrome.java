//package interview;
//
//public class ShortestPalindrome {
//
//    /**
//     * Given a string s, you can convert it to a palindrome by adding characters in front of it.
//     * Find and return the shortest palindrome you can find by performing this transformation.
//     */
//
//    public static String shortestPalindrome(final String input) {
//        StringBuilder answer = new StringBuilder();
//        // gimme the reverse of the input string
//        StringBuilder builder = new StringBuilder();
//        builder.append(input);
//        builder.reverse();
//        String rev = builder.toString();
//
//        // first check to see if input is palindrome
////        if (isPalindrome(input)) {
////            return input;
////        }
//
//        int n = input.length();
//        for (int i = 0 ; i < n ; i++) {
//            // aacecaaa
//            // aaacecaa
//            if (input.charAt(i) == rev.charAt(i)) {
//
//            }
//        }
//
//
//        return output;
//    }
//
//    private static boolean isPalindrome(String input) {
//        int j = input.length()-1;
//        int i = 0;
//        while (i != j) {
//            // aaacecaaa
//            if (!(input.charAt(i) == input.charAt(j))) {
//                return false;
//            }
//            i++;
//            j--;
//        }
//
//        return true;
//    }
//
//    public static void main(final String[] args) {
//        String input = "aaacecaaa";
//        System.out.println(shortestPalindrome(input));
//    }
//}

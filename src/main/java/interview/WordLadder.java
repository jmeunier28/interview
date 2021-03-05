package interview;

import com.google.common.collect.ImmutableList;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class WordLadder {
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        final LinkedList<String> wordQueue = new LinkedList<>();
        final HashSet<String> wordSet = new HashSet<>();
        int distance = 0;

        if (beginWord.length() != endWord.length()) {
            return distance;
        }

        // ["hot","dot","dog","lot","log","cog"]
        // One shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog" with 5 words.

        // add all of the words in our dictionary to a set
        wordSet.addAll(wordList);

        // for every word in our set i need to test if there exists a word
        // which is only different from our curr word by a single letter
        // if i find one .. add it to the queue
        wordQueue.add(beginWord);
        while (!wordQueue.isEmpty()) {
            // 1. check each word present in our set
            // 2. find any that are diff by one letter or if curWord == endWord
            // 3. add to back of our queue
            // 4. remove that word from the set
            // 5. increment our path by 1 (even if we find more than one word that works)
            final String curWord = wordQueue.pollFirst();
            for (Iterator<String> it = wordSet.iterator(); it.hasNext(); ) {
                final String word = it.next();
                if (checkIfDistanceOnlyOne(curWord, word)) {
                    if (curWord.equals(endWord)) {
                        return distance + 1;
                    }
                    wordQueue.addLast(word);
                    it.remove();
                }
                distance++; // todo this isnt correct.. need to keep track of the actual depth of the queue
            }

        }
        return distance;
    }

    private static boolean checkIfDistanceOnlyOne(String curWord, String word) {
        int wordLen = curWord.length();
        int common = 0;
        for (int i = 0; i < wordLen; i++) {
            if (curWord.charAt(i) == word.charAt(i)) {
                // they equal so increment common
                common++;
            }
        }

        return wordLen - common == 1;
    }

    private static class WordAndDepth {
        String word;
        int depth;

        public WordAndDepth(String word, int depth) {
            this.word = word;
            this.depth = depth;
        }

        public String getWord() {
            return word;
        }

        public int getDepth() {
            return depth;
        }

        public void setDepth(int depth) {
            this.depth = depth;
        }
    }

    public static void main(final String[] args) {
        final String source = "bit";
        final String target = "cog";

        final List<String> words = ImmutableList.of("but", "put", "big", "pot", "pog", "dog", "lot");

        System.out.println(ladderLength(source, target, words));
    }
}

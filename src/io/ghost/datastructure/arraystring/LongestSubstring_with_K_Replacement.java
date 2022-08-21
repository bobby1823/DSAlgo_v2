package io.ghost.datastructure.arraystring;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string with lowercase letters only, if you are allowed to replace no more than ‘k’ letters with any letter,
 * find the length of the longest substring having the same letters after replacement.
 *
 *
 *
 * Time Complexity #
 * The time complexity of the above algorithm will be O(N) where ‘N’ is the number of letters in the input string.
 *
 * Space Complexity #
 * As we are expecting only the lower case letters in the input string, we can conclude that the space complexity will
 * be O(26), to store each letter’s frequency in the HashMap, which is asymptotically equal to O(1)O(1).
 */
public class LongestSubstring_with_K_Replacement {

    public static void main(String[] args) {
        System.out.println("The count: " + find("AABABBA", 1));
    }

    /**
     * K is the number of replacements allowed.
     *
     * Trick is in HashMap we need to maintain the count of maximum number which is repeating, based on that we need to
     * either shrink/increase the window size. If window size - no. of repeating character count <= k, then increase the
     * window.
     * @param str
     * @param k
     * @return
     */
    public static int find(String str, int k) {
        int windowLen = 0, windowStart = 0, windowEnd = 0, maxCharCount = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
            maxCharCount = Math.max(maxCharCount, map.get(str.charAt(i)));
            windowEnd = i;
            // check if true start shrinking the window
            // Note the condition, it shoould be greater than not equal to.
            while (((windowEnd - windowStart + 1) - maxCharCount) > k) {
                char leftChar = str.charAt(windowStart);
                if (map.get(leftChar) > 1) {
                    map.put(leftChar, map.get(leftChar) - 1);
                } else {
                    map.remove(leftChar);
                }
                // shrinking window
                windowStart += 1;
            }
            windowLen = Math.max(windowLen, windowEnd - windowStart + 1);
        }
        return windowLen;
    }
}

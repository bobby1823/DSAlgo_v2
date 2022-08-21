package io.ghost.datastructure.arraystring;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the length of the longest substring which has no repeating characters.
 * <p>Input</p>: String="aabccbb"
 * Output: 3
 * Explanation: The longest substring without any repeating characters is "abc".
 */
public class LongestSubstring_No_Repeat_Char {
    public static void main(String[] args) {
        System.out.println("Longest substring with no repeating characters " + find("abcccbb"));
    }

    public static int find(String str) {
        int windowStart = 0 , windowEnd = 0, maxLen = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {

            // Here we are storing the each elements character last position in the Map. If character present in Map (Repeatition)
            // Then we are changing the value of windowStart date to next value
            if (map.containsKey(str.charAt(i))) {
//                windowStart += 1;
                windowStart = Math.max(windowStart, map.get(str.charAt(i)) + 1);
            }
            map.put(str.charAt(i), i);
            windowEnd = i;
            maxLen = Math.max(maxLen, windowEnd - windowStart + 1);
        }
        return maxLen;
    }
}

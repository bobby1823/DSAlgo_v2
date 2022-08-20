package io.ghost.datastructure.arraystring;

import java.util.HashMap;

public class LongestSubstring_K_DistinctCharacters {

    public static void main(String[] args) {
        System.out.println("Longest substring " + findLength("wcysyycqpev", 6));
    }

    public static int findLength(String str, int k) {
        if (str==null || str.length() < k || str.length() == 0)
            throw new IllegalArgumentException("Not Allowed. K or string is not valid");

        int windowStart = 0, windowEnd = 0, maxLen = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0)+1);
            while (map.size() > k) {
                if (map.get(str.charAt(windowStart)) > 1) {
                    map.put(str.charAt(windowStart), map.getOrDefault(str.charAt(windowStart), 0) - 1);
                } else {
                    map.remove(str.charAt(windowStart));
                }
                windowStart += 1;
            }
            windowEnd = i;
            // This is important. It keeps a track of maximum.
            maxLen = Math.max(maxLen, windowEnd - windowStart + 1);
        }
        return windowStart == 0 && map.size() < k ? -1 : maxLen;
    }
}

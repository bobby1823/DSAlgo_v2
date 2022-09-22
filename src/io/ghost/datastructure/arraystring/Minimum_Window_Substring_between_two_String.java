package io.ghost.datastructure.arraystring;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every
 * character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".
 *
 * The testcases will be generated such that the answer is unique.
 *
 * A substring is a contiguous sequence of characters within the string.
 *
 * Example 1:
 *
 * Input: s = "ADOBECODEBANC", t = "ABC"
 * Output: "BANC"
 * Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
 */
public class Minimum_Window_Substring_between_two_String {

    public static void main (String[] args) {
        System.out.println(minWindow("cabwefgewcwaefgcf"
                ,"cae"));
//        System.out.println(minWindow("ab", "B"));
    }


    // This method will return the minimum window substring
    // cabwefgewcwaefgcf  || cae
    public static String minWindow(String s, String t) {
        if (t == "") return "";
        if (t.length() > s.length()) return "";
        if (t.length() == 1 && s.length() == 1 && t.charAt(0) != s.charAt(0)) return "";

        int have = 0, need = 0;
        // This map contains the character and its respective count in array t
        Map<Character, Integer> tMap = new HashMap<>();
        Map<Character, Integer> sMap = new HashMap<>();
        int minWindow = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        int leftFinal = 0, rightFinal = 0;

        for (int i = 0; i < t.length(); i++) {
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
            sMap.put(t.charAt(i), 0);
        }
        need = sMap.size();
        // cabwefgewcwaefgcf  || cae
        for (int i = 0; i < s.length(); i++) {
            if (sMap.containsKey(s.charAt(i))) {
                sMap.put((s.charAt(i)), sMap.getOrDefault(s.charAt(i), 0) + 1);
                if (sMap.get(s.charAt(i)) == tMap.get(s.charAt(i))) have += 1;
            }
//            right += 1;
            while (have >= need) {
//                minWindow = Math.min(right - left + 1, minWindow);
//                left += 1;
                if (minWindow > (right - left + 1)) {
                    leftFinal = left;
                    rightFinal = right;
                    minWindow = (right - left + 1);
                }
                // shift the left pointer
                if (sMap.containsKey(s.charAt(left))) {
                    sMap.put(s.charAt(left), sMap.get(s.charAt(left)) - 1);
                    if (sMap.get(s.charAt(left)) < tMap.get(s.charAt(left)))
                        have -= 1;
                }
                left += 1;
            }
            right += 1;
        }
        if (leftFinal == -1 && rightFinal == -1) return "";
        return s.substring(leftFinal, rightFinal+1);
    }


    // This method will return the minimum window length
    public static int minWindowLen(String s, String t) {
        if (t == "") return 0;
        if (t.length() > s.length()) return 0;
        int have = 0, need = 0;
        // This map contains the character and its respective count in array t
        Map<Character, Integer> tMap = new HashMap<>();
        Map<Character, Integer> sMap = new HashMap<>();
        int minWindow = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;

        for (int i = 0; i < t.length(); i++) {
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
            sMap.put(t.charAt(i), 0);
        }
        need = sMap.size();

        for (int i = 0; i < s.length(); i++) {
            if (sMap.containsKey(s.charAt(i))) {
                sMap.put((s.charAt(i)), sMap.getOrDefault(s.charAt(i), 0) + 1);
                if (sMap.get(s.charAt(i)) == tMap.get(s.charAt(i))) have += 1;
            }

            while (have >= need) {
                minWindow = Math.min(right - left + 1, minWindow);
                // shift the left pointer
                if (sMap.containsKey(s.charAt(left))) {
                    sMap.put(s.charAt(left), sMap.get(s.charAt(left)) - 1);
                    if (sMap.get(s.charAt(left)) < tMap.get(s.charAt(left)))
                        have -= 1;
                }
                left += 1;
            }
            right += 1;
        }
        return minWindow;
    }
}

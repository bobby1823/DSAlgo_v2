package io.ghost.datastructure.arraystring;

import java.util.Arrays;
import java.util.Comparator;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        System.out.println(longestPrefixV2(strs));
    }
    public static String longestCommonPrefix(String[] strs) {
        StringBuffer temp = new StringBuffer();
        boolean break1 = false;
//        Arrays.sort(strs, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o1.length() > o2.length() ? 1 : -1;
//            }
//        });
        // flower, floo, flow, flight
        int j = 0;
        for (char c : strs[0].toCharArray()) {
            for (int i = 1; i < strs.length; i++) {
                if (c != strs[i].charAt(j)) {
                   break1 = true;
                }
            }
            if (break1)
                break;
            j++;
            temp.append(c);
        }
        return temp.toString();
    }

    // Approach -2
    public static String longestPrefixV2(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        return prefix;
    }
}


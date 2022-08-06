package io.ghost.datastructure.arraystring;

public class LongestCommonSuffixBinartSearch {

    public static void main(String[] args) {
        String[] strs = {"floweggght","flowght","fliight"};
        int index = fetchLeastStringIndex(strs);
        System.out.println("Common Prefix:  " +getCommonSuffix(strs, index));
    }


    private static int fetchLeastStringIndex(String[] strs) {
        int index = -1;
        String data = strs.length == 0 || strs[0].length() == 0 ? null : strs[0];
        if (strs.length == 0) return -1;
        for (int i=0; i < strs.length; i++) {
            if (strs[i].length() < data.length()) {index = i; data = strs[i];}
        }
        return index;
    }

    public static boolean isSuffPresent(String strs[], String data, int start, int end) {
        for (int i = strs.length-1; i >= 0; i--) {
            String strs1 = strs[i];
            //flowerht
            //flowht
            // end = 5
            // start = 2
//            strs1.
            for (int j = end; j >= start; j--) {
                if (strs1.charAt(j+(strs1.length()-data.length())) != data.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }
    // geek -> ge ek
    // flowht
    private static String getCommonSuffix(String strs[], int index) {
        String data = strs[index];
        StringBuffer data1 = new StringBuffer();
        int low = 0;
        int high = strs[index].length()-1;

        while(low != high) {
            int mid = low + (high-low)/2;
            if (isSuffPresent(strs, data, mid, high)) {
                data1.append(data.substring(mid, high+1));
                high = mid - 1;
            } else {
                low = mid;
            }
        }
        return data1.toString();
    }
}

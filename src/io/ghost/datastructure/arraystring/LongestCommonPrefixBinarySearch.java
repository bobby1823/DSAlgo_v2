package io.ghost.datastructure.arraystring;

public class LongestCommonPrefixBinarySearch {

    public static void main(String[] args) {
        String[] strs = {"flowerht","flowht","fliight"};
        int index = fetchLeastStringIndex(strs);
        System.out.println("Common Prefix:  " +getCommonPrefix(strs, index));
    }

//    private static String longestPrefixBinarySearch(String[] strs) {
//    }

    private static int fetchLeastStringIndex(String[] strs) {
        int index = -1;
        String data = strs.length == 0 || strs[0].length() == 0 ? null : strs[0];
        if (strs.length == 0) return -1;
        for (int i=0; i < strs.length; i++) {
            if (strs[i].length() < data.length()) index = i;
        }
        return index;
    }

    public static boolean isPrefixPresent(String strs[], String data, int start, int end) {
        for (int i = 0; i < strs.length; i++) {
            String strs1 = strs[i];
            for (int j = start; j <= end; j++) {
                if (strs1.charAt(j) != data.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static String getCommonPrefix(String strs[], int index) {
        String data = strs[index];
        StringBuffer data1 = new StringBuffer();
        int low = 0;
        int high = strs[index].length()-1;

        while(low <= high) {
            int mid = low + (high-low)/2;
            if (isPrefixPresent(strs, data, low, mid)) {
                data1.append(data.substring(low, mid+1));
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return data1.toString();
    }
}

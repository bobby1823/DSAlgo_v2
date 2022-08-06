package io.ghost.datastructure.arraystring;

public class Implementation_IndexOf {

    public static void main(String[] args) {
        strStrv1("missisipi", "a");
    }

    // lello, ll
    // Approach 1
    public static int strStrv1(String haystack, String needle) {
        int index = -1;
        if (needle.length() == 0) return 0;
        if (needle.length() > haystack.length()) return -1;
        for (int i = 0; i <= haystack.length()-needle.length(); i++) {
            for (int j = 0; j < needle.length(); j++) {
//                if ((i+needle.length()) > (haystack.length())) {
//                    return -1;
//                }
                if (haystack.charAt(i+j) != needle.charAt(j)) {
                    index = -1;
                    break;
                }
                else {
                    index = i;
                }
            }
            if (index != -1) {
                return index;
            }
        }

        return index;
    }
}

package io.ghost.datastructure;

public class Reverse {
    public static void main(String[] args) {
        String toBeReversed = "My name is Sayanta";
        System.out.println(reverseString(toBeReversed));
    }

    public static char[] reverseString(String string) {
        char[] reverse = new char[string.toCharArray().length];
        int count = 0;
        for (int i = string.toCharArray().length-1; i >= 0; i--) {
            reverse[count] = string.toCharArray()[i];
            count++;
        }
        return reverse;
    }
}

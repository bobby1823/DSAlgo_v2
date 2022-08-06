package io.ghost.datastructure.arraystring;

import java.util.HashMap;

public class RomantoInt {

    public static void main(String[] args) {
        String romanNum = "CCXLVII";
        System.out.println("Equivalent Roman Number: "+ romanToInt(romanNum));
    }
    // CCXLVII
    public static int romanToInt(String s) {
        HashMap<String, Integer> romanNumeralMap = new HashMap<>();
        romanNumeralMap.put("I", 1);
        romanNumeralMap.put("V", 5);
        romanNumeralMap.put("X", 10);
        romanNumeralMap.put("L", 50);
        romanNumeralMap.put("C", 100);
        romanNumeralMap.put("D", 500);
        romanNumeralMap.put("M", 1000);
        String[] array = s.split("");
        int num = 0;
        int prevPointer = 0;
        int prevValue;
        while(prevPointer < array.length-1) {
//            int currentPointer = i;
            if (romanNumeralMap.get(array[prevPointer+1]) > romanNumeralMap.get(array[prevPointer])) {
                num -= romanNumeralMap.get(array[prevPointer]);
                prevValue = romanNumeralMap.get(array[prevPointer]);
            } else if (romanNumeralMap.get(array[prevPointer]) >= romanNumeralMap.get(array[prevPointer+1])) {
                prevValue = romanNumeralMap.get(array[prevPointer]);
                num += romanNumeralMap.get(array[prevPointer]);
            }
            prevPointer++;
        }
        num += romanNumeralMap.get(array[array.length-1]);
        return num;
    }
}

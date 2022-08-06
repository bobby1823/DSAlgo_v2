package io.ghost.datastructure.arraystring;

/**
 * maximize your profit by choosing a single day to buy one stock
 * and choosing a different day in the future to sell that stock.
 */
public class StockBuySellPart1 {

    // This problem can be solved by brute force method. But Time complexity will be o(n*2)
    // But using space we can solve this using only O(n). Creating one auxiliary array taking extra O(n) space
    public static void main(String[] args) {
        int[] price = {7,1,5,3,6,4};
        System.out.println("Maximum price gain: " + fetchMaxPriceGain(price));
    }

    // Space complexity: O(n)
    // Time Complexity: O(n)
    // FInding the maximum Selling Price against each element. Then comparing from each day buying price..
    // Note: Here we are using space complexity O(n), and with the help of an auxilary array we are taking into account of future values of max
    private static int fetchMaxPriceGain(int[] price) {
        int diff = 0;
        int[] aux = new int[price.length];
        aux[price.length-1] = price[price.length-1];
        for (int i = price.length-1; i > 0; i--) {
            if (aux[i] > price[i-1]) {
                aux[i-1] = aux[i];
            } else {
                aux[i-1] = price[i-1];
            }
        }
        for (int i = 0; i < price.length; i++) {
            if ((aux[i]-price[i]) > diff) {
                diff = aux[i]-price[i];
            }
        }
        return diff;
    }

    
    // Best Solution: Space Complexity: O(1)
    //                Time Complexity: O(n)
    // Finding the minimum buying price and comparing with the selling price in each day.
//    private static int fetchMaxPriceGain_v2(int[] price) {
//        int maximumProfit = 0;
////        int[] aux = new int[price.length];
//        for (int i = 0; i < price; i++) {
//
//        }
//        return diff;
//    }
}

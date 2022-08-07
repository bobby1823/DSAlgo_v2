package io.ghost.datastructure;

public class CoinChangeProblemWithoutDP {

    public static void main(String[] args) {
        int[] arr = {7,5,1};
        int money = 18;
        System.out.println("Minimum chances using coins to make money: "+ fetchMinNumberOfCoins(arr, money));
    }

    private static int fetchMinNumberOfCoins(int[] arr, int money) {
        if (money == 0) return 0;

        int y = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if ((money-arr[i]) >= 0) {
                int temp = fetchMinNumberOfCoins(arr, money-arr[i]) + 1;
                if (y > temp ) {
                    y = temp;
                }
            }
        }
        return y;
    }
}

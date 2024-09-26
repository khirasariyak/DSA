/*
* https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
* */

public class BestTimeToBuyAndSellStock {

    public static void main(String[] args) {
        int[] arr = {7, 1, 5, 3, 6, 4};
        int result = maxProfit(arr);
        System.out.println(result);
    }

    private static int maxProfit(int[] arr) {

        int length = arr.length;
        int maxProfit = Integer.MIN_VALUE;
        int buyPrice = arr[0];

        for (int i = 1; i < length; i++) {
            if (arr[i] < buyPrice) {
                buyPrice = arr[i];
            } else {
                maxProfit = Math.max(maxProfit, arr[i] - buyPrice);
            }
        }

        return maxProfit == Integer.MIN_VALUE ? 0 : maxProfit;
    }

}

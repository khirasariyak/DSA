/*
* https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
* */

public class BestTimeToBuyAndSellStock {

    public static void main(String[] args) {
        int[] nums = {7, 1, 5, 3, 6, 4};
        int result = maxProfit(nums);
        System.out.println(result);
    }

    private static int maxProfit(int[] nums) {

        int length = nums.length;
        int maxProfit = Integer.MIN_VALUE;
        int buyPrice = nums[0];

        for (int i = 1; i < length; i++) {
            if (nums[i] < buyPrice) {
                buyPrice = nums[i];
            } else {
                maxProfit = Math.max(maxProfit, nums[i] - buyPrice);
            }
        }

        return maxProfit == Integer.MIN_VALUE ? 0 : maxProfit;
    }

}

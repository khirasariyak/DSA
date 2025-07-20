package DynamicProgramming.KnapsackPattern;

import java.util.Arrays;

/*
* https://www.geeksforgeeks.org/problems/partitions-with-given-difference/1
* */

public class CountNumberOfSubsetSumWithDifferenceK {

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 2, 2, 3, 0, 3, 0, 1};
        int k = 12;
        countNumberOfSubsetSumWithDifferenceK(nums, k);
    }

    private static void countNumberOfSubsetSumWithDifferenceK(int[] nums, int k) {
        int targetSum = (Arrays.stream(nums).sum() + k) / 2;
        System.out.println(countSubsetsBottomUp(nums, targetSum));
    }

    private static int countSubsetsBottomUp(int[] arr, int sum) {

        int[][] dp = new int[arr.length + 1][sum + 1];

        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 0;
        }

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < dp.length; i++) {

            // This will only true for the elements > 0
            // If zero is present in an array, you need to start the inner loop with j = 0
            // In that case, we don't need to initialize dp[i][0] = 1

            for (int j = 1; j < dp[0].length; j++) {

                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - arr[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }

            }
        }

        return dp[arr.length][sum];
    }


}

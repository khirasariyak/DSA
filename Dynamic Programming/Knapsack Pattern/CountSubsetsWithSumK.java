import java.util.Arrays;

/*
* https://www.geeksforgeeks.org/problems/perfect-sum-problem5633/1
* */

public class CountSubsetsWithSumK {

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 4};
        int sum = 5;
        countSubsetsWithSumK(arr, sum);
    }

    private static void countSubsetsWithSumK(int[] arr, int sum) {
        System.out.println("Naive Recursive Result=" + countSubsets(arr, sum, arr.length));
        System.out.println("Memoization Result=" + countSubsetsWithMemoization(arr, sum, arr.length, initializeDP(arr, sum)));
        System.out.println("Bottom Up Result=" + countSubsetsBottomUp(arr, sum));
    }

    private static int countSubsets(int[] arr, int sum, int length) {

        if (sum == 0) {
            return 1;
        }

        if (length == 0) {
            return 0;
        }

        if (arr[length - 1] <= sum) {
            return countSubsets(arr, sum, length - 1) + countSubsets(arr, sum - arr[length - 1], length - 1);
        } else {
            return countSubsets(arr, sum, length - 1);
        }
    }

    private static int[][] initializeDP(int[] arr, int sum) {
        int[][] dp = new int[arr.length + 1][sum + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 0;
        }

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }

        return dp;
    }

    private static int countSubsetsWithMemoization(int[] arr, int sum, int length, int[][] dp) {

        if (sum == 0) {
            return 1;
        }

        if (length == 0) {
            return 0;
        }

        if (dp[length][sum] != -1) {
            return dp[length][sum];
        }

        if (arr[length - 1] <= sum) {
            dp[length][sum] = countSubsetsWithMemoization(arr, sum, length - 1, dp)
                    + countSubsetsWithMemoization(arr, sum - arr[length - 1], length - 1, dp);
        } else {
            dp[length][sum] = countSubsetsWithMemoization(arr, sum, length - 1, dp);
        }

        return dp[length][sum];
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
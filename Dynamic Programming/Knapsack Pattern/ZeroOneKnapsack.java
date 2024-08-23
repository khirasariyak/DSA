import java.util.Arrays;

/*
* https://www.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1
* */

public class ZeroOneKnapsack {

    public static void main(String[] args) {
        int[] weights = {1, 3, 4, 5};
        int[] values = {1, 4, 5, 7};
        int capacity = 7;
        zeroOneKnapsack(weights, values, capacity, weights.length);
    }

    private static void zeroOneKnapsack(int[] weights, int[] values, int capacity, int length) {
        System.out.println("Naive Recursive Result=" + knapsack(weights, values, capacity, length));
        System.out.println("Memoization Result=" + knapsackWithMemoization(weights, values, capacity, length, initializeDP(capacity, length)));
        System.out.println("Bottom Up Result=" + knapsackBottomUp(weights, values, capacity, length));
    }

    private static int knapsack(int[] weights, int[] values, int capacity, int length) {
        if (capacity == 0 || length == 0) {
            return 0;
        }

        if (weights[length - 1] <= capacity) {
            return Math.max(
                    values[length - 1] + knapsack(weights, values, capacity - weights[length - 1], length - 1),
                    knapsack(weights, values, capacity, length - 1)
            );
        } else {
            return knapsack(weights, values, capacity, length - 1);
        }
    }

    private static int[][] initializeDP(int capacity, int length) {
        int[][] dp = new int[length +1][capacity +1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return dp;
    }

    private static int knapsackWithMemoization(int[] weights, int[] values, int capacity, int length, int[][] dp) {

        // Also known as memoization or top-down approach

        if (length == 0 || capacity == 0) {
            return 0;
        }

        if (dp[length][capacity] != -1) {
            return dp[length][capacity];
        }

        if (weights[length - 1] <= capacity) {
            dp[length][capacity] = Math.max(
                    values[length - 1] + knapsackWithMemoization(weights, values, capacity - weights[length - 1], length - 1, dp),
                    knapsackWithMemoization(weights, values, capacity, length - 1, dp)
            );
        } else {
            dp[length][capacity] = knapsackWithMemoization(weights, values, capacity, length - 1, dp);
        }

        return dp[length][capacity];
    }

    private static int knapsackBottomUp(int[] weights, int[] values, int capacity, int length) {

        int[][] dp = new int[length + 1][capacity + 1];

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }

        for (int j = 0; j < dp[0].length; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {

                if (weights[i-1] <= j) {
                    dp[i][j] = Math.max(values[i-1] + dp[i-1][j - weights[i-1]], dp[i-1][j]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }

            }

        }

        return dp[length][capacity];
    }
}

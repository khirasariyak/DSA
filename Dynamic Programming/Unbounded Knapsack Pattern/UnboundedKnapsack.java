import java.util.Arrays;

/*
* https://www.geeksforgeeks.org/problems/knapsack-with-duplicate-items4201/1
* */

public class UnboundedKnapsack {

    public static void main(String[] args) {
        int[] weights = {5, 10, 15};
        int[] values = {10, 30, 20};
        int capacity = 100;
        unboundedKnapsack(weights, values, capacity);
    }

    private static void unboundedKnapsack(int[] weights, int[] values, int capacity) {
        System.out.println("Naive Recursive Result=" + unboundedKnapsack(weights, values, capacity, weights.length));
        System.out.println("Memoization Result=" + unboundedKnapsackWithMemoization(weights, values, capacity, weights.length, initializeDP(weights, capacity)));
        System.out.println("Bottom Up Result=" + unboundedKnapsackBottomUp(weights, values, capacity));
    }

    private static int unboundedKnapsack(int[] weights, int[] values, int capacity, int length) {

        if (length == 0 || capacity == 0) {
            return 0;
        }

        if (weights[length - 1] <= capacity) {
            return Math.max(
                    unboundedKnapsack(weights, values, capacity, length - 1),
                    values[length - 1] + unboundedKnapsack(weights, values, capacity - weights[length - 1], length)
            );
        } else {
            return unboundedKnapsack(weights, values, capacity, length - 1);
        }
    }

    private static int[][] initializeDP(int[] weights, int capacity) {

        int[][] dp = new int[weights.length + 1][capacity + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }

        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 0;
        }

        return dp;
    }

    private static int unboundedKnapsackWithMemoization(int[] weights, int[] values, int capacity, int length, int[][] dp) {

        if (length == 0 || capacity == 0) {
            return 0;
        }

        if (dp[length][capacity] != -1) {
            return dp[length][capacity];
        }

        if (weights[length - 1] <= capacity) {
            return dp[length][capacity] = Math.max(
                    unboundedKnapsackWithMemoization(weights, values, capacity, length - 1, dp),
                    values[length - 1] + unboundedKnapsackWithMemoization(weights, values, capacity - weights[length - 1], length, dp)
            );
        } else {
            return dp[length][capacity] = unboundedKnapsackWithMemoization(weights, values, capacity, length - 1, dp);
        }
    }

    private static int unboundedKnapsackBottomUp(int[] weights, int[] values, int capacity) {

        int[][] dp = new int[weights.length + 1][capacity + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }

        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {

                if (weights[i - 1] <= j) {
                    dp[i][j] = Math.max(
                            dp[i - 1][j],
                            values[i - 1] + dp[i][j - weights[i - 1]]
                    );
                } else {
                    dp[i][j] = dp[i - 1][j];
                }

            }
        }

        return dp[weights.length][capacity];
    }

}

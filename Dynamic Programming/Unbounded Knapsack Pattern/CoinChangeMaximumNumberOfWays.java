import java.util.Arrays;

/*
* https://www.geeksforgeeks.org/problems/coin-change2448/1
* */

public class CoinChangeMaximumNumberOfWays {

    public static void main(String[] args) {
        int[] coins = {1, 2, 3};
        int amount = 5;
        coinChangeMaximumNumberOfWays(coins, amount);
    }

    private static void coinChangeMaximumNumberOfWays(int[] coins, int amount) {
        System.out.println("Naive Recursive Result=" + coinChangeMaximumNumberOfWaysRecursive(coins, amount, coins.length));
        System.out.println("Memoization Result=" + coinChangeWithMemoization(coins, amount, coins.length, initializeDP(coins, amount)));
        System.out.println("Bottom Up Result=" + coinChangeMaximumNumberOfWaysBottomUp(coins, amount));
    }

    private static int coinChangeMaximumNumberOfWaysRecursive(int[] coins, int amount, int length) {

        if (amount == 0) {
            return 1;
        }

        if (length == 0) {
            return 0;
        }

        if(coins[length - 1] <= amount) {
            return coinChangeMaximumNumberOfWaysRecursive(coins, amount - coins[length - 1], length)
                    + coinChangeMaximumNumberOfWaysRecursive(coins, amount, length - 1);
        } else {
            return coinChangeMaximumNumberOfWaysRecursive(coins, amount, length - 1);
        }

    }

    private static int[][] initializeDP(int[] coins, int amount) {

        int[][] dp = new int[coins.length + 1][amount + 1];

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

    private static int coinChangeWithMemoization(int[] coins, int amount, int length, int[][] dp) {

        if (amount == 0) {
            return 1;
        }

        if (length == 0) {
            return 0;
        }

        if (dp[length][amount] != -1) {
            return dp[length][amount];
        }

        if (coins[length - 1] <= amount) {
            dp[length][amount] = coinChangeWithMemoization(coins, amount - coins[length - 1], length, dp)
                                    + coinChangeWithMemoization(coins, amount, length - 1, dp);
        } else {
            dp[length][amount] = coinChangeWithMemoization(coins, amount, length - 1, dp);
        }

        return dp[length][amount];
    }

    private static int coinChangeMaximumNumberOfWaysBottomUp(int[] coins, int amount) {

        int[][] dp = new int[coins.length + 1][amount + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 0;
        }

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {

                if (coins[i - 1] <= j) {
                    dp[i][j] = dp[i][j - coins[i - 1]] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }

            }
        }

        return dp[coins.length][amount];
    }

}

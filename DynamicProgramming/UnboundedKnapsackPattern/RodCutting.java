package DynamicProgramming.UnboundedKnapsackPattern;

import java.util.Arrays;
import java.util.stream.IntStream;

/*
 * https://www.geeksforgeeks.org/problems/rod-cutting0840/1
 * */

public class RodCutting {

    public static void main(String[] args) {
        int[] prices = {1, 5, 8, 9, 10, 17, 17, 20};
        int length = 8;
        rodCutting(prices, length);
    }

    private static void rodCutting(int[] prices, int rodLength) {

        int[] lengths = IntStream.rangeClosed(1, rodLength)
                .toArray();

        System.out.println("Naive Recursive Result=" + rodCuttingRecursive(lengths, prices, rodLength, rodLength));
        System.out.println("Memoization Result=" + rodCuttingWithMemoization(lengths, prices, rodLength, rodLength, initializeDP(prices, rodLength)));
        System.out.println("Bottom Up Result=" + rodCuttingBottomUp(lengths, prices, rodLength));
    }

    private static int rodCuttingRecursive(int[] lengths, int[] prices, int remainingLength, int rodLength) {

        if (remainingLength == 0 || rodLength == 0) {
            return 0;
        }

        if (lengths[remainingLength - 1] <= rodLength) {
            return Math.max(
                prices[remainingLength - 1] + rodCuttingRecursive(lengths, prices, remainingLength, rodLength - lengths[remainingLength - 1]),
                rodCuttingRecursive(lengths, prices, remainingLength - 1, rodLength)
            );
        } else {
            return rodCuttingRecursive(lengths, prices, remainingLength - 1, rodLength);
        }

    }

    private static int[][] initializeDP(int[] prices, int rodLength) {
        int[][] dp = new int[prices.length + 1][rodLength + 1];

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

    private static int rodCuttingWithMemoization(int[] lengths, int[] prices, int remainingLength, int rodLength, int[][] dp) {

        if (remainingLength == 0 || rodLength == 0) {
            return 0;
        }

        if (dp[remainingLength][rodLength] != -1) {
            return dp[remainingLength][rodLength];
        }

        if (lengths[remainingLength - 1] <= rodLength) {
             dp[remainingLength][rodLength] = Math.max(
                prices[remainingLength - 1] + rodCuttingWithMemoization(lengths, prices, remainingLength, rodLength - remainingLength, dp),
                rodCuttingWithMemoization(lengths, prices, remainingLength - 1, rodLength, dp)
            );
        } else {
            dp[remainingLength][rodLength] = rodCuttingWithMemoization(lengths, prices, remainingLength - 1, rodLength, dp);
        }

        return dp[remainingLength][rodLength];
    }

    private static int rodCuttingBottomUp(int[] lengths, int[] prices, int rodLength) {

        int[][] dp = new int[lengths.length + 1][rodLength + 1];

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

                if (lengths[i - 1] <= j) {
                    dp[i][j] = Math.max(
                        prices[i - 1] + dp[i][j - i],
                        dp[i - 1][j]
                    );
                } else {
                    dp[i][j] = dp[i - 1][j];
                }

            }
        }

        return dp[lengths.length][rodLength];
    }

}

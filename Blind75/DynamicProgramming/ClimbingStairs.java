package Blind75.DynamicProgramming;

/*
* https://leetcode.com/problems/climbing-stairs/
* */

public class ClimbingStairs {

    public static void main(String[] args) {
        int n = 5;
        System.out.println(climbStairsIterative(n));
        System.out.println(climbStairsRecursive(n));
    }

    private static int climbStairsIterative(int n) {

        if (n == 1) {
            return 1;
        }

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    private static int climbStairsRecursive(int n) {

            if (n == 1) {
                return 1;
            }

            int[] dp = new int[n + 1];
            dp[0] = 1;
            dp[1] = 1;

            return climbStairsRecursive(n, dp);
    }

    private static int climbStairsRecursive(int n, int[] dp) {

        if (dp[n - 2] == 0) {
            dp[n - 2] = climbStairsRecursive(n - 2, dp);
        }

        if (dp[n - 1] == 0) {
            dp[n - 1] = climbStairsRecursive(n - 1, dp);
        }

        dp[n] = dp[n - 1] + dp[n - 2];
        return dp[n];
    }

}

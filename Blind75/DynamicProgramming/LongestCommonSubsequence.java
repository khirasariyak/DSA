package Blind75.DynamicProgramming;

import java.util.Arrays;

/*
* https://leetcode.com/problems/longest-common-subsequence/
* */

public class LongestCommonSubsequence {

    public static void main(String[] args) {
       String s1 = "abcde";
       String s2 = "ace";
       longestCommonSubsequence(s1, s2);
    }

    private static void longestCommonSubsequence(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        System.out.println("Naive Recursive Result=" + longestCommonSubsequenceRecursive(s1, s2, n, m));
        System.out.println("Memoization Result=" + longestCommonSubsequenceWithMemoization(s1, s2, n, m, initializeDP(n, m)));
        System.out.println("Bottom Up Result=" + longestCommonSubsequenceBottomUp(s1, s2, n, m));
    }

    private static int longestCommonSubsequenceRecursive(String s1, String s2, int n, int m) {

        if (n == 0 || m == 0) {
            return 0;
        }

        if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
            return 1 + longestCommonSubsequenceRecursive(s1, s2, n - 1, m - 1);
        } else {
            return Math.max(
                    longestCommonSubsequenceRecursive(s1, s2, n - 1, m),
                    longestCommonSubsequenceRecursive(s1, s2, n, m - 1)
            );
        }

    }

    private static int[][] initializeDP(int n, int m) {
        int[][] dp = new int[n + 1][m + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return dp;
    }

    private static int longestCommonSubsequenceWithMemoization(String s1, String s2, int n, int m, int[][] dp) {

        if (n == 0 || m == 0) {
            return 0;
        }

        if (dp[n][m] != -1) {
            return dp[n][m];
        }

        if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
            dp[n][m] = 1 + longestCommonSubsequenceWithMemoization(s1, s2, n - 1, m - 1, dp);
        } else {
            dp[n][m] = Math.max(
                    longestCommonSubsequenceWithMemoization(s1, s2, n - 1, m, dp),
                    longestCommonSubsequenceWithMemoization(s1, s2, n, m - 1, dp)
            );
        }

        return dp[n][m];
    }

    private static int longestCommonSubsequenceBottomUp(String s1, String s2, int n, int m) {

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }

        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {

                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }

            }
        }

        return dp[n][m];
    }

}

import java.util.Arrays;

/*
* https://leetcode.com/problems/unique-paths/
* */

public class GridUniquePaths {

    static int[][] dp;

    public static void main(String[] args) {
        int m = 3;
        int n = 7;
        uniquePaths(m, n);
    }

    private static void uniquePaths(int m, int n) {
        System.out.println("Naive Recursive Approach=" + uniquePathsRecursive(m, n, 0, 0));
        System.out.println("Memoization Approach=" + uniquePathsMemoization(m, n));
        System.out.println("Bottom Up Approach=" + uniquePathsBottomUp(m, n));
    }

    private static int uniquePathsRecursive(int m, int n, int i, int j) {

        if (i == (m - 1) && j == (n - 1)) {
            return 1;
        }

        if (i >= m || j >= n) {
            return 0;
        }

        return uniquePathsRecursive(m, n, i + 1, j) + uniquePathsRecursive(m, n, i, j + 1);
    }

    private static int uniquePathsMemoization(int m, int n) {
        dp = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return uniquePathsMemoization(m, n, 0, 0, dp);
    }

    private static int uniquePathsMemoization(int m, int n, int i, int j, int[][] dp) {

        if (i == (m - 1) && j == (n - 1)) {
            return 1;
        }

        if (i >= m || j >= n) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        dp[i][j] = uniquePathsMemoization(m, n, i + 1, j, dp) + uniquePathsMemoization(m, n, i, j + 1, dp);
        return dp[i][j];
    }

    private static int uniquePathsBottomUp(int m, int n) {

        dp = new int[m][n];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        for (int i = 0; i < dp[0].length; i++) {
            dp[m - 1][i] = 1;
        }

        for (int i = 0; i < dp.length; i++) {
            dp[i][n - 1] = 1;
        }

        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
            }
        }

        return dp[0][0];
    }

}

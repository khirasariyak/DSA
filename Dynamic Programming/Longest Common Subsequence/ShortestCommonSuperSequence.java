/*
* https://www.geeksforgeeks.org/problems/shortest-common-supersequence0322/1
* */

public class ShortestCommonSuperSequence {

    public static void main(String[] args) {
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";
        shortestCommonSuperSequence(s1, s2);
    }

    private static void shortestCommonSuperSequence(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        System.out.println("Bottom Up Result==" + shortestCommonSuperSequenceBottomUp(s1, s2, n, m));
    }

    private static int shortestCommonSuperSequenceBottomUp(String s1, String s2, int n, int m) {
        return n + m - longestCommonSubsequence(s1, s2, n, m);
    }

    private static int longestCommonSubsequence(String s1, String s2, int n, int m) {

        int[][] dp = new int[n + 1][m + 1];

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

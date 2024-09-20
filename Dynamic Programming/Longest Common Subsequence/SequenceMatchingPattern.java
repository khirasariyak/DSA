/*
* https://leetcode.com/problems/is-subsequence/
* */

public class SequenceMatchingPattern {

    public static void main(String[] args) {
        String s1 = "AXY";
        String s2 = "ADXCPY";
        isSubsequence(s1, s2);
    }

    private static void isSubsequence(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        System.out.println("isSubsequence=" + isSubsequence(s1, s2, n, m));
    }

    private static boolean isSubsequence(String s1, String s2, int n, int m) {
        return s1.length() == longestCommonSubsequence(s1, s2, n, m);
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

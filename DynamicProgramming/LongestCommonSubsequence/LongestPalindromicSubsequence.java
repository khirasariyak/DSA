package DynamicProgramming.LongestCommonSubsequence;

/*
* https://www.geeksforgeeks.org/problems/longest-palindromic-subsequence-1612327878/1
* */

public class LongestPalindromicSubsequence {

    public static void main(String[] args) {
        String s1 = "agbcba";
        System.out.println("Bottom Up Result=" + longestPalindromicSubsequenceBottomUp(s1));
    }

    private static int longestPalindromicSubsequenceBottomUp(String s1) {
        int n = s1.length();
        return longestCommonSubsequence(s1, new StringBuilder(s1).reverse().toString(), n, n);
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

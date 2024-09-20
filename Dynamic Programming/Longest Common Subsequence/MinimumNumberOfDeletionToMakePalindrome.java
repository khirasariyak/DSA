/*
* https://www.geeksforgeeks.org/problems/minimum-number-of-deletions4610/1
* */

public class MinimumNumberOfDeletionToMakePalindrome {

    public static void main(String[] args) {
        String s1 = "aebcbda";
        minimumNumberOfDeletionToMakePalindrome(s1);
    }

    private static void minimumNumberOfDeletionToMakePalindrome(String s1) {
        int n = s1.length();
        System.out.println("Bottom Up Result=" + minimumNumberOfDeletionToMakePalindromeBottomUp(s1, n));
    }

    private static int minimumNumberOfDeletionToMakePalindromeBottomUp(String s1, int n) {
        return n - longestPalindromicSubsequence(s1, n);
    }
    
    private static int longestPalindromicSubsequence(String s, int n) {
        return longestCommonSubsequence(s, new StringBuilder(s).reverse().toString(), n, n);
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

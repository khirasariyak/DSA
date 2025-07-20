package DynamicProgramming.LongestCommonSubsequence;

/*
* Number of insertion and deletion will be same to make a string palindrome
*
* https://www.geeksforgeeks.org/problems/minimum-number-of-deletions4610/1
* */

public class MinimumNumberOfInsertionToMakePalindrome {

    public static void main(String[] args) {
        String s1 = "aebcbda";
        System.out.println(minimumNumberOfInsertionToMakePalindrome(s1));
    }

    private static int minimumNumberOfInsertionToMakePalindrome(String s1) {
        int n = s1.length();
        return minimumNumberOfInsertionToMakePalindromeBottomUp(s1, n);
    }

    private static int minimumNumberOfInsertionToMakePalindromeBottomUp(String s1, int n) {
        return n - longestPalindomicSubsequence(s1, n);
    }

    private static int longestPalindomicSubsequence(String s1, int n) {
        return longestCommonSubsequence(s1, new StringBuilder(s1).reverse().toString(), n, n);
    }

    private static int longestCommonSubsequence(String s1, String s2, int n, int m) {

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {

                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }

            }
        }

        return dp[n][m];
    }

}

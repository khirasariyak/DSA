package DynamicProgramming.LongestCommonSubsequence;

/*
* https://www.geeksforgeeks.org/problems/minimum-number-of-deletions-and-insertions0209/1
* */

public class MinimumNumberOfInsertionAndDeletion {

    public static void main(String[] args) {
        String s1 = "heap";
        String s2 = "pea";
        minimumNumberOfInsertionAndDeletion(s1, s2);
    }

    private static void minimumNumberOfInsertionAndDeletion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        System.out.println("Bottom Up Result==" + minimumNumberOfInsertionAndDeletionBottomUp(s1, s2, n, m));
    }

    private static int minimumNumberOfInsertionAndDeletionBottomUp(String s1, String s2, int n, int m) {
        int lcs = longestCommonSubsequenceBottomUp(s1, s2, n, m);
        return (n - lcs) + (m - lcs);
    }

    private static int longestCommonSubsequenceBottomUp(String s1, String s2, int n, int m) {

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

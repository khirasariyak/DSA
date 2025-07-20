package DynamicProgramming.LongestCommonSubsequence;

/*
* https://leetcode.com/problems/longest-common-subsequence/description/
* */

public class PrintLongestCommonSubsequence {

    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "abce";
        printLongestCommonSubsequence(s1, s2);
    }

    private static void printLongestCommonSubsequence(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        System.out.println("Naive Recursion Result=" + printLongestCommonSubsequenceRecursive(s1, s2, n, m));
        System.out.println("Memoization Result=" + printLongestCommonSubsequenceWithMemoization(s1, s2, n, m, new String[n + 1][m + 1]));
        System.out.println("Bottom Up Result=" + printLongestCommonSubsequenceBottomUp(s1, s2, n, m));
    }

    private static String printLongestCommonSubsequenceRecursive(String s1, String s2, int n, int m) {

        if (n == 0 || m == 0) {
            return "";
        }

        if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
            return printLongestCommonSubsequenceRecursive(s1, s2, n - 1, m - 1) + s1.charAt(n - 1);
        } else {
            String lcs1 = printLongestCommonSubsequenceRecursive(s1, s2, n - 1, m);
            String lcs2 = printLongestCommonSubsequenceRecursive(s1, s2, n, m - 1);

            return lcs1.length() > lcs2.length() ? lcs1 : lcs2;
        }
    }

    private static String printLongestCommonSubsequenceWithMemoization(String s1, String s2, int n, int m, String[][] dp) {

        if (n == 0 || m == 0) {
            return "";
        }

        if (dp[n][m] != null) {
            return dp[n][m];
        }

        if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
            dp[n][m] = printLongestCommonSubsequenceRecursive(s1, s2, n - 1, m - 1) + s1.charAt(n - 1);
        } else {
            String lcs1 = printLongestCommonSubsequenceRecursive(s1, s2, n - 1, m);
            String lcs2 = printLongestCommonSubsequenceRecursive(s1, s2, n, m - 1);

            dp[n][m] = lcs1.length() > lcs2.length() ? lcs1 : lcs2;
        }

        return dp[n][m];
    }

    private static String printLongestCommonSubsequenceBottomUp(String s1, String s2, int n, int m) {

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

        int i = n;
        int j = m;
        StringBuilder sb = new StringBuilder();

        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                sb.append(s1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }

        return sb.reverse().toString();
    }

}

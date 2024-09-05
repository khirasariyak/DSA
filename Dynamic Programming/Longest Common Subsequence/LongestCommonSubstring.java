import java.util.Arrays;

/*
* https://www.geeksforgeeks.org/problems/longest-common-substring1452/1
* */

public class LongestCommonSubstring {

    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "abce";
        longestCommonSubstring(s1, s2);
    }

    private static void longestCommonSubstring(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        System.out.println("Naive Recursion Result=" + longestCommonSubstringRecursive(s1, s2, n, m, 0));
        System.out.println("Bottom Up Result=" + longestCommonSubsequenceBottomUp(s1, s2, n, m));
    }

    private static int longestCommonSubstringRecursive(String s1, String s2, int n, int m, int count) {

        if (n == 0 || m == 0) {
            return count;
        }

        if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
            count = longestCommonSubstringRecursive(s1, s2, n - 1, m - 1, count + 1);
        }

        count = Math.max(count, Math.max(
                longestCommonSubstringRecursive(s1, s2, n - 1, m, 0),
                longestCommonSubstringRecursive(s1, s2, n, m - 1, 0)
        ));

        return count;
    }

    private static int longestCommonSubsequenceBottomUp(String s1, String s2, int n, int m) {

        int[][] dp = new int[n + 1][m + 1];

        // We should not initialize with -1 as we are doing addition on them so

        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 0;
        }

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }

        int max = 0;

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {

                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    max = Math.max(max, dp[i][j]);
                }

            }
        }

        return max;
    }

}

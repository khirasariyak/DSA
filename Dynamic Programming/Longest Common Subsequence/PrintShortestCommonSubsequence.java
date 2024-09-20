/*
* https://leetcode.com/problems/shortest-common-supersequence/
* */

public class PrintShortestCommonSubsequence {

    public static void main(String[] args) {
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";
        printShortestCommonSuperSequence(s1, s2);
    }

    private static void printShortestCommonSuperSequence(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        System.out.println(printShortestCommonSuperSequenceBottomUp(s1, s2, n, m));
    }

    private static String printShortestCommonSuperSequenceBottomUp(String s1, String s2, int n, int m) {

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

        int i = n;
        int j = m;
        StringBuilder sb = new StringBuilder();

        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                sb.append(s1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                sb.append(s1.charAt(i - 1));
                i--;
            } else {
                sb.append(s2.charAt(j - 1));
                j--;
            }
        }

        while (i > 0) {
            sb.append(s1.charAt(i - 1));
            i--;
        }

        while (j > 0) {
            sb.append(s2.charAt(j - 1));
            j--;
        }

        return sb.reverse().toString();
    }

}

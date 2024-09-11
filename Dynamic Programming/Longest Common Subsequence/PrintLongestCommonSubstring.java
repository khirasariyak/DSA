public class PrintLongestCommonSubstring {

    public static void main(String[] args) {
        String s1 = "abcdef";
        String s2 = "abcd";
        printLongestCommonSubstring(s1, s2);
    }

    private static void printLongestCommonSubstring(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        System.out.println("Naive Recursion Result=" + reverseString(printLongestCommonSubstringRecursive(s1, s2, n, m, "")));
        System.out.println("Bottom Up Result=" + printLongestCommonSubstringBottomUp(s1, s2, n, m));
    }

    private static String printLongestCommonSubstringRecursive(String s1, String s2, int n, int m, String s) {

        if (n == 0 || m == 0) {
            return s;
        }

        if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
            s = printLongestCommonSubstringRecursive(s1, s2, n - 1, m - 1, s + s1.charAt(n - 1));
        }

        String lcs1 = printLongestCommonSubstringRecursive(s1, s2, n - 1, m, "");
        String lcs2 = printLongestCommonSubstringRecursive(s1, s2, n, m - 1, "");

        String childMaxLCS = lcs1.length() > lcs2.length() ? lcs1 : lcs2;

        return s.length() > childMaxLCS.length() ? s : childMaxLCS;
    }

    private static String printLongestCommonSubstringBottomUp(String s1, String s2, int n, int m) {

        int[][] dp = new int[n + 1][m + 1];
        int max = Integer.MIN_VALUE;
        int endIndex = 0;

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {

                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];

                    if (dp[i][j] > max) {
                        max = dp[i][j];
                        endIndex = i;
                    }
                }

            }
        }

        // If we assign endIndex = j, then we have to substring from s2 string.
        return s1.substring(endIndex - max, endIndex);
    }

    private static String reverseString(String str) {
        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString();
    }

}

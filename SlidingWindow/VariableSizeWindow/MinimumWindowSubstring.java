package SlidingWindow.VariableSizeWindow;

/*
 * https://leetcode.com/problems/minimum-window-substring/
 * */

public class MinimumWindowSubstring {

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minimumWindowSubstring(s, t));
    }

    public static String minimumWindowSubstring(String s, String t) {

        int left = 0;
        int right = 0;
        int count = 0;
        int m = s.length();
        int n = t.length();
        int startIndex = -1;
        int[] hash = new int[128];
        int minLength = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            hash[t.charAt(i)]++;
        }

        while (right < m) {

            if (hash[s.charAt(right)] > 0) {
                count++;
            }
            hash[s.charAt(right)]--;

            while (count == n) {

                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    startIndex = left;
                }

                hash[s.charAt(left)]++;
                if (hash[s.charAt(left)] > 0) {
                    count--;
                }

                left++;
            }
            right++;
        }

        return startIndex == -1 ? "" : s.substring(startIndex, startIndex + minLength);
    }

}

package Backtracking;

/*
* https://www.geeksforgeeks.org/problems/largest-number-in-k-swaps-1587115620/1
* */

public class LargestNumberInKSwaps {

    public static void main(String[] args) {
        String s = "1234567";
        StringBuilder result = new StringBuilder(s);
        int k = 4;
        findMaximumNum(s, result, k, 0);
        System.out.println(result);
    }

    private static void findMaximumNum(String s, StringBuilder result, int k, int index) {

        if (k == 0 || index == result.length() - 1) {
            return;
        }

        int max = getMax(result, index);

        for (int i = index + 1; i < result.length(); i++) {
            if (result.charAt(i) != result.charAt(index) && result.charAt(i) == max) {
                swap(result, index, i);
                if (result.toString().compareTo(s) > 0) {
                    s = result.toString();
                }
                findMaximumNum(s, result, k - 1, index + 1);
                swap(result, index, i);
            }
        }

        findMaximumNum(s, result, k, index + 1);
    }

    private static int getMax(StringBuilder s, int index) {
        int max = Integer.MIN_VALUE;
        for (int i = index + 1; i < s.length(); i++) {
            if ((int) s.charAt(i) > max) {
                max = s.charAt(i);
            }
        }
        return max;
    }

    private static void swap(StringBuilder s, int i, int j) {
        char c = s.charAt(i);
        s.setCharAt(i, s.charAt(j));
        s.setCharAt(j, c);
    }

}

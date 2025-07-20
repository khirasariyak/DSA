package Blind75.BitManipulation;

import java.util.Arrays;

/*
* https://leetcode.com/problems/counting-bits/
* */

public class CountingBits {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(countBits(5)));
    }

    private static int[] countBits(int n) {
        int[] result = new int[n + 1];
        result[0] = 0;

        for (int i = 1; i < result.length; i++) {
            if (i % 2 == 0) {
                result[i] = result[i / 2];
            } else {
                result[i] = 1 + result[i / 2];
            }
        }
        return result;
    }

}

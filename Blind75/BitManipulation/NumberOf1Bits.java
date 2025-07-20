package Blind75.BitManipulation;

/*
* https://leetcode.com/problems/number-of-1-bits/
* */

public class NumberOf1Bits {

    public static void main(String[] args) {
        System.out.println(hammingWeight(128));
    }

    public static int hammingWeight(int n) {
        
        int count = 0;
        while (n != 0) {
            count += n % 2;
            n = n >> 1;
        }
        return count;
    }

}

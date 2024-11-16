/*
* https://leetcode.com/problems/missing-number/
* */

import java.util.Arrays;
import java.util.stream.IntStream;

public class MissingNumber {

    public static void main(String[] args) {
        int[] nums = {3, 0, 1};
        System.out.println(missingNumber(nums));
    }

    private static int missingNumber(int[] nums) {

        // int sum = Arrays.stream(nums).sum();
        // return (nums.length * (nums.length + 1) / 2) - sum;

        int numsXOR = IntStream.of(nums).reduce(0, (a, b) -> a ^ b);
        int rangeXOR = IntStream.range(0, nums.length + 1).reduce(0, (a, b) -> a ^ b);
        return numsXOR ^ rangeXOR;
    }

}

/*
* https://leetcode.com/problems/missing-number/
* */

import java.util.stream.IntStream;

public class MissingNumber {

    public static void main(String[] args) {
        int[] nums = {3, 0, 1};
        System.out.println(missingNumber(nums));
        System.out.println(missingNumberWithCyclicSort(nums));
    }

    private static int missingNumber(int[] nums) {

        // int sum = Arrays.stream(nums).sum();
        // return (nums.length * (nums.length + 1) / 2) - sum;

        int numsXOR = IntStream.of(nums).reduce(0, (a, b) -> a ^ b);
        int rangeXOR = IntStream.range(0, nums.length + 1).reduce(0, (a, b) -> a ^ b);
        return numsXOR ^ rangeXOR;
    }

    public static int missingNumberWithCyclicSort(int[] nums) {

        int i = 0;

        while (i < nums.length) {
            if (nums[i] != i) {
                int correctIndex = nums[i];
                if (correctIndex >= nums.length) {
                    i++;
                } else {
                    swap(nums, i, correctIndex);
                }
            }
        }

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j) {
                return j;
            }
        }

        return 0;
    }

    public static void swap(int[] nums, int first, int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }

}

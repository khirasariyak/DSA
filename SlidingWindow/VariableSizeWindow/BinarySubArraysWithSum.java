package SlidingWindow.VariableSizeWindow;

/*
* https://leetcode.com/problems/binary-subarrays-with-sum/
* */

public class BinarySubArraysWithSum {

    public static void main(String[] args) {
        System.out.println(numSubarraysWithSum(new int[] {1, 0, 1, 0, 1}, 2));
    }

    public static int numSubarraysWithSum(int[] nums, int goal) {
        return atMost(nums, goal) - atMost(nums, goal - 1);
    }

    public static int atMost(int[] nums, int goal) {

        if (goal < 0) {
            return 0;
        }

        int left = 0;
        int right = 0;
        int sum = 0;
        int count = 0;

        while (right < nums.length) {

            sum += nums[right];

            while (sum > goal) {
                sum -= nums[left];
                left++;
            }

            count += right - left + 1;
            right++;
        }

        return count;
    }

}

package SlidingWindow.VariableSizeWindow;

/*
* https://leetcode.com/problems/count-number-of-nice-subarrays/
* */

public class CountNumberOfNiceSubArrays {

    public int numberOfSubarrays(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    public int atMost(int[] nums, int k) {

        int sum = 0;
        int left = 0;
        int right = 0;
        int count = 0;

        while (right < nums.length) {

            sum += (nums[right] % 2);

            while (sum > k) {
                sum -= (nums[left] % 2);
                left++;
            }

            count += right - left + 1;
            right++;
        }

        return count;
    }

}

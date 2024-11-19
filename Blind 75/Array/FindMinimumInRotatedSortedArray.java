/*
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 * */

public class FindMinimumInRotatedSortedArray {

    public static void main(String[] args) {
        int[] nums = {2, 3, 4, 5, 1};
        System.out.println(findMin(nums));
    }

    private static int findMin(int[] nums) {

        int left = 0;
        int right = nums.length - 1;
        int ans = Integer.MAX_VALUE;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[left] <= nums[right]) {
                ans = Math.min(ans, nums[left]);
                break;
            }

            if (nums[left] <= nums[mid]) {
                ans = Math.min(ans, nums[left]);
                left = mid + 1;
            } else {
                ans = Math.min(ans, nums[right]);
                right = mid;
            }
        }

        return ans;
    }
}

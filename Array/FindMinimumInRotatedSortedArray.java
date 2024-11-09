/*
* https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
* */

public class FindMinimumInRotatedSortedArray {

    public static void main(String[] args) {
        int[] nums = {3, 4, 5, 1, 2};
        System.out.println(findMin(nums));
    }

    private static int findMin(int[] nums) {

        int left = 0;
        int right = nums.length - 1;
        int min = Integer.MAX_VALUE;

        while (left <= right) {
            int mid = left + right / 2;

            if (nums[left] <= nums[right]) {
                min = Math.min(min, nums[left]);
                break;
            }

            if (nums[left] <= nums[mid]) {
                min = Math.min(min, nums[left]);
                left = mid + 1;
            } else {
                min = Math.min(min, nums[mid]);
                right = mid - 1;
            }

        }

        return min;
    }

}

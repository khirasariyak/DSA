/*
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 * */

public class FindMinimumInRotatedSortedArray {

    public static void main(String[] args) {
        int[] nums = {2, 3, 4, 5, 1};
        System.out.println(findMin(nums));
    }

    private static int findMin(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        int start = 0;
        int end = nums.length - 1;

        while (start < end) {

            int mid = (start + end) / 2;

            if (mid > 0 && nums[mid] < nums[mid - 1]) {
                return nums[mid];
            }

            if (nums[start] <= nums[mid] && nums[mid] > nums[end]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }

        }
        
        return nums[start];
    }

}

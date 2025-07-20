package Blind75.Array;

/*
* https://leetcode.com/problems/search-in-rotated-sorted-array/
* */

public class SearchInRotatedSortedArray {

    public static void main(String[] args) {
        int[] nums = {1, 3, 5};
        int target = 3;
        System.out.println(search(nums, target));
    }

    private static int search(int[] nums, int target) {

        int n = nums.length;
        int left = 0;
        int right = n - 1;

        while (left <= right) {

            int mid = (left + right) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[left] <= nums[mid]) {
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

        }

        return -1;
    }

}

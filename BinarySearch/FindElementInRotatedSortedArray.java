package BinarySearch;

/*
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 * */

public class FindElementInRotatedSortedArray {

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 3;
        System.out.println(findElementBruteForce(nums, target));
        System.out.println(findElement(nums, target));
    }

    private static int findElementBruteForce(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }

        return -1;
    }

    private static int findElement(int[] nums, int target) {

        int mid;
        int left = 0;
        int index = -1;
        int right = nums.length - 1;

        while (left <= right) {

            mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                index = mid;
                break;
            }

            if (nums[left] <= nums[mid]) {
                // left half is sorted
                // we are not checking <= for mid as we already have checked for mid
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }

            } else {
                // right half is sorted
                // we are not checking <= for mid as we already have checked for mid
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }

            }

        }

        return index;
    }

}

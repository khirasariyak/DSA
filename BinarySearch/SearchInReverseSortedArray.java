package BinarySearch;

/*
* https://www.geeksforgeeks.org/search-an-element-in-a-reverse-sorted-array/
* */

public class SearchInReverseSortedArray {

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 1, 0, -1, -2, -3, -4};
        int target = -3;
        System.out.println(searchInReverseSortedArray(nums, target));
    }

    private static int searchInReverseSortedArray(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return -1;
        }

        int mid;
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {

            mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] < target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }

}

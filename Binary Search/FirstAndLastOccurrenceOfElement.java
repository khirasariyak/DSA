package BinarySearch;

import java.util.Arrays;

/*
* https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
* */

public class FirstAndLastOccurrenceOfElement {

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 5, 5, 5, 67, 123, 125};
        int target = 5;
        System.out.println(Arrays.toString(firstAndLastOccurrenceOfElement(nums, target)));
    }

    private static int[] firstAndLastOccurrenceOfElement(int[] nums, int target) {
        int[] result = {-1, -1};

        if (nums == null || nums.length == 0) {
            return result;
        }

        result[0] = firstOccurrence(nums, target);

        if (result[0] != -1) {
            result[1] = lastOccurrence(nums, target);
        }

        return result;
    }

    private static int lastOccurrence(int[] nums, int target) {

        int mid;
        int left = 0;
        int result = -1;
        int right = nums.length - 1;

        while (left <= right) {

            mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                result = mid;
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    private static int firstOccurrence(int[] nums, int target) {

        int mid;
        int left = 0;
        int result = -1;
        int right = nums.length - 1;

        while (left <= right) {

            mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                result = mid;
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

}

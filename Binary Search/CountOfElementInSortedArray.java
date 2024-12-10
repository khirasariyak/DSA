package BinarySearch;

/*
* https://www.geeksforgeeks.org/problems/number-of-occurrence2259/1
* */

public class CountOfElementInSortedArray {

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 5, 5, 5, 67, 123, 125};
        int target = 5;
        System.out.println(countOfElementInSortedArray(nums, target));
    }

    private static int countOfElementInSortedArray(int[] nums, int target) {

        int firstOccurrence = firstOccurrence(nums, target);
        if (firstOccurrence == -1) {
            return 0;
        }

        int lastOccurrence = lastOccurrence(nums, target);
        return lastOccurrence - firstOccurrence + 1;
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

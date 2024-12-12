/*
* https://www.geeksforgeeks.org/find-element-bitonic-array/
* */

public class SearchInBitonicArray {

    public static void main(String[] args) {
        int[] nums = {1, 3, 8, 12, 4, 2};
        int target = 2;
        System.out.println(searchInBitonicArray(nums, target));
    }

    private static int searchInBitonicArray(int[] nums, int target) {

        int peakElementIndex = findPeakElement(nums);
        int index1 = findElementInAscendingArray(nums, target, peakElementIndex);

        if (index1 != -1) {
            return index1;
        }

        return findElementInDescendingArray(nums, target, peakElementIndex);
    }

    private static int findElementInDescendingArray(int[] nums, int target, int peakElementIndex) {

        int mid;
        int left = peakElementIndex;
        int right = nums.length - 1;

        while (left <= right) {

            mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] < target) {
                right = mid -1;
            } else {
                left = mid + 1;
            }

        }

        return -1;
    }

    private static int findElementInAscendingArray(int[] nums, int target, int peakElementIndex) {

        int mid;
        int left = 0;
        int right = peakElementIndex - 1;

        while (left <= right) {

            mid = left + (right - left) / 2;

            if(nums[mid] == target) {
                return mid;
            }

            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }

        return -1;
    }

    private static int findPeakElement(int[] nums) {

        int length = nums.length;

        if (length == 1) {
            return 0;
        }

        if (nums[0] > nums[1]) {
            return 0;
        }

        if (nums[length - 1] > nums[length - 2]) {
            return length - 1;
        }

        int mid;
        int left = 0;
        int right = length - 2;

        while (left <= right) {

            mid = left + (right - left) / 2;

            if (nums[mid] > nums[mid + 1] && nums[mid] > nums[mid - 1]) {
                return mid;
            }

            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }

        return -1;
    }

}

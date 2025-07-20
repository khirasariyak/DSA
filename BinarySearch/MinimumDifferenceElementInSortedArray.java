package BinarySearch;

/*
* Not found
* */

public class MinimumDifferenceElementInSortedArray {

    public static void main(String[] args) {
        int[] nums = {4, 6, 10};
        int target = 7;
        System.out.println(minimumDifferenceElementInSortedArray(nums, target));
    }

    private static int minimumDifferenceElementInSortedArray(int[] nums, int target) {

        int mid;
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {

            mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return nums[mid];
            }

            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }

        int closest = Integer.MAX_VALUE;

        if (left < nums.length) {
            closest = nums[left];
        }

        if (right >= 0 && Math.abs(nums[right] - target) < Math.abs(closest - target)) {
            closest = nums[right];
        }

        return closest;
    }

}

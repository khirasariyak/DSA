/*
* https://leetcode.com/problems/find-peak-element/
* */

public class PeakElement {

    // Maximun element from bitonic array (same problem)
    
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println(findPeakElementBruteForce(nums));
        System.out.println(findPeakElement(nums));
    }

    private static int findPeakElementBruteForce(int[] nums) {

        int length = nums.length;

        for (int i = 0; i < length; i++) {
            boolean left = true;
            boolean right = true;

            if (i > 0 && nums[i] <= nums[i - 1]) {
                left = false;
            }

            if (i < length - 1 && nums[i] <= nums[i + 1]) {
                right = false;
            }

            if (left && right) {
                return i;
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

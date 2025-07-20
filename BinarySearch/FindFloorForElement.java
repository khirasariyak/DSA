package BinarySearch;

/*
* https://www.geeksforgeeks.org/problems/floor-in-a-sorted-array-1587115620/1
* */

public class FindFloorForElement {

    public static void main(String[] args) {
        int[] nums = {1, 2, 8, 10, 10, 12, 19};
        int target = 5;
        System.out.println(findFloorForElementBruteForce(nums, target));
        System.out.println(findFloorForElement(nums, target));
    }

    private static int findFloorForElementBruteForce(int[] nums, int target) {

        int index = -1;
        int smallerLarge = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= target) {
                if (nums[i] > smallerLarge) {
                    smallerLarge = nums[i];
                    index = i;
                }
            }
        }

        return index;
    }

    private static int findFloorForElement(int[] nums, int target) {

        int mid;
        int left = 0;
        int index = -1;
        int right = nums.length - 1;

        while (left <= right) {

            mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] < target) {
                index = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }

        return index;
    }

}

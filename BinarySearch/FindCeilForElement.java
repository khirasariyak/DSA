package BinarySearch;

/*
* https://www.geeksforgeeks.org/ceiling-in-a-sorted-array
* */

public class FindCeilForElement {

    public static void main(String[] args) {
        int[] nums = {1, 2, 8, 10, 10, 12, 19};
        int target = 5;
        System.out.println(findCeilForElementBruteForce(nums, target));
        System.out.println(findCeilForElement(nums, target));
    }

    private static int findCeilForElementBruteForce(int[] nums, int target) {

        int index = -1;
        int largerSmall = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                if (nums[i] < largerSmall) {
                    largerSmall = nums[i];
                    index = i;
                }
            }
        }

        return index;
    }

    private static int findCeilForElement(int[] nums, int target) {

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
                left = mid + 1;
            } else {
                index = mid;
                right = mid - 1;
            }

        }

        return index;
    }

}

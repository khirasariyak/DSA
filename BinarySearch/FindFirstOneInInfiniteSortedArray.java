package BinarySearch;

/*
* Not possible on any platform. Just for F2F interview.
* */

public class FindFirstOneInInfiniteSortedArray {

    public static void main(String[] args) {
        int[] nums = {0, 0, 0, 1, 1, 1, 1, 1, 1, 1};
        System.out.println(findFirstOneInInfiniteSortedArray(nums));
    }

    private static int findFirstOneInInfiniteSortedArray(int[] nums) {

        int left = 0;
        int right = 1;

        while (nums[right] < 1) {
            left = right;
            right = right * 2;
        }

        return getFirstOccurrence(nums, left, right, 1);
    }

    private static int getFirstOccurrence(int[] nums, int left, int right, int target) {

        int mid;
        int index = -1;

        while (left <= right) {

            mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                index = mid;
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }

        return index;
    }

}

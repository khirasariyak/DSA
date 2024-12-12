/*
* Not possible on any platform. Just for F2F interview.
* */

public class FindPositionOfElementInInfiniteArray {

    public static void main(String[] args) {
        int[] nums = {3, 5, 7, 9, 10, 90, 100, 130, 140, 160, 170};
        int target = 10;
        System.out.println(findPositionOfElementInInfiniteArray(nums, target));
    }

    private static int findPositionOfElementInInfiniteArray(int[] nums, int target) {

        int mid;
        int left = 0;
        int right = 1;

        while (nums[right] < target) {
            left = right;
            right = right * 2;
        }

        while (left <= right) {

            mid = left + (right - left) / 2;

            if (nums[mid] == target) {
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

}

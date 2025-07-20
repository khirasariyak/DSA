package BinarySearch;

public class BinarySearch {

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        int target = 13;
        System.out.println(binarySearch(nums, target));
    }

    private static int binarySearch(int[] nums, int target) {

        int mid;
        int left = 0;
        int right = nums.length - 1;

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

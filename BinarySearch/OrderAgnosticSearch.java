package BinarySearch;

/*
* https://www.geeksforgeeks.org/order-agnostic-binary-search/
* */

public class OrderAgnosticSearch {

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        int target = 13;
        System.out.println(orderAgnosticSearch(nums, target));
    }

    private static int orderAgnosticSearch(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return -1;
        }

        int mid;
        int left = 0;
        int right = nums.length - 1;
        boolean isAscending = nums[left] < nums[right];

        while (left <= right) {

            mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (isAscending) {

                if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }

            } else {

                if (nums[mid] < target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }

            }

        }

        return -1;
    }

}

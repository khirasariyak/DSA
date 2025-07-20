package BinarySearch;

/*
* https://www.educative.io/answers/how-to-search-in-a-nearly-sorted-array
* */

public class SearchInNearlySortedArray {

    public static void main(String[] args) {
        int[] nums = {2, 3, 10, 4, 40};
        int target = 10;
        System.out.println(searchInNearlySortedArrayBruteForce(nums, target));
        System.out.println(searchInNearlySortedArray(nums, target));
    }

    private static int searchInNearlySortedArrayBruteForce(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        
        return -1;
    }

    private static int searchInNearlySortedArray(int[] nums, int target) {

        int mid;
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {

            mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (mid - 1 >= left && nums[mid - 1] == target) {
                return mid - 1;
            }

            if (mid + 1 <= right && nums[mid + 1] == target) {
                return mid + 1;
            }

            if (nums[mid] < target) {
                left = mid + 2;
            } else {
                right = mid - 2;
            }

        }

        return -1;
    }

}

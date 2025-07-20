package BinarySearch.BinarySearchOnAnswer;

/*
* https://www.geeksforgeeks.org/problems/allocate-minimum-number-of-pages0937/1
* */

public class AllocateMinimumNumberOfPages {

    public static void main(String[] args) {
        int[] nums = {12, 34, 67, 90};
        int students = 2;
        System.out.println(allocateMinimumNumberOfPages(nums, students));
    }

    private static int allocateMinimumNumberOfPages(int[] nums, int students) {

        if (nums.length < students) {
            return -1;
        }

        int max = Integer.MIN_VALUE;
        int sum = 0;

        for (int num : nums) {
            max = Math.max(max, num);
            sum += num;
        }

        int mid;
        int left = max;
        int right = sum;
        int result = -1;

        while (left <= right) {

            mid = left + (right - left) / 2;

            if (isValid(nums, students, mid)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }

        return result;
    }

    private static boolean isValid(int[] nums, int students, int mid) {

        int sum = 0;
        int count = 1;

        for (int num : nums) {

            sum += num;

            if (sum > mid) {
                count++;
                sum = num;
            }

            if (count > students) {
                return false;
            }

        }

        return true;
    }
    
}

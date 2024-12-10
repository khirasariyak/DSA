/*
* https://www.geeksforgeeks.org/problems/rotation4723/1
* */

public class NumberOfTimesSortedArrayIsRotated {

    public static void main(String[] args) {
        // index of minimum element
        int[] arr = {11, 12, 15, 18, 2, 5, 6, 8};
        System.out.println(numberOfTimesSortedArrayIsRotatedBruteForce(arr));
        System.out.println(numberOfTimesSortedArrayIsRotated(arr));
    }

    private static int numberOfTimesSortedArrayIsRotatedBruteForce(int[] arr) {

        // Time complexity: O(n)
        // Space complexity: O(1)

        int minElement = Integer.MAX_VALUE;
        int minElementIndex = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < minElement) {
                minElement = arr[i];
                minElementIndex = i;
            }
        }

        return minElementIndex;
    }

    private static int numberOfTimesSortedArrayIsRotated(int[] nums) {

        // Time complexity: O(log n)
        // Space complexity: O(1)

        int mid;
        int left = 0;
        int right = nums.length - 1;
        int ans = Integer.MAX_VALUE;
        int index = -1;

        while (left <= right) {

            mid = left + (right - left) / 2;

            if (nums[left] <= nums[right]) {
                if (nums[left] < ans) {
                    index = left;
                }
                break;
            }

            if (nums[left] <= nums[mid]) {
                if (nums[left] < ans) {
                    ans = nums[left];
                    index = left;
                }
                left = mid + 1;
            } else {
                if (nums[right] < ans) {
                    ans = nums[right];
                    index = right;
                }
                right = mid;
            }

        }

        return index;
    }

}

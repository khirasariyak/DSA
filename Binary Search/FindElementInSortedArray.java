/*
* https://leetcode.com/problems/search-in-rotated-sorted-array/
* */

public class FindElementInSortedArray {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int target = 3;
        System.out.println(findElementBruteForce(arr, target));
        System.out.println(findElement(arr, target));
    }

    private static int findElementBruteForce(int[] arr, int target) {

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }

        return -1;
    }

    private static int findElement(int[] arr, int target) {

        int mid;
        int start = 0;
        int index = -1;
        int end = arr.length - 1;

        while (start <= end) {

            mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                index = mid;
                break;
            }

            if (arr[start] <= arr[mid]) {
                // left half is sorted
                // we are not checking <= for mid as we already have checked for mid
                if (arr[start] <= target && target < arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }

            } else {
                // right half is sorted
                // we are not checking <= for mid as we already have checked for mid
                if (arr[mid] < target && target <= arr[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }

            }

        }

        return index;
    }

}

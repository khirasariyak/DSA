package BinarySearch;

/*
* https://www.geeksforgeeks.org/search-an-element-in-a-reverse-sorted-array/
* */

public class SearchInReverseSortedArray {

    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 1, 0, -1, -2, -3, -4};
        int target = -3;
        System.out.println(searchInReverseSortedArray(arr, target));
    }

    private static int searchInReverseSortedArray(int[] arr, int target) {

        if (arr == null || arr.length == 0) {
            return -1;
        }

        int mid;
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {

            mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            if (arr[mid] < target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }

}

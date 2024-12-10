package BinarySearch;

/*
* https://www.geeksforgeeks.org/problems/number-of-occurrence2259/1
* */

public class CountOfElementInSortedArray {

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 5, 5, 5, 67, 123, 125};
        int target = 5;
        System.out.println(countOfElementInSortedArray(arr, target));
    }

    private static int countOfElementInSortedArray(int[] arr, int target) {

        int firstOccurrence = firstOccurrence(arr, target);
        if (firstOccurrence == -1) {
            return 0;
        }

        int lastOccurrence = lastOccurrence(arr, target);
        return lastOccurrence - firstOccurrence + 1;
    }

    private static int lastOccurrence(int[] arr, int target) {

        int mid;
        int start = 0;
        int result = -1;
        int end = arr.length - 1;

        while (start <= end) {

            mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                result = mid;
                start = mid + 1;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return result;
    }

    private static int firstOccurrence(int[] arr, int target) {

        int mid;
        int start = 0;
        int result = -1;
        int end = arr.length - 1;

        while (start <= end) {

            mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                result = mid;
                end = mid - 1;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return result;
    }

}

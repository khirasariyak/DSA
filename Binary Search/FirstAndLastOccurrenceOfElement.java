package BinarySearch;

import java.util.Arrays;

/*
* https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
* */

public class FirstAndLastOccurrenceOfElement {

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 5, 5, 5, 67, 123, 125};
        int target = 5;
        System.out.println(Arrays.toString(firstAndLastOccurrenceOfElement(arr, target)));
    }

    private static int[] firstAndLastOccurrenceOfElement(int[] arr, int target) {
        int[] result = {-1, -1};

        if (arr == null || arr.length == 0) {
            return result;
        }

        result[0] = firstOccurrence(arr, target);

        if (result[0] != -1) {
            result[1] = lastOccurrence(arr, target);
        }

        return result;
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

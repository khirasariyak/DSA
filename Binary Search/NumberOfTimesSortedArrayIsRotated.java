/*
* https://www.geeksforgeeks.org/problems/rotation4723/1
* */

public class NumberOfTimesSortedArrayIsRotated {

    public static void main(String[] args) {
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

    private static int numberOfTimesSortedArrayIsRotated(int[] arr) {

        // Time complexity: O(log n)
        // Space complexity: O(1)

        int mid;
        int start = 0;
        int end = arr.length - 1;
        int ans = Integer.MAX_VALUE;
        int index = -1;

        while (start <= end) {

            mid = start + (end - start) / 2;

            if (arr[start] <= arr[end]) {
                if (arr[start] < ans) {
                    index = start;
                }
                break;
            }

            if (arr[start] <= arr[mid]) {
                if (arr[start] < ans) {
                    ans = arr[start];
                    index = start;
                }
                start = mid + 1;
            } else {
                if (arr[end] < ans) {
                    ans = arr[end];
                    index = end;
                }
                end = mid;
            }

        }

        return index;
    }

}

package BinarySearch;

/*
* https://www.geeksforgeeks.org/order-agnostic-binary-search/
* */

public class OrderAgnosticSearch {

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        int target = 13;
        System.out.println(orderAgnosticSearch(arr, target));
    }

    private static int orderAgnosticSearch(int[] arr, int target) {

        if (arr == null || arr.length == 0) {
            return -1;
        }

        int mid;
        int start = 0;
        int end = arr.length - 1;
        boolean isAscending = arr[start] < arr[end];

        while (start <= end) {

            mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            if (isAscending) {

                if (arr[mid] < target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }

            } else {

                if (arr[mid] < target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }

            }

        }

        return -1;
    }

}

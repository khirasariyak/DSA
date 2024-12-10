package BinarySearch;

public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        int target = 13;
        System.out.println(binarySearch(arr, target));
    }

    private static int binarySearch(int[] arr, int target) {

        int mid;
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {

            mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }

}

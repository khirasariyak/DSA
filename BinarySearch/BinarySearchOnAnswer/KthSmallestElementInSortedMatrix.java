package BinarySearch.BinarySearchOnAnswer;

/*
* https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/description/
* */

public class KthSmallestElementInSortedMatrix {

    public int kthSmallest(int[][] matrix, int k) {
        int result = -1;
        int n = matrix.length;
        int low = matrix[0][0];
        int high = matrix[n - 1][n - 1];

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int count = countLessEqual(matrix, mid);

            if (count < k) {
                low = mid + 1;
            } else {
                result = mid;
                high = mid - 1;
            }
        }

        return result;
    }

    private int countLessEqual(int[][] matrix, int mid) {
        int n = matrix.length;
        int count = 0;
        for (int[] row : matrix) {
            count += countInRow(row, mid);
        }
        return count;
    }

    private int countInRow(int[] row, int target) {
        int low = 0;
        int high = row.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (row[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }

}

package BinarySearch.BinarySearchOnAnswer;

/*
* https://leetcode.com/problems/search-a-2d-matrix/
* */

public class SearchIn2DMatrix {

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 60}
        };
        int target = 5;
        System.out.println(searchInMatrixBruteForce(matrix, target));
        System.out.println(searchInMatrix(matrix, target));
    }

    private static boolean searchInMatrix(int[][] matrix, int target) {

        int i = 0;
        int n = matrix.length;
        int m = matrix[0].length;
        int j = m - 1;

        while (i >= 0 && i < n && j >= 0 && j < m) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) {
                j--;
            } else {
                i++;
            }
        }

        return false;
    }

    private static boolean searchInMatrixBruteForce(int[][] matrix, int target) {

        for (int[] row : matrix) {
            for (int element : row) {
                if (element == target) {
                    return true;
                }
            }
        }

        return false;
    }

}

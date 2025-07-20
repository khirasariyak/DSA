package Blind75.Matrix;

import java.util.Arrays;

/*
* https://leetcode.com/problems/rotate-image/
* */

public class RotateImage {

    public static void main(String[] args) {
        int[][] matrix = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        rotateImage(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }

    private static void rotateImage(int[][] matrix) {

        int n = matrix.length;
        int temp;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n/2; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = temp;
            }
        }

    }

}

import java.util.Arrays;

/*
* https://www.geeksforgeeks.org/problems/subset-sum-problem-1611555638/1
* */

public class SubSetSum {
    
    public static void main(String[] args) {
        int[] arr = {2, 3, 7, 8, 10};
        int sum = 11;
        subSetSum(arr, sum);
    }

    private static void subSetSum(int[] arr, int sum) {
        System.out.println("Naive Recursive Result=" + isSubSetSum(arr, sum, arr.length));
        System.out.println("Memoization Result=" + isSubSetSumWithMemoization(arr, sum, arr.length, initializeDP(arr, sum)));
        System.out.println("Bottom Up Result=" + isSubSetSumBottomUp(arr, sum));
    }

    private static boolean isSubSetSum(int[] arr, int sum, int length) {
        
        if (sum == 0) {
            return true;
        }
        
        if (length == 0) {
            return false;
        }
        
        if (arr[length - 1] <= sum) {
            return isSubSetSum(arr, sum, length - 1) || isSubSetSum(arr, sum - arr[length - 1], length - 1);
        } else {
            return isSubSetSum(arr, sum, length - 1);
        }

    }
    
    private static int[][] initializeDP(int[] arr, int sum) {
        int[][] dp = new int[arr.length + 1][sum + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 0;
        }

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }

        return dp;
    }

    private static boolean isSubSetSumWithMemoization(int[] arr, int sum, int length, int[][] dp) {

        if (sum == 0) {
            return true;
        }

        if (length == 0) {
            return false;
        }

        if (dp[length][sum] != -1) {
            return dp[length][sum] == 1;
        }

        if (arr[length - 1] <= sum) {
            dp[length][sum] = isSubSetSumWithMemoization(arr, sum, length - 1, dp)
                    || isSubSetSumWithMemoization(arr, sum - arr[length - 1], length - 1, dp) ? 1 : 0;
        } else {
            dp[length][sum] = isSubSetSumWithMemoization(arr, sum, length - 1, dp) ? 1 : 0;
        }

        return dp[length][sum] == 1;
    }

    private static boolean isSubSetSumBottomUp(int[] arr, int sum) {

        int[][] dp = new int[arr.length + 1][sum + 1];

        for (int j = 0; j < dp[0].length; j++) {
            dp[0][j] = 0;
        }

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {

                if (arr[i-1] <= j) {
                    dp[i][j] = dp[i-1][j-arr[i-1]] + dp[i-1][j] >= 1 ? 1 : 0;
                } else {
                    dp[i][j] = dp[i-1][j];
                }

            }
        }

        return dp[arr.length][sum] == 1;
    }
}

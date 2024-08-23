import java.util.Arrays;
import java.util.stream.IntStream;

/*
* https://www.geeksforgeeks.org/problems/minimum-sum-partition3317/1
* */

public class MinimumSubsetSumDifference {

    public static void main(String[] args) {
        int[] nums = {1, 2, 7};
        minimumSubsetSumDifference(nums);
    }

    private static void minimumSubsetSumDifference(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        System.out.println("Naive Recursive Result=" + minimumSubsetSumDifference(nums, sum, 0, nums.length));
        System.out.println("Memoization Result=" + minimumSubsetSumDifferenceWithMemoization(nums, sum, 0, nums.length, initializeDP(nums, sum)));
        System.out.println("Bottom Up Result=" + minimumSubsetSumDifferenceBottomUp(nums, sum));
    }

    private static int minimumSubsetSumDifference(int[] nums, int sum, int sumCalculated, int length) {

        if (length == 0) {
            return Math.abs((sum - sumCalculated) - sumCalculated);
        }

        if (nums[length - 1] <= sum) {
            return Math.min(
                    minimumSubsetSumDifference(nums, sum, sumCalculated, length - 1),
                    minimumSubsetSumDifference(nums, sum, sumCalculated + nums[length - 1], length - 1)
            );
        } else {
            return minimumSubsetSumDifference(nums, sum, sumCalculated, length - 1);
        }

    }

    private static int[][] initializeDP(int[] nums, int sum) {
        int[][] dp = new int[nums.length + 1][sum + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        // We won't update the first row or column as we are storing the actual difference in the dp array
        // Our recursion will handle the base cases when length == 0

        return dp;
    }

    private static int minimumSubsetSumDifferenceWithMemoization(int[] nums, int sum, int sumCalculated, int length, int[][] dp) {

        // sum won't be zero since we have an array of all positive numbers so need to check for sum == 0

        if (length == 0) {
            return Math.abs((sum - sumCalculated) - sumCalculated);
        }

        if (dp[length][sumCalculated] != -1) {
            return dp[length][sumCalculated];
        }

        if (nums[length - 1] <= sum) {
            dp[length][sumCalculated] = Math.min(
                    minimumSubsetSumDifferenceWithMemoization(nums, sum, sumCalculated, length - 1, dp),
                    minimumSubsetSumDifferenceWithMemoization(nums, sum, sumCalculated + nums[length - 1], length - 1, dp)
            );
        } else {
            dp[length][sumCalculated] = minimumSubsetSumDifferenceWithMemoization(nums, sum, sumCalculated, length - 1, dp);
        }

        return dp[length][sumCalculated];
    }

    private static int minimumSubsetSumDifferenceBottomUp(int[] nums, int sum) {

        int[][] dp = new int[nums.length + 1][sum + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 0;
        }

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {

                if (nums[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]] >= 1 ? 1 : 0;
                } else {
                    dp[i][j] = dp[i - 1][j] == 1 ? 1 : 0;
                }

            }
        }

        // Till now, same as subset sum problem

        return IntStream.rangeClosed(0, sum / 2)
                .filter(j -> dp[nums.length][j] == 1)
                .map(j -> Math.abs(sum - 2 * j))
                .min()
                .orElse(Integer.MAX_VALUE);
    }

}

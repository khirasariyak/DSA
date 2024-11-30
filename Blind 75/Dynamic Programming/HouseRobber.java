import java.util.Arrays;

/*
* https://leetcode.com/problems/house-robber/
* */

public class HouseRobber {

    static int[] dp;

    public static void main(String[] args) {
        int[] nums = {2, 7, 9, 3, 1};
        rob(nums);
    }

    private static void rob(int[] nums) {
        System.out.println("Naive Recursive Result=" + robRecursive(nums, nums.length - 1));
        System.out.println("Memoization Result=" + robWithMemoization(nums, nums.length - 1));
        System.out.println("Bottom Up Result=" + robBottomUp(nums));
    }

    private static int robRecursive(int[] nums, int length) {

        if (length < 0) {
            return 0;
        }

        int includeHouse = robRecursive(nums, length - 2) + nums[length];
        int excludeHouse = robRecursive(nums, length - 1);

        return Math.max(includeHouse, excludeHouse);
    }

    private static int robWithMemoization(int[] nums, int length) {
        dp = new int[length + 1];
        Arrays.fill(dp, -1);
        return robWithMemoization(nums, length, dp);
    }

    private static int robWithMemoization(int[] nums, int length, int[] dp) {

        if (length < 0) {
            return 0;
        }

        if (dp[length] != -1) {
            return dp[length];
        }

        int includeHouse = robWithMemoization(nums, length - 2, dp) + nums[length];
        int excludeHouse = robWithMemoization(nums, length - 1, dp);

        dp[length] = Math.max(includeHouse, excludeHouse);
        return dp[length];
    }

    private static int robBottomUp(int[] nums) {

        if (nums.length < 2) {
            return nums[0];
        }

        dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }

        return dp[nums.length - 1];
    }

}

/*
* https://leetcode.com/problems/longest-increasing-subsequence/
* */

public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 2, 3};
        System.out.println(lengthOfLIS(nums));
    }

    private static int lengthOfLIS(int[] nums) {
        return longestIncreasingSubsequence(nums);
    }

    private static int longestIncreasingSubsequence(int[] nums) {

        int[] result = new int[nums.length];

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    // handling the case where longest is already found and we got another subsequence
                    if (1 + result[j] > result[i]) {
                        result[i] = 1 + result[j];
                    }
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int num : result) {
            max = Math.max(max, num);
        }

        return max + 1;
    }

}

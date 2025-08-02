package Greedy;

import java.util.Arrays;

/*
* https://leetcode.com/problems/jump-game-ii/
* */

public class G5_JumpGameII {

    static int minCount = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 1, 4};
        jumpBruteForceEasy(arr, 0, 0);
        System.out.println(minCount);

        System.out.println(jumpBruteForce(arr, 0));

        int[] dp = new int[arr.length];
        Arrays.fill(dp, -1);
        System.out.println(jumpWithMemoization(arr, 0, dp));

        System.out.println(jumpWithBottomUp(arr));

        System.out.println(jumpWithGreedy(arr));
    }

    public static void jumpBruteForceEasy(int[] arr, int index, int count) {

        if (index >= arr.length - 1) {
            minCount = Math.min(minCount, count);
            return;
        }

        if (arr[index] == 0 && index != arr.length - 1) {
            return;
        }

        for (int i = 1; i <= arr[index]; i++) {
            jumpBruteForceEasy(arr, index + i, count + 1);
        }
    }

    // recursion brute force
    // Time Complexity: O(n ^ n)
    // Space Complexity: O(n)
    public static int jumpBruteForce(int[] arr, int index) {

        // No jump needed if we're at or past the last index
        if (index >= arr.length - 1) {
            return 0;
        }

        // Cannot jump anywhere from here
        if (arr[index] == 0) {
            return Integer.MAX_VALUE;
        }

        int minSteps = Integer.MAX_VALUE;

        for (int i = 1; i <= arr[index]; i++) {
            int nextIndex = index + i;
            int result = jumpBruteForce(arr, nextIndex);
            if (result != Integer.MAX_VALUE) {
                minSteps = Math.min(minSteps, 1 + result);
            }
        }

        return minSteps;
    }

    // recursion with memoization
    // Time Complexity: O(n^2)
    // Space Complexity: O(n)
    public static int jumpWithMemoization(int[] arr, int index, int[] dp) {

        if (index >= arr.length - 1) {
            return 0;
        }

        if (arr[index] == 0 && index != arr.length - 1) {
            return Integer.MAX_VALUE;
        }

        if (dp[index] != -1) {
            return dp[index];
        }

        int minCount = Integer.MAX_VALUE;

        for (int i = 1; i <= arr[index]; i++) {
            int c = jumpWithMemoization(arr, index + i, dp);
            if (c != Integer.MAX_VALUE) {
                minCount = Math.min(minCount, c + 1);
            }
        }

        return dp[index] = minCount;
    }

    // bottom up approach
    // Time Complexity: O(n^2)
    // Space Complexity: O(n)
    public static int jumpWithBottomUp(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            int maxJump = arr[i];
            for (int j = 1; j <= maxJump && i + j < n; j++) {
                dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
            }
        }

        return dp[n - 1];
    }

    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public static int jumpWithGreedy(int[] arr) {

        int n = arr.length;
        int count = 0;
        int end = 0;
        int furthest = 0;

        for (int i = 0; i < n - 1; i++) {
            furthest = Math.max(furthest, i + arr[i]);

            if (furthest >= n - 1) {
                count++;
                break;
            }

            // Visited all the items on the current level
            if (i == end) {
                count++;
                // expanding the end to the next level size
                end = furthest;
            }

        }

        return count;
    }

}

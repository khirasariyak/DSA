package Greedy;

/*
* https://leetcode.com/problems/jump-game/description/
* */

public class G4_JumpGameI {

    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 0, 4};
        System.out.println(canJump(arr));
        System.out.println(canJumpBruteForce(arr, 0));
        System.out.println(canJumpWithMemoization(arr, 0, new Boolean[arr.length + 1]));
        System.out.println(canJumpBottomUp(arr));
    }

    // Greedy Solution
    // Why Greedy? Because we can jump from 1 to arr[i].
    // If we can jump only arr[i] then we have to explore all the paths
    public static boolean canJump(int[] arr) {

        int finalDestination = arr.length - 1;

        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] + i >= finalDestination) {
                finalDestination = i;
            }
        }

        return finalDestination == 0;
    }

    // easy for understanding
    public static boolean canJumpAnotherGreedy(int[] arr) {

        int n = arr.length;
        int maxReachable = 0;

        for (int i = 0; i < n; i++) {
            if (i > maxReachable) {
                return false;
            }
            maxReachable = Math.max(maxReachable, i + arr[i]);
        }

        return true;
    }

    // dp brute force solution O(n ^ n)
    public static boolean canJumpBruteForce(int[] arr, int index) {

        if (index >= arr.length - 1) {
            return true;
        }

        if (arr[index] == 0 && index != arr.length - 1) {
            return false;
        }

        for (int j = 1; j <= arr[index]; j++) {
            if (canJumpBruteForce(arr, index + j)) {
                return true;
            }
        }

        return false;
    }

    // dynamic programming with memoization
    // Time Complexity: O(n ^ 2)
    // Space Complexity: O(n)
    public static boolean canJumpWithMemoization(int[] arr, int index, Boolean[] dp) {
        if (index >= arr.length - 1) {
            return true;
        }

        if (dp[index] != null) {
            return dp[index];
        }

        if (arr[index] == 0 && index != arr.length - 1) {
            return dp[index] = false;
        }

        for (int j = 1; j <= arr[index]; j++) {
            if (canJumpBruteForce(arr, index + j)) {
                return dp[index] = true;
            }
        }

        return dp[index] = false;
    }

    // Bottom up dynamic programming
    // TIme Complexity: O(n^2)
    // Space Complexity: O(n)
    public static boolean canJumpBottomUp(int[] arr) {

        int n = arr.length;
        boolean[] dp = new boolean[n];
        dp[0] = true;

        for (int i = 0; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (dp[j] && arr[j] + j >= i) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n - 1];
    }

}

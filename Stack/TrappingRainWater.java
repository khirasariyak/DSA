/*
* https://leetcode.com/problems/trapping-rain-water/
* */

public class TrappingRainWater {

    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trappingRainWaterBruteForce(arr));
        System.out.println(trappingRainWater(arr));
    }

    private static int trappingRainWater(int[] arr) {

        // Time complexity: O(n)
        // Space complexity: O(n)

        int length = arr.length;

        int[] leftMax = new int[length];
        leftMax[0] = arr[0];
        for (int i = 1; i < length; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], arr[i]);
        }

        int[] rightMax = new int[length];
        rightMax[length - 1] = arr[length - 1];
        for (int i = length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], arr[i]);
        }

        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += Math.min(leftMax[i], rightMax[i]) - arr[i];
        }

        return sum;
    }

    private static int trappingRainWaterBruteForce(int[] arr) {

        // Time complexity: O(n^2)
        // Space complexity: O(1)

        int sum = 0;

        for (int i = 0; i < arr.length; i++) {

            int leftMax = Integer.MIN_VALUE;
            int rightMax = Integer.MIN_VALUE;

            int j = i;
            while (j >= 0) {
                leftMax = Math.max(leftMax, arr[j]);
                j--;
            }

            j = i;
            while (j < arr.length) {
                rightMax = Math.max(rightMax, arr[j]);
                j++;
            }

            sum += Math.min(leftMax, rightMax) - arr[i];
        }

        return sum;
    }

    public int trapTwoPointer(int[] height) {
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int waterTrapped = 0;
    
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    waterTrapped += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    waterTrapped += rightMax - height[right];
                }
                right--;
            }
        }
    
        return waterTrapped;
    }

}

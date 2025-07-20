package SlidingWindow.FixedSizeWindow;

/*
* https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/
* */

public class MaximumPointsFromCards {

    public int maxScore(int[] cardPoints, int k) {

        int left = 0;
        int right = cardPoints.length - 1;
        int maxSum = 0;

        int leftSum = 0;
        int rightSum = 0;

        while (left < k) {
            leftSum += cardPoints[left];
            left++;
        }

        maxSum = Math.max(leftSum, maxSum);

        left--;

        while (left >= 0) {
            leftSum -= cardPoints[left];
            rightSum += cardPoints[right];
            left--;
            right--;
            maxSum = Math.max(maxSum, leftSum + rightSum);
        }

        return maxSum;
    }

}

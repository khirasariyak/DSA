import java.util.Stack;

/*
* https://leetcode.com/problems/largest-rectangle-in-histogram/
* */

public class LargestRectangleInHistogram {

    public static void main(String[] args) {
        int[] arr = {2,4};
        System.out.println(largestRectangleInHistogramBruteForce(arr));
        System.out.println(largestRectangleInHistogram(arr));
    }

    private static int largestRectangleInHistogramBruteForce(int[] arr) {

        int maxArea = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {

            int leftIndex = i;
            int rightIndex = i;

            while (leftIndex >= 0 && arr[leftIndex] >= arr[i]) {
                leftIndex--;
            }

            while (rightIndex < arr.length && arr[rightIndex] >= arr[i]) {
                rightIndex++;
            }

            int area = (rightIndex - leftIndex - 1) * arr[i];
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }

    private static int largestRectangleInHistogram(int[] arr) {

        int maxArea = Integer.MIN_VALUE;
        int[] nearestSmallestToLeft = getNearestSmallestToLeft(arr);
        int[] nearestSmallestToRight = getNearestSmallestToRight(arr);

        for (int i = 0; i < arr.length; i++) {

            int leftIndex = nearestSmallestToLeft[i];
            int rightIndex = nearestSmallestToRight[i];

            // no smaller element to the left
            if (rightIndex == -1) {
                rightIndex = arr.length;
            }

            int currentArea = (rightIndex - leftIndex - 1) * arr[i];
            maxArea = Math.max(maxArea, currentArea);
        }

        return maxArea;
    }

    private static int[] getNearestSmallestToRight(int[] arr) {

        Stack<Integer> stack = new Stack<>();
        int[] result = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {

            while(!(stack.isEmpty() || arr[stack.peek()] < arr[i])) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = stack.peek();
            }

            stack.push(i);
        }

        return result;
    }

    private static int[] getNearestSmallestToLeft(int[] arr) {

        Stack<Integer> stack = new Stack<>();
        int[] result = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {

            while(!(stack.isEmpty() || arr[stack.peek()] < arr[i])) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = stack.peek();
            }

            stack.push(i);
        }

        return result;
    }

}

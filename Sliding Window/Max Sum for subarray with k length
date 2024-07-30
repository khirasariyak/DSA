public class MaxSumForSubArray {

    public static void main(String[] args) {
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int windowSize = 3;
        System.out.println(maxSum(arr, windowSize));
    }

    public static int maxSum(int[] arr, int windowSize) {

        int length = arr.length;

        if (length < windowSize) {
            return -1;
        }

        int currentSum = getInitialWindowSum(arr, windowSize);
        int maxSum = currentSum;

        for (int i = windowSize; i < length; i++) {
            if (arr[i] != arr[i - windowSize]) {
                currentSum += arr[i] - arr[i - windowSize];
                maxSum = Math.max(maxSum, currentSum);
            }
        }

        return maxSum;
    }

    private static int getInitialWindowSum(int[] arr, int windowSize) {
        int sum = 0;
        for (int i = 0; i < windowSize; i++) {
            sum += arr[i];
        }
        return sum;
    }

}

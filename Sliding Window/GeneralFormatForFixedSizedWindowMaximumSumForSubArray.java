public class GeneralFormatForFixedSizedWindowMaximumSumForSubArray {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int windowSize = 3;
        System.out.println(maximumSumForSubArray(nums, windowSize));
    }

    private static int maximumSumForSubArray(int[] nums, int windowSize) {

        if (windowSize > nums.length) {
            return 0;
        }

        int i = 0;
        int j = 0;
        int k = 0;
        int maxSum = 0;
        int sum = 0;

        while(j < nums.length) {

            k = j - i + 1;
            sum += nums[j];

            if (k < windowSize) {
                j++;
            } else if (k == windowSize) {
                maxSum = Math.max(sum, maxSum);
                sum -= nums[i];
                i++;
                j++;
            }
        }

        return maxSum;
    }
}

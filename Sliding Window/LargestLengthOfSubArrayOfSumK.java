import java.util.HashMap;
import java.util.Map;

public class LargestLengthOfSubArrayOfSumK {

    public static void main(String[] args) {
        int[] nums1 = {10, 5, 2, 7, 1, 9};
        int k1 = 15;
        System.out.println(largestSubArrayOfSumK(nums1, k1));

        int[] nums2 = {-1, 1, 1};
        int k2 = 1;
        System.out.println(largestLengthOfSubArrayOfSumKWithPositivesAndNegatives(nums2, k2));
    }

    private static int largestSubArrayOfSumK(int[] nums, int k) {

        // Though, this will work for only positive numbers but optimal for positive numbers.
        // For negative numbers, we can use the below approach.

        int i = 0;
        int j = 0;
        int sum = 0;
        int maxLen = 0;

        while (j < nums.length) {
            sum += nums[j];

            while (sum > k) {
                sum -= nums[i];
                i++;
            }

            if (sum == k) {
                maxLen = Math.max(maxLen, j - i + 1);
            }

            j++;
        }
        return maxLen;
    }

    public static int largestLengthOfSubArrayOfSumKWithPositivesAndNegatives(int[] nums, int k) {

        // Optimal solution for positive and negative numbers.

        int maxLen = 0;
        int sum = 0;
        Map<Integer, Integer> preSumMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (sum == k) {
                maxLen = Math.max(maxLen, i + 1);
            }

            int rem = sum - k;
            if (preSumMap.containsKey(rem)) {
                maxLen = Math.max(maxLen, i - preSumMap.get(rem));
            }

            if (!preSumMap.containsKey(sum)) {
                preSumMap.put(sum, i);
            }
        }
        return maxLen;
    }

}

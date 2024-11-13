/*
* https://leetcode.com/problems/maximum-product-subarray/
* */

public class MaximumProductSubArray {

    public static void main(String[] args) {
        int[] nums = {3, -1, 4};
        System.out.println(maxProduct(nums));
    }

    private static int maxProduct(int[] nums) {

        int n = nums.length;
        int leftProduct = 0;
        int rightProduct = 0;
        int maxProduct = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {

            leftProduct = leftProduct == 0 ? 1 : leftProduct;
            rightProduct = rightProduct == 0 ? 1 : rightProduct;

            leftProduct *= nums[i];
            rightProduct *= nums[n - i -1];

            maxProduct = Math.max(maxProduct, Math.max(leftProduct, rightProduct));
        }

        return maxProduct;
    }

}

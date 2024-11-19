import java.util.Arrays;

/*
* https://leetcode.com/problems/product-of-array-except-self/
* */

public class ProductOfArrayExceptSelf {

    public static void main(String[] args) {
        int[] nums = new int[]{-1,1,0,-3,3};
        System.out.println(Arrays.toString(productOfArrayExceptSelfBruteForce(nums)));
        System.out.println(Arrays.toString(productOfArrayExceptSelf(nums)));
    }

    private static int[] productOfArrayExceptSelfBruteForce(int[] nums) {

        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int totalProduct = 1;
            for (int j = 0; j < nums.length; j++) {
                if (i != j) {
                    totalProduct *= nums[j];
                }
            }
            result[i] = totalProduct;
        }

        return result;
    }

    private static int[] productOfArrayExceptSelf(int[] nums) {

        int[] prefix = new int[nums.length];
        int prefixProduct = 1;
        prefix[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefixProduct * nums[i - 1];
            prefixProduct = prefix[i];
        }

        int[] suffix = new int[nums.length];
        int suffixProduct = 1;
        suffix[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            suffix[i] = suffixProduct * nums[i + 1];
            suffixProduct = suffix[i];
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = prefix[i] * suffix[i];
        }

        return nums;
    }

}

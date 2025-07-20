package Blind75.Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
* https://leetcode.com/problems/two-sum/
* */

public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(twoSumBruteForce(nums, target)));
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }
    
    private static int[] twoSumBruteForce(int[] nums, int target) {

        for (int i : nums) {
            for (int j : nums) {
                if (i + j == target) {
                    return new int[]{i, j};
                }
            }
        }
        
        return new int[]{};
    }

    private static int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            if (map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            } else {
                map.put(nums[i], i);
            }

        }

        return new int[]{};
    }

}

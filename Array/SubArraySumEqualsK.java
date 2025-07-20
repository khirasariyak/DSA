package Array;

import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/problems/subarray-sum-equals-k/description/
 * */

public class SubArraySumEqualsK {

    public static void main(String[] args) {
        System.out.println(subArraySumEqualsK(new int[]{1, 1, 1}, 2));
    }

    public static int subArraySumEqualsK(int[] nums, int k) {

        int left = 0;
        int right = 0;
        int sum = 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();

        map.put(0, 1);

        while (right < nums.length) {

            sum += nums[right];

            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
            right++;
        }

        return count;
    }

}

package Array;

import java.util.HashMap;
import java.util.Map;

/*
* https://leetcode.com/problems/subarray-sums-divisible-by-k/description/
* */

public class SubArraySumsDivisibleByK {

    public static void main(String[] args) {

    }

    public int subarraysDivByK(int[] nums, int k) {
        int sum = 0;
        int count = 0;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int num : nums) {
            sum += num;
            int remaining = sum % k;

            if (remaining < 0) {
                remaining += k;
            }

            if (map.containsKey(remaining)) {
                count += map.get(remaining);
            }

            map.put(remaining, map.getOrDefault(remaining, 0) + 1);
        }

        return count;
    }

}

package SlidingWindow.VariableSizeWindow;

import java.util.HashMap;
import java.util.Map;

/*
* https://leetcode.com/problems/subarrays-with-k-different-integers/
* */

public class SubArraysWithKDistinctIntegers {

    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    public int atMost(int[] nums, int k) {

        int left = 0;
        int right = 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();

        while (right < nums.length) {

            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);

            while (map.size() > k) {
                map.put(nums[left], map.get(nums[left]) - 1);
                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }
                left++;
            }

            count += right - left + 1;
            right++;
        }

        return count;
    }

}

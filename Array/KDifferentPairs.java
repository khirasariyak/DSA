package Array;

import java.util.HashMap;
import java.util.Map;

/*
* https://leetcode.com/problems/k-diff-pairs-in-an-array/description/
* */

public class KDifferentPairs {

    public static void main(String[] args) {
        int[] nums = {3, 1, 4, 1, 5};
        int k = 2;
        System.out.println(findPairs(nums, k));
    }

    private static int findPairs(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        int count = 0;
        for (int i : map.keySet()) {
            if (k == 0 && map.get(i) > 1 || k > 0 && map.containsKey(i + k)) {
                count++;
            }
        }

        return count;
    }

}

package SlidingWindow.VariableSizeWindow;

import java.util.HashMap;
import java.util.Map;

/*
* https://leetcode.com/problems/fruit-into-baskets/description/
* */

public class FruitIntoBaskets {

    public int totalFruit(int[] fruits) {

        int left = 0;
        int right = 0;
        int maxLen = 0;
        Map<Integer, Integer> map = new HashMap<>();

        while (right < fruits.length) {

            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);

            // if (map.size() > 2) {
            while (map.size() > 2) {
                map.put(fruits[left], map.get(fruits[left]) - 1);
                if (map.get(fruits[left]) == 0) {
                    map.remove(fruits[left]);
                }
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }

        return maxLen;
    }

}

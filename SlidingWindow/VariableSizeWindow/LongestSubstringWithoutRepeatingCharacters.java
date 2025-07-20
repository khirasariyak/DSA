package SlidingWindow.VariableSizeWindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String s = "pwwkewb";
        System.out.println(longestSubstringWithoutRepeatingCharacters(s));
    }

    private static int longestSubstringWithoutRepeatingCharacters(String s) {

        int i = 0;
        int j = 0;
        int maxLen = 0;
        Map<Character, Integer> map = new HashMap<>();

        while (j < s.length()) {
            char c = s.charAt(j);
            map.put(c, map.getOrDefault(c, 0) + 1);

            // Or you can check, map.get(c) > 1
            while (map.size() < j - i + 1) {
                char charToRemove = s.charAt(i);
                map.put(charToRemove, map.get(charToRemove) - 1);
                if (map.get(charToRemove) == 0) {
                    map.remove(charToRemove);
                }
                i++;
            }

            if (map.size() == j - i + 1) {
                maxLen = Math.max(maxLen, j - i + 1);
            }

            j++;
        }

        return maxLen;
    }
}

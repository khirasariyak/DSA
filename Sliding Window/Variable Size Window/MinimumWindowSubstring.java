import java.util.HashMap;
import java.util.Map;

/*
* https://www.geeksforgeeks.org/problems/smallest-window-in-a-string-containing-all-the-characters-of-another-string-1587115621/1
* */

public class MinimumWindowSubstring {

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minimumWindowSubstring(s, t));
    }

    private static String minimumWindowSubstring(String s, String t) {

        int windowStart = 0;
        int windowEnd = 0;
        int startIndex = -1;
        int minLen = Integer.MAX_VALUE;
        int countUniqueChar;

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        countUniqueChar = map.size();

        while(windowEnd < s.length()) {

            // Expanding the window
            char ch = s.charAt(windowEnd);
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) - 1);
                if (map.get(ch) == 0) {
                    countUniqueChar--;
                }
            }

            // Shrinking the window
            while(countUniqueChar == 0) {

                int len = windowEnd - windowStart + 1;
                if (len < minLen) {
                    minLen = len;
                    startIndex = windowStart;
                }

                ch = s.charAt(windowStart);
                if (map.containsKey(ch)) {
                    map.put(ch, map.get(ch) + 1);
                    if (map.get(ch) > 0) {
                        countUniqueChar++;
                    }
                }
                windowStart++;

            }

            windowEnd++;
        }

        return startIndex == -1 ? "" : s.substring(startIndex, startIndex + minLen);
    }

}

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithKUniqueCharacters {

    public static void main(String[] args) {
        String s = "aabacbebebe";
        int k = 3;
        System.out.println(longestSubstringWithKUniqueCharacters(s, k));
    }

    private static int longestSubstringWithKUniqueCharacters(String s, int k) {

        int i = 0;
        int j = 0;
        int maxLen = 0;
        Map<Character, Integer> map = new HashMap<>();

        while (j < s.length()) {
            char c = s.charAt(j);
            map.put(c, map.getOrDefault(c, 0) + 1);

            while (map.size() > k) {
                char charToRemove = s.charAt(i);
                map.put(charToRemove, map.get(charToRemove) - 1);
                if (map.get(charToRemove) == 0) {
                    map.remove(charToRemove);
                }
                i++;
            }

            if (map.size() == k) {
                maxLen = Math.max(maxLen, j - i + 1);
            }

            j++;
        }
        return maxLen;
    }

}

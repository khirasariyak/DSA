import java.util.HashMap;
import java.util.Map;

/*
* https://www.geeksforgeeks.org/problems/count-occurences-of-anagrams5839/1
* */

public class CountOccurrenceOfAnagram {

    public static void main(String[] args) {
        String text = "forxxorfxdofr";
        String pattern = "for";
        System.out.println(countOccurrenceOfAnagram(text, pattern));
    }

    private static int countOccurrenceOfAnagram(String text, String pattern) {

        int patternLength = pattern.length();
        int textLength = text.length();

        if (patternLength > textLength) {
            return 0;
        }

        Map<Character, Integer> patternMap = createMap(pattern);
        Map<Character, Integer> currentWindowMap = createMap(text.substring(0, patternLength));
        int count = 0;

        if (patternMap.equals(currentWindowMap)) {
            count++;
        }

        for (int i = 1; i < textLength - patternLength + 1; i++) {
            char charToRemove = text.charAt(i - 1);
            char charToAdd = text.charAt(i + patternLength - 1);

            currentWindowMap.put(charToRemove, currentWindowMap.getOrDefault(charToRemove, 0) - 1);
            if (currentWindowMap.get(charToRemove) == 0) {
                currentWindowMap.remove(charToRemove);
            }

            currentWindowMap.put(charToAdd, currentWindowMap.getOrDefault(charToAdd, 0) + 1);

            if (patternMap.equals(currentWindowMap)) {
                count++;
            }
        }

        return count;
    }

    private static Map<Character, Integer> createMap(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        return map;
    }

}

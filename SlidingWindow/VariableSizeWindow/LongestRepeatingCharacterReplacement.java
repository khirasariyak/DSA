package SlidingWindow.VariableSizeWindow;

/*
* https://leetcode.com/problems/longest-repeating-character-replacement/description/
* */

public class LongestRepeatingCharacterReplacement {

    public static void main(String[] args) {
        System.out.println(characterReplacement("AABABBA", 1));
    }

    public static int characterReplacement(String s, int k) {

        int left = 0;
        int right = 0;
        int maxFreq = 0;
        int maxWindowLength = 0;
        int[] chars = new int[26];

        while (right < s.length()) {

            int chToAdd = s.charAt(right) - 'A';
            chars[chToAdd]++;

            maxFreq = Math.max(maxFreq, chars[chToAdd]);

            while ( (right - left + 1) - maxFreq > k ) {
                int chToRemove = s.charAt(left) - 'A';
                chars[chToRemove]--;
                left++;
            }

            maxWindowLength = Math.max(maxWindowLength, right - left + 1);
            right++;
        }

        return maxWindowLength;
    }

}

package SlidingWindow.VariableSizeWindow;

/*
* https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/
* */

public class NumberOfSubstringsContainingAllThreeCharacters {

    public static void main(String[] args) {
        System.out.println(numberOfSubstrings("abcabc"));
    }

    public static int numberOfSubstrings(String s) {

        int left = 0;
        int right = 0;
        int count = 0;
        int len = s.length();
        int[] hash = new int[3];

        while (right < len) {

            hash[s.charAt(right) - 'a']++;

            while (hash[0] > 0 && hash[1] > 0 && hash[2] > 0) {
                count += len - right;
                hash[s.charAt(left) - 'a']--;
                left++;
            }

            right++;

        }

        return count;
    }

}

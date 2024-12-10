/*
* https://leetcode.com/problems/find-smallest-letter-greater-than-target/
* */

public class NextAlphabeticalElement {

    public static void main(String[] args) {
        char[] chars = {'a', 'c', 'f', 'h'};
        char target = 'f';
        System.out.println(nextAlphabeticalElementBruteForce(chars, target));
        System.out.println(nextAlphabeticalElement(chars, target));
    }

    private static char nextAlphabeticalElementBruteForce(char[] chars, char target) {

        for (char ch : chars) {
            if (ch > target) {
                return ch;
            }
        }

        return chars[0];
    }

    private static char nextAlphabeticalElement(char[] chars, char target) {

        int mid;
        int left = 0;
        char ch = chars[0];
        int right = chars.length - 1;

        while (left <= right) {

            mid = left + (right - left) / 2;

            if (chars[mid] <= target) {
                left = mid + 1;
            } else {
                ch = chars[mid];
                right = mid - 1;
            }

        }

        return ch;
    }

}

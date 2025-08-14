package Greedy;

/*
* https://leetcode.com/problems/valid-parenthesis-string/description/
* */

public class G11_ValidParenthesesString {

    // Time Complexity: O(3^N)
    // Space Complexity: O(N)
    public static boolean checkValidStringBruteForce(String s, int index, int count) {

        if (count < 0) {
            return false;
        }

        if (index == s.length()) {
            return count == 0;
        }

        if (s.charAt(index) == '(') {
            return checkValidStringBruteForce(s, index + 1, count + 1);
        }

        if (s.charAt(index) == ')') {
            return checkValidStringBruteForce(s, index + 1, count - 1);
        }

        return checkValidStringBruteForce(s, index + 1, count + 1)
                || checkValidStringBruteForce(s, index + 1, count)
                || checkValidStringBruteForce(s, index + 1, count - 1);

    }

    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public static boolean checkValidString(String s) {

        int min = 0;
        int max = 0;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {
                min++;
                max++;
            } else if (s.charAt(i) == ')') {
                min--;
                max--;
            } else {
                min--;
                max++;
            }

            if (min < 0) {
                min = 0;
            }

            if (max < 0) {
                return false;
            }

        }


        return min == 0;
    }

}

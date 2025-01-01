package Backtracking;

import java.util.ArrayList;
import java.util.List;

/*
* https://leetcode.com/problems/palindrome-partitioning/description/
* */

public class PalindromicPartitions {

    public static void main(String[] args) {
        String s = "nitin";
        List<List<String>> result = new ArrayList<>();
        List<String> path = new ArrayList<>();
        partitions(0, s, path, result);
        System.out.println(result);
    }

    private static void partitions(int index, String s, List<String> path, List<List<String>> result) {

        if (index == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = index; i < s.length(); i++) {
            if (isPalindrome(s, index, i)) {
                path.add(s.substring(index, i + 1));
                partitions(i + 1, s, path, result);
                path.remove(path.size() - 1);
            }
        }

    }

    private static boolean isPalindrome(String s, int start, int end) {

        while (start <= end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }

        return true;
    }

}

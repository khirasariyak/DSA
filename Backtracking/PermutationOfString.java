package Backtracking;

import java.util.Set;
import java.util.TreeSet;

/*
* https://www.geeksforgeeks.org/problems/permutations-of-a-given-string2041/1
* */

public class PermutationOfString {

    static Set<String> treeSet = new TreeSet<>();

    public static void main(String[] args) {
        String str = "ABC";
        permutation(str, "");
        System.out.println(treeSet);
        treeSet.clear();
        permutationWithBacktracking(new StringBuilder(str), 0);
        System.out.println(treeSet);
    }

    private static void permutation(String ip, String op) {

        if(ip.isEmpty()) {
            treeSet.add(op);
            return;
        }

        for(int i = 0; i < ip.length(); i++) {
            if (i == 0 || ip.charAt(i) != ip.charAt(i-1)) {
                char ch = ip.charAt(i);
                String newIp = ip.substring(0, i) + ip.substring(i+1);
                permutation(newIp, op + ch);
            }
        }
    }

    private static void permutationWithBacktracking(StringBuilder s, int index) {

        if (index == s.length() - 1) {
            treeSet.add(s.toString());
            return;
        }

        for (int i = index; i < s.length(); i++) {
            if (i == index || s.charAt(i) != s.charAt(index)) {
                swap(s, index, i);
                permutationWithBacktracking(s, index + 1);
                swap(s, index, i);
            }
        }

    }

    private static void swap(StringBuilder s, int i, int j) {
        char c = s.charAt(i);
        s.setCharAt(i, s.charAt(j));
        s.setCharAt(j, c);
    }

}

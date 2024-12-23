package Recursion;

import java.util.ArrayList;
import java.util.List;

/*
* Letter case permutation is same as PermutationWithCaseChange
* https://leetcode.com/problems/letter-case-permutation/
* */

public class PermutationWithCaseChange {

    static List<String> list = new ArrayList<>();

    public static void main(String[] args) {

        String ip = "abc";
        String op = "";

        permutationsWithCaseChange(ip, op);
        System.out.println(list);
    }

    private static void permutationsWithCaseChange(String ip, String op) {

        if (ip.isEmpty()) {
            list.add(op);
            return;
        }

        String op1 = op;
        String op2 = op;

        op1 += Character.toUpperCase(ip.charAt(0));
        op2 += Character.toLowerCase(ip.charAt(0));
        ip = ip.substring(1);

        permutationsWithCaseChange(ip, op1);
        permutationsWithCaseChange(ip, op2);
    }

}

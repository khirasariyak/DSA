package Recursion;

import java.util.ArrayList;
import java.util.List;

/*
* For unique subsets, use a set instead of a list.
* https://www.geeksforgeeks.org/problems/subsets-1613027340/1
* */

public class PrintSubsets {

    static List<String> list = new ArrayList<>();

    public static void main(String[] args) {
        printSubsets("abc", "");
        System.out.println(list);
    }

    private static void printSubsets(String ip, String op) {

        if (ip.isEmpty()) {
            list.add(op);
            return;
        }

        String op1 = op;
        String op2 = op;
        op1 += ip.charAt(0);
        op2 += "";
        ip = ip.substring(1);

        printSubsets(ip, op1);
        printSubsets(ip, op2);
    }

}

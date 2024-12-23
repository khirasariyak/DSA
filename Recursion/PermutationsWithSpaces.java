package Recursion;

import java.util.ArrayList;
import java.util.List;

/*
* https://www.geeksforgeeks.org/problems/permutation-with-spaces3627/1
* */

public class PermutationsWithSpaces {

    static List<String> list = new ArrayList<>();

    public static void main(String[] args) {

        String ip = "abc";
        String op = "";

        op += ip.charAt(0);
        ip = ip.substring(1);
        permutationsWithSpaces(ip, op);
        System.out.println(list);
    }

    private static void permutationsWithSpaces(String ip, String op) {

        if (ip.isEmpty()) {
            list.add(op);
            return;
        }

        String op1 = op;
        String op2 = op;
        op1 += "_" + ip.charAt(0);
        op2 += ip.charAt(0);
        ip = ip.substring(1);

        permutationsWithSpaces(ip, op1);
        permutationsWithSpaces(ip, op2);
    }

}

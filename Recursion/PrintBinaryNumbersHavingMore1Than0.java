package Recursion;

import java.util.ArrayList;
import java.util.List;

/*
* https://www.geeksforgeeks.org/problems/print-n-bit-binary-numbers-having-more-1s-than-0s0252/0
* */

public class PrintBinaryNumbersHavingMore1Than0 {

    static List<String> list = new ArrayList<>();

    public static void main(String[] args) {
        int n = 4;
        printBinaryNumbersHavingMore1Than0(n);
    }

    private static void printBinaryNumbersHavingMore1Than0(int n) {
        int ones = 0;
        String op = "";
        printBinaryNumbersHavingMore1Than0(ones, n, op);
        System.out.println(list);
    }

    private static void printBinaryNumbersHavingMore1Than0(int ones, int remainingPlaces, String op) {

        if (remainingPlaces == 0) {
            list.add(op);
            return;
        }

        String op1 = op;
        op1 += "1";
        printBinaryNumbersHavingMore1Than0(ones + 1, remainingPlaces - 1, op1);

        if (ones > 0) {
            String op2 = op;
            op2 += "0";
            printBinaryNumbersHavingMore1Than0(ones - 1, remainingPlaces - 1, op2);
        }

    }

}

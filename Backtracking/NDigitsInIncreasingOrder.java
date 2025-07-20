package Backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
* https://www.geeksforgeeks.org/problems/n-digit-numbers-with-digits-in-increasing-order5903/1
* */

public class NDigitsInIncreasingOrder {

    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        int n = 2;

        if (n == 1) {
            list = IntStream.rangeClosed(0, 9).boxed().collect(Collectors.toList());
            System.out.println(list);
            return;
        }

        generate(n, 0);
        System.out.println(list);
    }

    private static void generate(int n, int num) {

        if (n == 0) {
            list.add(num);
            return;
        }

        for (int i = 1; i <= 9; i++) {
            if (num == 0 || num % 10 < i) {
                generate(n - 1, num * 10 + i);
            }
        }

    }
    
}

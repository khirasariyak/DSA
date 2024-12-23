package Recursion;

/*
* https://leetcode.com/problems/k-th-symbol-in-grammar
* */

public class KthSymbolInGrammar {

    public static void main(String[] args) {
        int n = 4;
        int k = 5;
        System.out.println(kthGrammar(n, k));
    }

    private static int kthGrammar(int n, int k) {

        if (n == 1 && k == 1) {
            return 0;
        }

        int mid = (int) Math.pow(2, n - 1) / 2;

        if (mid >= k) {
            return kthGrammar(n - 1, k);
        } else {
            return 1 - kthGrammar(n - 1, k - mid);
        }
    }

}

import java.util.ArrayList;
import java.util.List;

/*
* https://leetcode.com/problems/generate-parentheses/
* */

public class GenerateAllParentheses {

    static List<String> list = new ArrayList<>();

    public static void main(String[] args) {
        generateParentheses(3);
    }

    private static void generateParentheses(int n) {
        int open = n;
        int close = n;
        String op = "";
        generateParentheses(n, open, close, op);
        System.out.println(list);
    }

    private static void generateParentheses(int n, int open, int close, String op) {

        if (open == 0 && close == 0) {
            list.add(op);
            return;
        }

        if (open != 0) {
            String op1 = op;
            op1 += "(";
            generateParentheses(n, open - 1, close, op1);
        }

        if (close > open) {
            String op2 = op;
            op2 += ")";
            generateParentheses(n, open, close - 1, op2);
        }

    }

}

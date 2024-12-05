import java.util.Arrays;
import java.util.Stack;

/*
* https://www.geeksforgeeks.org/problems/stock-span-problem-1587115621/1
* */

public class StockSpanProblem {

    public static void main(String[] args) {
        int[] arr = {100, 80, 60, 70, 60, 75, 85};
        System.out.println(Arrays.toString(stockSpanProblemBruteForce(arr)));
        System.out.println(Arrays.toString(stockSpanProblem(arr)));
    }

    private static int[] stockSpanProblem(int[] arr) {

        Stack<Integer> stack = new Stack<>();
        int[] result = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {

            while (!(stack.isEmpty() || arr[stack.peek()] > arr[i])) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                result[i] = i + 1;
            } else {
                result[i] = i - stack.peek();
            }

            stack.push(i);
        }

        return result;
    }

    private static int[] stockSpanProblemBruteForce(int[] arr) {

        int[] result = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            int count = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] > arr[i]) {
                    break;
                }
                count++;
            }
            result[i] = count;
        }

        return result;
    }

}

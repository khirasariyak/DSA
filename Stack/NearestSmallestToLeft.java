import java.util.Arrays;
import java.util.Stack;

/*
* https://www.geeksforgeeks.org/problems/smallest-number-on-left3403/1
* */

public class NearestSmallestToLeft {

    public static void main(String[] args) {
        int[] arr = {4, 5, 2, 10, 8};
        System.out.println(Arrays.toString(nearestSmallestToLeftBruteForce(arr)));
        System.out.println(Arrays.toString(nearestSmallestToLeft(arr)));
    }

    private static int[] nearestSmallestToLeft(int[] arr) {

        Stack<Integer> stack = new Stack<>();
        int[] result = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {

            while(!(stack.isEmpty() || stack.peek() < arr[i])) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = stack.peek();
            }

            stack.push(arr[i]);
        }

        return result;
    }

    private static int[] nearestSmallestToLeftBruteForce(int[] arr) {

        int[] result = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            int smallest = -1;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] < arr[i]) {
                    smallest = arr[j];
                    break;
                }
            }
            result[i] = smallest;
        }

        return result;
    }

}

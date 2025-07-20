package Stack;

import java.util.Arrays;
import java.util.Stack;

/*
* not found
* */

public class NearestSmallestToRight {

    public static void main(String[] args) {
        int[] arr = {4, 5, 2, 10, 8};
        System.out.println(Arrays.toString(nearestSmallestToRightBruteForce(arr)));
        System.out.println(Arrays.toString(nearestSmallestToRight(arr)));
    }

    private static int[] nearestSmallestToRight(int[] arr) {

        Stack<Integer> stack = new Stack<>();
        int[] result = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {

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

    private static int[] nearestSmallestToRightBruteForce(int[] arr) {

        int[] result = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            int smallest = -1;
            for (int j = i + 1; j < arr.length; j++) {
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

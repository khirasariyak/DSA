import java.util.Arrays;
import java.util.Stack;

/*
* https://www.geeksforgeeks.org/problems/next-larger-element-1587115620/1
* */

public class NearestGreaterToRight {

    public static void main(String[] args) {
        int[] arr = {4, 5, 2, 10, 8};
        System.out.println(Arrays.toString(nearestGreaterToRightBruteForce(arr)));
        System.out.println(Arrays.toString(nearestGreaterToRight(arr)));
    }

    private static int[] nearestGreaterToRightBruteForce(int[] arr) {

        int[] result = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            int max = -1;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > arr[i]) {
                    max = arr[j];
                    break;
                }
            }
            result[i] = max;
        }

        return result;
    }

    private static int[] nearestGreaterToRight(int[] arr) {

        Stack<Integer> stack = new Stack<>();
        int[] result = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {

            while (!(stack.isEmpty() || stack.peek() > arr[i])) {
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

}

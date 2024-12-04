import java.util.Arrays;
import java.util.Stack;

/*
* not found
* */

public class NearestGreaterToLeft {

    public static void main(String[] args) {
        int[] arr = {4, 5, 2, 10, 8};
        System.out.println(Arrays.toString(nearestGreaterToLeftBruteForce(arr)));
        System.out.println(Arrays.toString(nearestGreaterToLeft(arr)));
    }

    private static int[] nearestGreaterToLeftBruteForce(int[] arr) {

        int[] result = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            int max = -1;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] > arr[i]) {
                    max = arr[j];
                    break;
                }
            }
            result[i] = max;
        }

        return result;
    }

    private static int[] nearestGreaterToLeft(int[] arr) {

        Stack<Integer> stack = new Stack<>();
        int[] result = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {

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

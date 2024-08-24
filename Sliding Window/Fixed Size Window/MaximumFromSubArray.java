import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/*
* https://www.geeksforgeeks.org/problems/ipl-2021-match-day-2--141634/1
* */

public class MaximumFromSubArray {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1, 4, 5, 2, 3, 6};
        int windowSize = 3;
        System.out.println(maximumFromSubArray(nums, windowSize));
    }

    private static List<Integer> maximumFromSubArray(int[] nums, int windowSize) {

        List<Integer> result = new ArrayList<>();

        if (nums == null || nums.length == 0 || windowSize <= 0 || windowSize > nums.length) {
            return result;
        }

        Deque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < nums.length; i++) {

            // there will be only one element which will be outside the window so no need of while loop here.
            // removing indices of elements not in the current window
            if(!queue.isEmpty() && (i - windowSize) == queue.peekFirst()) {
                queue.pollFirst();
            }

            // we need while loop here as there can be multiple smaller elements
            // removing elements smaller than the currently being added element (they are not useful)
            while(!queue.isEmpty() && nums[i] > nums[queue.peekLast()]) {
                queue.pollLast();
            }

            /*
             * We are storing index in queue and not the element itself is because we have condition to on the index to
             * check whether it is inside the window or not. If we store the element in queue, that won't be a problem
             * but i - windowSize can be negative as well and in that case nums[i - windowSize] will throw an error.
             */
            queue.addLast(i);
            if (i >= windowSize - 1) {
                result.add(nums[queue.peekFirst()]);
            }
            
        }
        return result;
    }

}

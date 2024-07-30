import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class PrintFirstNegativeInteger {

  public static void main(String[] args) {
    long[] input = {-8, 2, 3, -6, 10};
    int windowSize = 2;
    System.out.println(Arrays.toString(printFirstNegativeInteger(input, input.length, windowSize)));
  }

  public static long[] printFirstNegativeInteger(long nums[], int length, int windowSize) {

    Queue<Long> queue = new LinkedList<>();
    int i = 0;
    while (i < windowSize) {
      if (nums[i] < 0) {
        queue.offer(nums[i]);
      }
      i++;
    }

    long[] result = new long[length - windowSize + 1];
    result[0] = queue.isEmpty() ? 0 : queue.peek();

    for (int j = 1; j < length - windowSize + 1; j++) {
      if (nums[j - 1] < 0) {
        queue.poll();
      }

      if (nums[j + windowSize - 1] < 0) {
        queue.offer(nums[j + windowSize - 1]);
      }

      result[j] = queue.isEmpty() ? 0 : queue.peek();
    }

    return result;
  }

}

package Greedy;

import java.util.Arrays;
import java.util.Comparator;

public class G8_NonOverlappingIntervals {

    public static void main(String[] args) {

        int[][] intervals = {
                {1, 100},
                {11, 22},
                {1, 11},
                {2, 12}
        };
        System.out.println(eraseOverlapIntervals(intervals));
    }

    public static int eraseOverlapIntervals(int[][] intervals) {

        Comparator<int[]> comparator = Comparator
                .comparing((int[] arr) -> arr[1])
                .thenComparing((int[] arr) -> arr[0]);

        Arrays.sort(intervals, comparator);

        int count = 0;
        int prevEndTime = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < prevEndTime) {
                count++;
            } else {
                prevEndTime = intervals[i][1];
            }
        }

        return count;
    }

}

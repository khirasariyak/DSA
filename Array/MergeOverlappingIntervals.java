package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
*
* */

public class MergeOverlappingIntervals {

    public static void main(String[] args) {
        int[][] intervals = new int[][]{
                {1, 6},
                {8, 10},
                {15, 18}
        };
        System.out.println(Arrays.deepToString(getMergedIntervals(intervals)));
    }

    private static int[][] getMergedIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> result = new ArrayList<>();

        for (int[] interval : intervals) {
            if (result.isEmpty() || interval[0] > result.get(result.size() - 1)[1]) {
                result.add(interval);
            } else {
                result.get(result.size() - 1)[1] = Math.max(result.get(result.size() - 1)[1], interval[1]);
            }
        }
        return result.toArray(new int[result.size()][]);
    }

}

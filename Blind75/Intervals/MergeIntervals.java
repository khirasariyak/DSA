package Blind75.Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
* https://leetcode.com/problems/merge-intervals/
* */

public class MergeIntervals {

    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        System.out.println(Arrays.deepToString(mergeIntervals(intervals)));
    }

    private static int[][] mergeIntervals(int[][] intervals) {

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> list = new ArrayList<>();

        for (int[] interval : intervals) {

            if (!list.isEmpty() && list.get(list.size() - 1)[1] >= interval[0]) {
                list.get(list.size() - 1)[1] = Math.max(list.get(list.size() - 1)[1], interval[1]);
            } else {
                list.add(interval);
            }

        }

        return list.toArray(new int[list.size()][]);
    }

}

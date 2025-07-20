package Blind75.Intervals;

import java.util.Arrays;
import java.util.Comparator;

/*
* https://leetcode.com/problems/non-overlapping-intervals/
* */

public class NonOverlappingIntervals {

    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        System.out.println(nonOverlappingIntervals(intervals));
    }

    private static int nonOverlappingIntervals(int[][] intervals) {

        int n = intervals.length;
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));

        int prev = 0;
        int count = 1;

        for (int i = 1; i < n; i++) {
            if (intervals[i][0] >= intervals[prev][1]) {
                prev = i;
                count++;
            }
        }

        return n - count;
    }

}

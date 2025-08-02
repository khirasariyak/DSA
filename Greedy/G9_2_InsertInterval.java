package Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
 * https://leetcode.com/problems/insert-interval/
 * */

public class G9_2_InsertInterval {

    public int[][] insertIntervalBruteForce(int[][] intervals, int[] newInterval) {

        List<int[]> list = new ArrayList<>(Arrays.asList(intervals));
        list.add(newInterval);

        list.sort(Comparator.comparingInt(a -> a[0]));
        List<int[]> result = new ArrayList<>();

        for (int[] interval : list) {
            if (!result.isEmpty() && result.getLast()[1] >= interval[0]) {
                result.getLast()[1] = Math.max(result.getLast()[1], interval[1]);
            } else {
                result.add(interval);
            }
        }

        return result.toArray(new int[result.size()][]);
    }

    public int[][] insertInterval(int[][] intervals, int[] newInterval) {

        List<int[]> result = new ArrayList<>();

        int i = 0;
        int n = intervals.length;

        // already sorted so no need to sort

        // add all intervals which end is less than newInterval's start
        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        // cover intervals which has start less than or equal to newInterval's end
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        result.add(newInterval);

        // add all the intervals which start is greater than the previous end
        while (i < n) {
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[result.size()][]);
    }

}

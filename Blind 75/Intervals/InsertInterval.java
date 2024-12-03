import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
* https://leetcode.com/problems/insert-interval/
* */

public class InsertInterval {

    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1, 3}, {6, 9}};
        int[] newInterval = new int[]{2, 5};
        System.out.println(Arrays.deepToString(insertIntervalBruteForce(intervals, newInterval)));
        System.out.println(Arrays.deepToString(insertInterval(intervals, newInterval)));
    }

    private static int[][] insertInterval(int[][] intervals, int[] newInterval) {

        List<int[]> list = new ArrayList<>();

        int i = 0;
        int n = intervals.length;

        while (i < n && intervals[i][1] < newInterval[0]) {
            list.add(intervals[i]);
            i++;
        }

        while (i < n && intervals[i][0] < newInterval[1]) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        list.add(newInterval);

        while (i < n) {
            list.add(intervals[i]);
            i++;
        }

        return list.toArray(new int[list.size()][]);
    }

    private static int[][] insertIntervalBruteForce(int[][] intervals, int[] newInterval) {

        List<int[]> list = new ArrayList<>(Arrays.asList(intervals));
        list.add(newInterval);

        list.sort(Comparator.comparingInt(a -> a[0]));
        List<int[]> result = new ArrayList<>();

        for (int[] interval : list) {
            if (!result.isEmpty() && result.get(result.size() - 1)[1] >= interval[0]) {
                result.get(result.size() - 1)[1] = Math.max(result.get(result.size() - 1)[1], interval[1]);
            } else {
                result.add(interval);
            }
        }

        return result.toArray(new int[result.size()][]);

    }

}

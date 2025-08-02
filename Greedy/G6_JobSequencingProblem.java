package Greedy;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/*
 * https://www.geeksforgeeks.org/problems/job-sequencing-problem-1587115620/1
 * */

public class G6_JobSequencingProblem {

    public List<Integer> jobSequencing(int[] deadline, int[] profit) {

        List<AbstractMap.SimpleEntry<Integer, Integer>> jobs = new ArrayList<>();

        for (int i = 0; i < deadline.length; i++) {
            jobs.add(new AbstractMap.SimpleEntry<>(profit[i], deadline[i]));
        }

        // sorting on profit
        jobs.sort(Comparator.comparingInt(AbstractMap.SimpleEntry<Integer, Integer>::getKey).reversed());

        int maxDeadline = jobs.stream()
                .map(AbstractMap.SimpleEntry::getValue)
                .max(Comparator.comparingInt(a -> a))
                .get();

        boolean[] slot = new boolean[maxDeadline]; // tracks if slot is occupied

        int totalProfit = 0;
        int count = 0;

        for (AbstractMap.SimpleEntry<Integer, Integer> simpleEntry : jobs) {
            // Find a free slot for this job (starting from the latest possible)
            int latestSlot = Math.min(simpleEntry.getValue(), maxDeadline) - 1;

            while (latestSlot >= 0) {
                if (!slot[latestSlot]) {
                    slot[latestSlot] = true;
                    totalProfit += simpleEntry.getKey();
                    count++;
                    break;
                }
                latestSlot--;
            }
        }

        return List.of(count, totalProfit);

    }

}

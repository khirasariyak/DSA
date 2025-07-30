package Greedy;

import java.util.Arrays;

/*
* https://www.geeksforgeeks.org/problems/shortest-job-first/1
* */

public class ShortestJobFirst {

    public static void main(String[] args) {
        System.out.println(calculateAverageWaitingTime(new int[]{4, 3, 7, 1, 2}));
    }

    public static int calculateAverageWaitingTime(int[] bt) {

        Arrays.sort(bt);
        int time = 0;
        int waitingTime = 0;

        for (int b : bt) {
            waitingTime += time;
            time += b;
        }

        return waitingTime / bt.length;
    }


}

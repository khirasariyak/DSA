package Greedy;

import java.util.Arrays;
import java.util.Comparator;

/*
* https://www.geeksforgeeks.org/problems/fractional-knapsack-1587115620/1
* */

public class G13_FractionalKnapsack {

    double fractionalKnapsack(int[] values, int[] weights, int W) {

        double[][] items = new double[values.length][2];
        for (int i = 0; i < values.length; i++) {
            items[i][0] = (double) values[i] / weights[i];
            items[i][1] = i;
        }

        Arrays.sort(items, Comparator.comparingDouble(a -> a[0]));
        double maxValue = 0;
        for (int i = values.length - 1; i >= 0; i--) {
            int idx = (int) items[i][1];
            if (W - weights[idx] >= 0) {
                maxValue += values[idx];
                W -= weights[idx];
            } else {
                maxValue += W * ((double) values[idx] / weights[idx]);
                break;
            }
        }
        return maxValue;
    }

}

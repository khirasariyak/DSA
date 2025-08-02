package Greedy;

import java.util.Arrays;

/*
* https://www.geeksforgeeks.org/problems/minimum-platforms-1587115620/1
* */

public class G10_MinimumPlatformsRequired {

    public static void main(String[] args) {
        System.out.println(minPlatform(
                new int[] {900, 940, 950, 1100, 1500, 1800},
                new int[] {910, 1200, 1120, 1130, 1900, 2000}
        ));
    }

    public static int minPlatform(int[] arr, int[] dep) {

        Arrays.sort(arr);
        Arrays.sort(dep);

        int i = 1;
        int j = 0;
        int n = arr.length;
        int maxPlatForm = 1;
        int platformCount = 1;

        while(i < n && j < n) {
            if(arr[i] <= dep[j]) {
                platformCount++;
                i++;
            } else {
                platformCount--;
                j++;
            }
            maxPlatForm = Math.max(platformCount, maxPlatForm);
        }

        return maxPlatForm;
    }

}

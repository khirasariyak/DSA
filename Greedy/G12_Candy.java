package Greedy;

/*
* https://leetcode.com/problems/candy/description/
* */

public class G12_Candy {

    public int candyBruteForce(int[] ratings) {
        int length = ratings.length;
        int[] left = new int[length];
        int[] right = new int[length];

        left[0] = 1;

        for (int i = 1; i < length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = 1;
            }
        }

        right[length - 1] = 1;
        for (int j = length - 2; j >= 0; j--) {
            if (ratings[j] > ratings[j + 1]) {
                right[j] = right[j + 1] + 1;
            } else {
                right[j] = 1;
            }
        }

        int sum = 0;
        for (int k = 0; k < length; k++) {
            sum += Math.max(left[k], right[k]);
        }

        return sum;
    }

    public int candyBruteForceII(int[] ratings) {
        int length = ratings.length;
        int[] left = new int[length];

        left[0] = 1;
        for (int i = 1; i < length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = 1;
            }
        }

        int curr;
        int right = 1;
        int sum = Math.max(left[length - 1], 1);

        for (int i = length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                curr = right + 1;
            } else {
                curr = 1;
            }
            right = curr;
            sum += Math.max(left[i], curr);
        }
        return sum;
    }

    public int candyOptimal(int[] ratings) {

        int n = ratings.length;
        int idx = 1;
        int candies = 1;

        while(idx < n) {

            if (ratings[idx] == ratings[idx - 1]) {
                candies += 1;
                idx++;
                continue;
            }

            int up = 1;
            while(idx < n && ratings[idx] > ratings[idx - 1]) {
                up++;
                candies += up;
                idx++;
            }

            int down = 1;
            while(idx < n && ratings[idx] < ratings[idx - 1]) {
                candies += down;
                down++;
                idx++;
            }

            if(down > up) {
                candies += down - up;
            }
        }

        return candies;
    }

}

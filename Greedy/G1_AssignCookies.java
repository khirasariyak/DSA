package Greedy;

import java.util.Arrays;

/*
* https://leetcode.com/problems/assign-cookies/description/
* */

public class G1_AssignCookies {

    public static void main(String[] args) {
        System.out.println(findContentChildren(
                new int[] {10,9,8,7},
                new int[] {5,6,7,8}
        ));
    }

    public static int findContentChildren(int[] g, int[] s) {

        Arrays.sort(g);
        Arrays.sort(s);

        int i = 0;
        int j = 0;
        int count = 0;

        while(i < g.length && j < s.length) {

            if (g[i] <= s[j]) {
                count++;
                j++;
                i++;
            } else {
                j++;
            }

        }

        return count;
    }

}

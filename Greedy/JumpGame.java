package Greedy;

/*
* https://leetcode.com/problems/jump-game/description/
* */

public class JumpGame {

    public static void main(String[] args) {
        System.out.println(canJump(new int[]{3, 2, 1, 0, 4}));
    }

    public static boolean canJump(int[] arr) {

        int finalDestination = arr.length - 1;

        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] + i >= finalDestination) {
                finalDestination = i;
            }
        }

        return finalDestination == 0;
    }

}

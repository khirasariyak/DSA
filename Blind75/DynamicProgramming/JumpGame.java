package Blind75.DynamicProgramming;

/*
* https://leetcode.com/problems/jump-game/
* */

public class JumpGame {

    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(canJump(nums));
    }

    private static boolean canJump(int[] nums) {

        int finalDestination = nums.length - 1;

        for (int i = nums.length - 2; i >= 0; i--) {
            if (i + nums[i] >= finalDestination) {
                finalDestination = i;
            }
        }

        return finalDestination == 0;
    }

}

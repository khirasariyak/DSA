package Greedy;

/*
 * https://leetcode.com/problems/lemonade-change/description/
 * */

public class LemonadeChange {

    public static void main(String[] args) {
        System.out.println(lemonadeChange(new int[]{5, 5, 5, 10, 20}));
    }

    public static boolean lemonadeChange(int[] bills) {

        int fiveCounter = 0;
        int tenCounter = 0;

        for (int bill : bills) {
            if (bill == 5) {
                fiveCounter++;
            } else if (bill == 10) {
                if (fiveCounter > 0) {
                    fiveCounter--;
                    tenCounter++;
                } else {
                    return false;
                }
            } else {
                if (fiveCounter > 0 && tenCounter > 0) {
                    fiveCounter--;
                    tenCounter--;
                } else if (fiveCounter > 2) {
                    fiveCounter -= 3;
                } else {
                    return false;
                }
            }
        }

        return true;
    }

}

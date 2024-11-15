/*
* https://leetcode.com/problems/sum-of-two-integers/description/
* */

public class SumOfTwoIntegers {

    public static void main(String[] args) {
        System.out.println(getSum(1, 2));
    }

    private static int getSum(int a, int b) {

        while (b != 0) {
            int temp = (a & b) << 1;
            a = a ^ b;
            b = temp;
        }

        return a;
    }

}

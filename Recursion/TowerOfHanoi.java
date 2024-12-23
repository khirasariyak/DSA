package Recursion;

/*
* https://www.geeksforgeeks.org/problems/tower-of-hanoi-1587115621/1
* */

public class TowerOfHanoi {

    public static void main(String[] args) {
        System.out.println(towerOfHanoi(64, 'A', 'B', 'C'));
    }

    private static int towerOfHanoi(int i, char a, char b, char c) {

        if (i == 1) {
            System.out.println("Move disk 1 from " + a + " to " + c);
            return 1;
        }

        int moves = towerOfHanoi(i - 1, a, b, c);
        System.out.println("Move disk " + i + " from " + a + " to " + c);
        moves++;
        moves += towerOfHanoi(i - 1, b, c, a);
        return moves;
    }

}

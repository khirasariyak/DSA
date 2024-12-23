package Recursion;

public class PrintN {

    public static void main(String[] args) {
        int n = 6;
        printOneToN(n);
        System.out.println("------------------");
        printNToOne(n);
    }

    private static void printNToOne(int n) {
        if (n == 0) {
            return;
        }
        System.out.println(n);
        printNToOne(n - 1);
    }

    private static void printOneToN(int n) {
        if (n == 0) {
            return;
        }
        printOneToN(n - 1);
        System.out.println(n);
    }

}

package Recursion;

import java.util.Stack;

/*
* https://www.geeksforgeeks.org/problems/reverse-a-stack/1
* */

public class ReverseAStackUsingRecursion {

    public static void main(String[] args) {
        Stack<Integer> stack = getStack();
        reverse(stack);
        System.out.println(stack);
    }

    private static void reverse(Stack<Integer> stack) {

        if (stack.size() == 1) {
            return;
        }

        int popped = stack.pop();
        reverse(stack);
        insertAtBottom(stack, popped);
    }

    private static void insertAtBottom(Stack<Integer> stack, int popped) {

        if (stack.isEmpty()) {
            stack.push(popped);
            return;
        }

        int temp = stack.pop();
        insertAtBottom(stack, popped);
        stack.push(temp);

    }

    private static Stack<Integer> getStack() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        return stack;
    }

}

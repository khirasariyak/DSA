package Recursion;

import java.util.Stack;

/*
* https://www.geeksforgeeks.org/problems/sort-a-stack/1
* */

public class SortAStackWithRecursion {

    public static void main(String[] args) {
        Stack<Integer> stack = getStack();
        sortStack(stack);
        System.out.println(stack);
    }

    private static void sortStack(Stack<Integer> stack) {

        if (stack.size() <= 1) {
            return;
        }

        int lastElement = stack.pop();
        sortStack(stack);
        insert(stack, lastElement);
    }

    private static void insert(Stack<Integer> stack, int lastElement) {

        if (stack.isEmpty() || stack.peek() <= lastElement) {
            stack.push(lastElement);
            return;
        }

        int top = stack.pop();
        insert(stack, lastElement);
        stack.push(top);
    }

    private static Stack<Integer> getStack() {
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(4);
        stack.push(3);
        stack.push(2);
        stack.push(1);
        return stack;
    }

}

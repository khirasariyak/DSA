package Recursion;

import java.util.Stack;

public class DeleteMiddleElementOfStack {

    public static void main(String[] args) {
        Stack<Integer> stack = getStack();
        deleteMiddleElement(stack);
        System.out.println(stack);
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

    private static void deleteMiddleElement(Stack<Integer> stack) {

        if (stack.isEmpty()) {
            return;
        }

        int k = stack.size() / 2 + 1;
        deleteMiddleElement(stack, k);
    }

    private static void deleteMiddleElement(Stack<Integer> stack, int k) {

        if (k == 1) {
            stack.pop();
            return;
        }

        int popped = stack.pop();
        deleteMiddleElement(stack, k - 1);
        stack.push(popped);
    }

}

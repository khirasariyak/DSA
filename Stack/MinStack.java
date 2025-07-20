package Stack;

import java.util.Stack;

/*
* https://leetcode.com/problems/min-stack/
* */

public class MinStack {

    int min;
    Stack<Integer> stack;

    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int val) {
        if (stack.isEmpty()) {
            stack.push(0);
            min = val;
        } else {
            stack.push(val - min);
            if (val < min) {
                min = val;
            }
        }
    }

    public void pop() {
        if (stack.isEmpty()) {
            return;
        }

        int pop = stack.pop();
        if (pop < 0) {
            min = min - pop;
        }
    }

    public int top() {
        int top = stack.peek();
        if (top > 0) {
            return (top + min);
        } else {
            return min;
        }
    }

    public int getMin() {
        return min;
    }


    static class MinStackBruteForce {

        Stack<Integer> stack;
        Stack<Integer> minStack;

        public MinStackBruteForce() {
            stack = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(int val) {
            stack.push(val);
            if (stack.isEmpty() || val <= minStack.peek()) {
                minStack.push(val);
            }
        }

        public void pop() {
            if (stack.isEmpty()) {
                return;
            }
            int popped = stack.pop();
            if (popped == minStack.peek()) {
                minStack.pop();
            }
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }

    }

}

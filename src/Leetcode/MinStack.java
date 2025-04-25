package Leetcode;

import java.util.Stack;

class MinStack {
    private Stack<Integer> stack; // Stack to hold the elements
    private Stack<Integer> minStack; // Stack to hold the minimums

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    // Pushes an element onto the stack.
    public void push(int x) {
        stack.push(x);

        // If the minStack is empty or the current value is less than or equal to the current minimum
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x); // Push the new minimum onto minStack
        } else {
            minStack.push(minStack.peek()); // Push the current minimum onto minStack
        }
    }

    // Removes the element on the top of the stack.
    public void pop() {
        stack.pop();
        minStack.pop(); // Remove the corresponding minimum from minStack
    }

    // Gets the top element of the stack.
    public int top() {
        return stack.peek();
    }

    // Retrieve the minimum element in the stack.
    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        Stack<Integer> test = new Stack<>();
        test.push(2);
        test.push(3);
        test.push(4);
        test.push(5);
        test.push(6);

        test.forEach(x -> System.out.println("Stack value " + x.intValue()));

        // Push elements
        minStack.push(10);
        minStack.push(20);
        minStack.push(5);
        minStack.push(15);

        // Test getMin and top after pushes
        System.out.println("Top element: " + minStack.top());        // Output: 15
        System.out.println("Current minimum: " + minStack.getMin()); // Output: 5

        // Pop elements
        minStack.pop();

        System.out.println("Top element after pop: " + minStack.top());        // Output: 5
        System.out.println("Current minimum after pop: " + minStack.getMin()); // Output: 5

        minStack.pop();

        System.out.println("Top element after another pop: " + minStack.top());        // Output: 20
        System.out.println("Current minimum after another pop: " + minStack.getMin()); // Output: 10
    }
}

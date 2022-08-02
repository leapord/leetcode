package offer;

import java.util.ArrayDeque;
import java.util.Deque;

public class Offer30 {
    class MinStack {

        Deque<Integer> minStack;
        Deque<Integer> stack;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            minStack = new ArrayDeque<>();
            stack = new ArrayDeque<>();
            minStack.push(Integer.MAX_VALUE);
        }

        public void push(int x) {
            stack.push(x);
            minStack.push(Math.min(minStack.peek(), x));
        }

        public void pop() {
            stack.pop();
            minStack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int min() {
            return minStack.peek();
        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */
}

package offer;

import java.util.ArrayDeque;
import java.util.Deque;

public class Offer09 {
    class CQueue {
        Deque<Integer> a;
        Deque<Integer> b;

        public CQueue() {
            a = new ArrayDeque<>();
            b = new ArrayDeque<>();
        }

        public void appendTail(int value) {
            a.push(value);
        }

        public int deleteHead() {
            if (b.isEmpty()) {
                if (a.isEmpty()) {
                    return -1;
                }
                while (!a.isEmpty()) {
                    b.push(a.pop());
                }
            }
            return b.pop();
        }
    }
}

package offer;

import java.util.PriorityQueue;

public class Offer41 {
    class MedianFinder {

        PriorityQueue<Integer> top = null;
        PriorityQueue<Integer> botton = null;

        /**
         * initialize your data structure here.
         */
        public MedianFinder() {
            top = new PriorityQueue<>();
            botton = new PriorityQueue<>((x, y) -> (y - x));
        }

        public void addNum(int num) {
            if (top.size() == botton.size()) {
                botton.add(num);
                top.add(botton.poll());
            } else {
                top.add(num);
                botton.add(top.poll());
            }
        }

        public double findMedian() {
            return top.size() != botton.size() ? top.peek() : (top.peek() + botton.peek()) / 2.0;
        }
    }
}

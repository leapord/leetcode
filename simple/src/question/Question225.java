package question;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author leapord
 * @since 2022/8/19
 */
public class Question225 {
    /**
     * 请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通栈的全部四种操作（push、top、pop 和 empty）。
     * <p>
     * 实现 MyStack 类：
     * <p>
     * void push(int x) 将元素 x 压入栈顶。
     * int pop() 移除并返回栈顶元素。
     * int top() 返回栈顶元素。
     * boolean empty() 如果栈是空的，返回 true ；否则，返回 false 。
     *  
     * <br/>
     * 注意：
     * <p>
     * 你只能使用队列的基本操作 —— 也就是 push to back、peek/pop from front、size 和 is empty 这些操作。
     * 你所使用的语言也许不支持队列。 你可以使用 list （列表）或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
     * <br/>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/implement-stack-using-queues
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    class MyStack {
        Queue<Integer> queue = null;

        public MyStack() {
            queue = new LinkedList<>();
        }

        public void push(int x) {
            int size = queue.size();
            queue.offer(x);
            for (int i = 0; i < size; i++) {
                queue.offer(queue.poll());
            }
        }

        public int pop() {
            return queue.poll();
        }

        public int top() {
            return queue.peek();
        }

        public boolean empty() {
            return queue.isEmpty();
        }
    }
}

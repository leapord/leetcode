package question;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author leapord
 * @since 2022/8/4
 */
public class Question382 {

    /**
     * 给你一个单链表，随机选择链表的一个节点，并返回相应的节点值。每个节点 被选中的概率一样 。
     *
     * 实现 Solution 类：
     *
     * Solution(ListNode head) 使用整数数组初始化对象。
     * int getRandom() 从链表中随机选择一个节点并返回该节点的值。链表中所有节点被选中的概率相等。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/linked-list-random-node
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    /**
     * Definition for singly-linked list.
     */
    public class ListNode {

        public int val;
        public ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


    class Solution {
        List<Integer> values = new ArrayList<>();
        Random random = new Random();
        public Solution(ListNode head) {
            while(head!=null){
                values.add(head.val);
                head = head.next;
            }
        }

        public int getRandom() {
            return values.get(random.nextInt(values.size()));
        }
    }
}

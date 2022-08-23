package question;

import java.util.HashSet;
import java.util.Set;

/**
 * @author leapord
 * @since 2022/8/9
 */
public class Question142 {
    /**
     * 给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
     *
     * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
     * 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
     * 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
     *
     * 不允许修改 链表。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/linked-list-cycle-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    /**
     * Definition for singly-linked list.
     * class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) {
     * val = x;
     * next = null;
     * }
     * }
     */

    class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        //hash表做法
        Set<ListNode> set = new HashSet<>();

        while (head != null) {
            if (set.contains(head)) {
                return head;
            }
            set.add(head);
            head = head.next;
        }

        return null;
    }

    public ListNode detectCycle1(ListNode head) {
        //快慢指针做法
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            // 找出环
            if(fast == slow){
                fast = head;

                while(fast !=slow){
                    fast=fast.next;
                    slow=slow.next;
                }
                return slow;
            }
        }

        return null;
    }

}

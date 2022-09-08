package InterviewPlan;

/**
 * @author leapord
 * @since 2022/9/8
 */
public class Question328 {
    /**
     * 给定单链表的头节点 head ，将所有索引为奇数的节点和索引为偶数的节点分别组合在一起，然后返回重新排序的列表。
     * <p>
     * 第一个节点的索引被认为是 奇数 ， 第二个节点的索引为 偶数 ，以此类推。
     * <p>
     * 请注意，偶数组和奇数组内部的相对顺序应该与输入时保持一致。
     * <p>
     * 你必须在 O(1) 的额外空间复杂度和 O(n) 的时间复杂度下解决这个问题。
     * <p>
     * 提示:
     * <p>
     * n ==  链表中的节点数
     * 0 <= n <= 104
     * -106 <= Node.val <= 106
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/odd-even-linked-list
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode odd = head;
        ListNode eventHead = head.next;
        ListNode event = eventHead;

        while (event != null && event.next != null) {
            odd.next = event.next;
            odd = odd.next;
            event.next = odd.next;
            event = event.next;
        }

        odd.next = eventHead;

        return head;
    }

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
}

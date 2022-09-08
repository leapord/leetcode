package InterviewPlan;

/**
 * @author leapord
 * @since 2022/9/8
 */
public class Question148 {
    /**
     * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
     * <p>
     * 提示：
     * <p>
     * 链表中节点的数目在范围 [0, 5 * 104] 内
     * -105 <= Node.val <= 105
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode temp = slow.next;
        slow.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(temp);

        ListNode h = new ListNode(0);

        ListNode res = h;

        // 归并操作
        while (left != null && right != null) {
            if (left.val < right.val) {
                h.next = left;
                left = left.next;
            } else {
                h.next = right;
                right = right.next;
            }
            h = h.next;
        }
        h.next = left != null ? left : right;
        return res.next;
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

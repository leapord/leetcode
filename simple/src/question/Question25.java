package question;

/**
 * @author leapord
 * @since 2022/9/27
 */
public class Question25 {
    /**
     * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
     * <p>
     * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
     * <p>
     * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/reverse-nodes-in-k-group
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode h = new ListNode(0);
        h.next = head;
        ListNode pre = h;

        while (head != null) {
            // 确认首位指针位置

            ListNode tail = pre;
            // 尾指针移动k个节点
            for (int i = 0; i < k; i++) {
                tail = tail.next;
                // 如果已经到达最后一个节点，直接退出
                if (tail == null) {
                    return h.next;
                }
            }
            // 暂存分组后一位节点
            ListNode nex = tail.next;
            ListNode[] reverse = reverse(head, tail);
            head = reverse[0];
            tail = reverse[1];

            // 把翻转后的节点全部接回去
            pre.next = head;
            tail.next = nex;
            pre = tail;
            head = tail.next;
        }

        return h.next;
    }

    private ListNode[] reverse(ListNode head, ListNode tail) {
        ListNode pre = tail.next;
        ListNode p = head;
        while (pre != tail) {
            ListNode nex = p.next;
            p.next = pre;
            pre = p;
            p = nex;
        }

        return new ListNode[]{tail, head};
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

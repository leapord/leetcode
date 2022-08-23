package question;

/**
 * @author leapord
 * @since 2022/8/18
 */
public class Question19 {

    /**
     * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
     * 输入：head = [1,2,3,4,5], n = 2
     * 输出：[1,2,3,5]
     * 示例 2：
     * <p>
     * 输入：head = [1], n = 1
     * 输出：[]
     * 示例 3：
     * <p>
     * 输入：head = [1,2], n = 1
     * 输出：[1]
     *  
     * <p>
     * 提示：
     * <p>
     * 链表中结点的数目为 sz
     * 1 <= sz <= 30
     * 0 <= Node.val <= 100
     * 1 <= n <= sz
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/remove-nth-node-from-end-of-list
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode ans = new ListNode(-1);
        ans.next = head;
        ListNode fast = ans;
        ListNode slow = ans;

        while (n > 0) {
            fast = fast.next;
            n--;
        }

        ListNode pre = null;

        while (fast != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next;
        }

        pre.next = slow.next;
        return ans.next;
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

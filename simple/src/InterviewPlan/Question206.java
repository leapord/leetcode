package InterviewPlan;

/**
 * @author leapord
 * @since 2022/8/22
 */
public class Question206 {
    /**
     * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
     * <p>
     * 输入：head = [1,2]
     * 输出：[2,1]
     * 示例 3：
     * <p>
     * 输入：head = []
     * 输出：[]
     *  
     * <p>
     * 提示：
     * <p>
     * 链表中节点的数目范围是 [0, 5000]
     * -5000 <= Node.val <= 5000
     *  
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/reverse-linked-list
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public ListNode reverseList(ListNode head) {
        ListNode ans = null;
        while (head != null) {
            ListNode temp = head;
            head = head.next;
            temp.next = ans;
            ans = temp;
        }
        return ans;
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

package InterviewPlan;

import java.util.ArrayList;
import java.util.List;

/**
 * @author leapord
 * @since 2022/9/7
 */
public class Question234 {
    /**
     * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
     * 提示：
     * <p>
     * 链表中节点数目在范围[1, 105] 内
     * 0 <= Node.val <= 9
     */
    public boolean isPalindrome(ListNode head) {
        List<Integer> values = new ArrayList<>();

        while (head != null) {
            values.add(head.val);
            head = head.next;
        }

        int left = 0;
        int right = values.size() - 1;

        while (left < right) {
            if (values.get(left) != values.get(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
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

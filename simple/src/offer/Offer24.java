package offer;

/**
 * @author leapord
 * @since 2022/8/5
 */
public class Offer24 {
    /**
     * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
     */
    public class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseList(ListNode head) {
        ListNode result = null;
        ListNode cursor = head;

        // 头插法倒序
        while(cursor!=null){

            ListNode temp = cursor.next;
            cursor.next = result;
            result = cursor;
            cursor = temp;

        }

        return result;
    }
}

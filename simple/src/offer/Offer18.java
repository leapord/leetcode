package offer;

public class Offer18 {
    public class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteNode(ListNode head, int val) {
        ListNode pre = head;
        if (pre == null){
            return null;
        }
        if(pre.val == val){
            head = head.next;
            return head;
        }
        ListNode cursor = pre.next;
        while(cursor != null){
            if(cursor.val == val){
                pre.next = cursor.next;
                break;
            }
            pre = pre.next;
            cursor = cursor.next;
        }
        return head;
    }


}

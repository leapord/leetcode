package offer;

import java.util.HashSet;
import java.util.Set;

public class Offer52 {
    public class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode cursor = headA;
        Set<ListNode> visited = new HashSet<>();
        while (cursor != null) {
            visited.add(cursor);
            cursor = cursor.next;
        }
        cursor = headB;
        while (cursor != null) {
            if (visited.contains(cursor)) {
                return cursor;
            }
            cursor = cursor.next;
        }

        return null;
    }
}

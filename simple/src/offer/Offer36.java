package offer;

public class Offer36 {

    public class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    Node pre;
    Node head;

    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        dfs(root);
        pre.right = head;
        head.left = pre;
        return head;
    }

    private void dfs(Node cursor) {
        if(cursor == null) return;

        dfs(cursor.left);

        if(pre != null) pre.right = cursor;
        else head = cursor;

        cursor.left = pre;
        pre = cursor;

        dfs(cursor.right);

    }
}

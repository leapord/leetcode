package offer;

public class Offer54 {

    public class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int res = 0;
    int path = 0;

    public int kthLargest(TreeNode root, int k) {
        this.path = k;
        dfs(root);
        return res;
    }

    private void dfs(TreeNode root) {
        if(root == null) return;
        if (path == 0) return;
        dfs(root.right);
        if (--path == 0) res = root.val;
        dfs(root.left);
    }
}

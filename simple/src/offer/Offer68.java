package offer;

import java.util.LinkedList;
import java.util.List;

public class Offer68 {
    public class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pathP = getPathP(root, p);
        List<TreeNode> pathQ = getPathP(root, q);
        TreeNode ans = null;

        for (int i = 0; i < pathP.size() && i < pathQ.size(); i++) {
            if (pathP.get(i) == pathQ.get(i)) {
                ans = pathQ.get(i);
            } else {
                break;
            }
        }

        return ans;
    }

    private List<TreeNode> getPathP(TreeNode root, TreeNode node) {
        List<TreeNode> path = new LinkedList<>();

        TreeNode cursor = root;
        while (cursor != node) {
            path.add(cursor);
            if (node.val < cursor.val) {
                cursor = cursor.left;
            } else {
                cursor = cursor.right;
            }
        }
        path.add(cursor);
        return path;
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null || root == p || root == q) {
            return null;
        }

        TreeNode left = lowestCommonAncestor2(root.left, p, q);
        TreeNode right = lowestCommonAncestor2(root.right, p, q);
        if (left == null) {
            return right;
        }

        if (right == null) {
            return left;
        }
        return root;
    }

}

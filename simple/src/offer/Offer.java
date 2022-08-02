package offer;

import java.util.LinkedList;
import java.util.Queue;

public class Offer {
    public class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        }
    }

    public int maxDepth1(TreeNode root) {
        Queue<TreeNode> visited = new LinkedList<>();
        if (root == null) {
            return 0;
        }
        int path = 0;
        visited.offer(root);
        while (!visited.isEmpty()) {
            int size = visited.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = visited.poll();
                if (node.left != null) {
                    visited.offer(node.left);
                }
                if (node.right != null) {
                    visited.offer(node.right);
                }
            }
            path++;
        }
        return path;
    }

    public boolean isBalanced(TreeNode root) {
        return height(root) >= 0;
    }

    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public boolean isBalanced1(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(deplength(root.left) - deplength(root.right)) <= 1 && isBalanced1(root.left) && isBalanced1(root.right);
    }

    private int deplength(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return Math.max(deplength(root.left), deplength(root.right)) + 1;
        }
    }

}

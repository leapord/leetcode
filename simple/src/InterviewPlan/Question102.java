package InterviewPlan;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Queue;

/**
 * @author leapord
 * @since 2022/8/24
 */
public class Question102 {
    /**
     * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> visited = new ArrayDeque<>();
        visited.offer(root);
        while (!visited.isEmpty()) {
            int size = visited.size();
            List<Integer> ans = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = visited.poll();
                ans.add(node.val);

                if (node.left != null) {
                    visited.offer(node.left);
                }

                if (node.right != null) {
                    visited.offer(node.right);
                }
            }
            res.add(ans);
        }

        return res;
    }

    public class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}

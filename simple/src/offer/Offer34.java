package offer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Offer34 {
    public class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        List<List<Integer>> res = new LinkedList<>();
        Deque<Integer> path = new LinkedList<>();
        dfs(root, target, res, path);
        return res;
    }

    private void dfs(TreeNode root, int target, List<List<Integer>> res, Deque<Integer> path) {
        if (root == null) return;
        path.offerLast(root.val);
        target -= root.val;

        if (target == 0 && root.left == null && root.right == null) res.add(new LinkedList<>(path));

        dfs(root.left, target, res, path);
        dfs(root.right, target, res, path);
        path.pollLast();
    }
}

package interview;

/**
 * @author leapord
 * @since 2022/9/27
 */
public class Question124 {
    /**
     * 路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
     * <p>
     * 路径和 是路径中各节点值的总和。
     * <p>
     * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/binary-tree-maximum-path-sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int maxPathSum(TreeNode root) {
        maxGin(root);
        return maxPath;
    }

    private int maxGin(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int leftPath = Math.max(maxGin(root.left), 0);
        int rightPath = Math.max(maxGin(root.right), 0);

        int max = root.val + leftPath + rightPath;
        maxPath = Math.max(maxPath, max);

        return root.val + Math.max(leftPath, rightPath);
    }

    private Integer maxPath = Integer.MIN_VALUE;

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

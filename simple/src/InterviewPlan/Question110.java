package InterviewPlan;

/**
 * @author leapord
 * @since 2022/9/9
 */
public class Question110 {
    /**
     * 给定一个二叉树，判断它是否是高度平衡的二叉树。
     * <p>
     * 本题中，一棵高度平衡二叉树定义为：
     * <p>
     * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
     * <p>
     * 提示：
     * <p>
     * 树中的节点数在范围 [0, 5000] 内
     * -104 <= Node.val <= 104
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(heigth(root.left) - heigth(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int heigth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(heigth(node.left), heigth(node.right)) + 1;
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

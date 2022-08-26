package InterviewPlan;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author leapord
 * @since 2022/8/26
 */
public class Question98 {
    /**
     * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
     * <p>
     * 有效 二叉搜索树定义如下：
     * <p>
     * 节点的左子树只包含 小于 当前节点的数。
     * 节点的右子树只包含 大于 当前节点的数。
     * 所有左子树和右子树自身必须也是二叉搜索树。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/validate-binary-search-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public boolean isValidBST(TreeNode root) {
        // 树的中序遍历 验证 BST
        Deque<TreeNode> stack = new ArrayDeque<>();

        double current = -Double.MAX_VALUE;

        while (!stack.isEmpty() || root != null) {
            // 无论任何情况 左树入栈
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();

            if (root.val <= current) {
                return false;
            }
            current = root.val;
            root = root.right;

        }

        return true;
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

package InterviewPlan;

/**
 * @author leapord
 * @since 2022/9/14
 */
public class Question108 {
    /**
     * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
     * <p>
     * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/convert-sorted-array-to-binary-search-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        // 平衡二叉树 左右均衡，数组转成二叉树，左右均衡平分
        return bst(nums, 0, nums.length - 1);
    }

    private TreeNode bst(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        // 核心，取区间中间元素作为每个左右子树根节点
        int mid = left + (right - left) / 2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = bst(nums, left, mid - 1);
        root.right = bst(nums, mid + 1, right);
        return root;
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

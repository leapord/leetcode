package offer;

public class Offer26 {

    public class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A!= null && B!= null) && (sub(A,B) || isSubStructure(A.left,B) || isSubStructure(A.right,B));
    }

    public boolean sub(TreeNode A, TreeNode B){
        if(B == null) return true;
        if(A == null || A.val != B.val) return false;
        return sub(A.left,B.left) && sub(A.right,B.right);
    }
}

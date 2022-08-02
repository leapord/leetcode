package offer;

import java.util.*;

/**
 * @author leapord
 * @since 2022/7/24
 */
public class Offer37 {

    public class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) {
                return "[]";
            }
            StringBuilder ans = new StringBuilder("[");
            Queue<TreeNode> visited = new LinkedList<>();
            visited.offer(root);
            while (!visited.isEmpty()) {
                TreeNode node = visited.poll();
                if (node != null) {
                    ans.append(node.val + ",");
                    visited.offer(node.left);
                    visited.offer(node.right);
                } else {
                    ans.append("null,");
                }
            }
            ans.deleteCharAt(ans.length() - 1);
            ans.append("]");
            return ans.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data.equals("[]")) {
                return null;
            }
            String[] values = data.substring(1, data.length() - 1).split(",");
            TreeNode root = new TreeNode(Integer.parseInt(values[0]));
            Queue<TreeNode> visited = new LinkedList<>();
            visited.offer(root);

            int i = 1;
            while (!visited.isEmpty()) {
                TreeNode node = visited.poll();
                if (!"null".equals(values[i])) {
                    node.left = new TreeNode(Integer.parseInt(values[i]));
                    visited.offer(node.left);
                }
                i++;
                if (!"null".equals(values[i])) {
                    node.right = new TreeNode(Integer.parseInt(values[i]));
                    visited.offer(node.right);
                }
                i++;
            }

            return root;
        }
    }

}

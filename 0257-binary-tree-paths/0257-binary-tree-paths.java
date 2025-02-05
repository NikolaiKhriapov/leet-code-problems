/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        helper(root, result, new StringBuilder(""));
        return result;
    }

    private void helper(TreeNode node, List<String> result, StringBuilder sb) {
        if (!Objects.equals(sb.toString(), "")) {
            sb.append("->");
        }
        sb.append(node.val);
        
        if (node.left == null && node.right == null) {
            result.add(sb.toString());
        }

        StringBuilder sbB = new StringBuilder(sb.toString());
        if (node.left != null) {
            helper(node.left, result, sb);
        }
        if (node.right != null) {
            helper(node.right, result, sbB);
        }
    }
}
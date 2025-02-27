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
        List<String> list = new ArrayList<>();
        
        StringBuilder sb = new StringBuilder();

        helper(root, list, sb);
        return list;
    }

    private void helper(TreeNode node, List<String> list, StringBuilder sb) {
        if (sb.length() != 0) sb.append("->");
        sb.append(node.val);

        int sbl = sb.length();

        if (node.left == null && node.right == null) {
            list.add(sb.toString());
        }
        
        if (node.left != null) helper(node.left, list, sb);
        sb = sb.delete(sbl, sb.length());
        if (node.right != null) helper(node.right, list, sb);
    }
}
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
        if (root != null) handleNode(root, new StringBuilder(""), result);
        return result;
    }

    private void handleNode(TreeNode node, StringBuilder path, List<String> result) {
        int len = path.length();
        path.append(node.val);
        
        if (node.left == null && node.right == null) {
            result.add(path.toString());
        } else {
            path.append("->");
            if (node.left != null) handleNode(node.left, new StringBuilder(path), result);
            if (node.right != null) handleNode(node.right, new StringBuilder(path), result);
        }
        path.setLength(len);
    }
}
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
        if (root != null) {
            helper(root, list, new String());
        }
        return list;
    }

    private void helper(TreeNode node, List<String> list, String s) {
        if (s.length() != 0) {
            s += "->";
        }
        s += node.val;

        if (node.left == null && node.right == null) {
            list.add(s);
        }

        if (node.left != null) helper(node.left, list, s);
        if (node.right != null) helper(node.right, list, s);
    }
}
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
    public TreeNode increasingBST(TreeNode root) {
        return helper(root, null);        
    }

    private TreeNode helper(TreeNode node, TreeNode prev) {
        if (node == null) {
            return prev;
        }

        TreeNode newRoot = helper(node.left, node);
        
        node.left = null;
        node.right = helper(node.right, prev);
        
        return newRoot;
    }
}
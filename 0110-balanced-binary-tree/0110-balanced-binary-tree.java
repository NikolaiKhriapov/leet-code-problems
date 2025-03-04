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
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        if (!isBalanced(root.left) || !isBalanced(root.right)) return false;

        int hl = helper(root.left);
        int hr = helper(root.right);

        if (hl == -1 || hr == -1) return false;

        return Math.abs(hl - hr) <= 1;
    }

    private int helper(TreeNode node) {
        if (node == null) return 0;

        int hl = helper(node.left);
        int hr = helper(node.right);
        
        if (hl == -1 || hr == -1) return -1;

        return 1 + Math.max(hl, hr);
    }
}

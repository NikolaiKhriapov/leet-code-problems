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
        return helper(root) != -1;
    }

    private int helper(TreeNode node) {
        if (node == null) return 0;

        int heightLeft = helper(node.left);
        int heightRight = helper(node.right);

        if (heightLeft == -1 || heightRight == -1 || Math.abs(heightLeft - heightRight) > 1) return -1;

        return 1 + Math.max(heightLeft, heightRight);
    }
}
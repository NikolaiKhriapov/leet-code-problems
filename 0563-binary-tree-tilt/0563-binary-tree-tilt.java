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
    private int tiltSum = 0;

    public int findTilt(TreeNode root) {
        helper(root);
        return tiltSum;
    }

    private int helper(TreeNode node) {
        if (node == null) return 0;

        int l = helper(node.left);
        int r = helper(node.right);
        
        tiltSum += Math.abs(l - r);

        return node.val + l + r;
    }
}

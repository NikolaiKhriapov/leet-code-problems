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
    private int totalTilt = 0;
    
    public int findTilt(TreeNode root) {
        helper(root);
        return totalTilt;
    }

    private int helper(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int sumL = helper(node.left);
        int sumR = helper(node.right);

        int tilt = Math.abs(sumL - sumR);
        totalTilt += tilt;

        return node.val + sumL + sumR;
    }
}
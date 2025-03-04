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
    private int sum = 0;

    public int findTilt(TreeNode root) {
        helper(root);
        return sum;
    }

    private int helper(TreeNode root) {
        if (root == null) return 0;
        
        int val = root.val;

        int l = helper(root.left);
        int r = helper(root.right);

        int tilt = Math.abs(l - r);
        root.val = tilt;
        sum += tilt;

        return val + l + r;
    }
}
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
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int[] maxSum = new int[] {Integer.MIN_VALUE};
        helper(root, maxSum);
        return maxSum[0];
    }

    private int helper(TreeNode node, int[] maxSum) {
        if (node == null) {
            return 0;
        }

        int leftVal = Math.max(helper(node.left, maxSum), 0);
        int rightVal = Math.max(helper(node.right, maxSum), 0);

        maxSum[0] = Math.max(maxSum[0], node.val + leftVal + rightVal);

        return node.val + Math.max(leftVal, rightVal);
    }
}
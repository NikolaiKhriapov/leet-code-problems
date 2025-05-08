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
    public boolean isValidBST(TreeNode root) {

        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode node, long minLeft, long maxRight) {
        if (node == null) {
            return true;
        }
        if (node.val <= minLeft || node.val >= maxRight) {
            return false;
        }

        return isValidBST(node.left, minLeft, node.val) && isValidBST(node.right, node.val, maxRight);
    }
}
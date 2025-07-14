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
    public int longestZigZag(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int[] maxLength = new int[] {0};
        helper(root.left, true, 1, maxLength);
        helper(root.right, false, 1, maxLength);
        return maxLength[0];
    }

    private void helper(TreeNode node, boolean isLeft, int length, int[] maxLength) {
        if (node == null) {
            return;
        }

        maxLength[0] = Math.max(maxLength[0], length);
        if (isLeft) {
            helper(node.right, false, 1 + length, maxLength);
            helper(node.left, true, 1, maxLength);
        } else {
            helper(node.left, true, 1 + length, maxLength);
            helper(node.right, false, 1, maxLength);
        }
    }
}
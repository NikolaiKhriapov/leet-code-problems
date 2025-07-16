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
        helper(root.left, 1, true, maxLength);
        helper(root.right, 1, false, maxLength);
        return maxLength[0];
    }

    private void helper(TreeNode node, int currLength, boolean isLeft, int[] maxLength) {
        if (node == null) {
            return;
        }

        maxLength[0] = Math.max(maxLength[0], currLength);
        if (isLeft) {
            helper(node.right, currLength + 1, false, maxLength);
            helper(node.left, 1, true, maxLength);
        } else {
            helper(node.left, currLength + 1, true, maxLength);
            helper(node.right, 1, false, maxLength);
        }
    }
}
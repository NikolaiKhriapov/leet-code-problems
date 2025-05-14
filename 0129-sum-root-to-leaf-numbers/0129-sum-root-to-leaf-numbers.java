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
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int[] result = new int[1];
        helper(root, 0, result);
        return result[0];
    }

    private void helper(TreeNode node, int currSum, int[] result) {
        if (node == null) return;
        
        currSum = currSum * 10 + node.val;

        if (node.left == null && node.right == null) {
            result[0] += currSum;
            return;
        }

        if (node.left != null) {
            helper(node.left, currSum, result);
        }
        if (node.right != null) {
            helper(node.right, currSum, result);
        }
    }
}
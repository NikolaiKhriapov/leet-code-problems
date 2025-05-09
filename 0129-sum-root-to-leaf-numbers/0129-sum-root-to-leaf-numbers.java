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
            throw new IllegalArgumentException("Invalid input");
        }

        return helper(root, root.val, 0);
    }

    private int helper(TreeNode node, Integer curr, int total) {
        if (node.left == null && node.right == null) {
            return curr;
        }

        int sub = 0;
        if (node.left != null) {
            sub += helper(node.left, curr * 10 + node.left.val, total);
        }
        if (node.right != null) {
            sub += helper(node.right, curr * 10 + node.right.val, total);
        }
        return total * 10 + sub;
    }
}
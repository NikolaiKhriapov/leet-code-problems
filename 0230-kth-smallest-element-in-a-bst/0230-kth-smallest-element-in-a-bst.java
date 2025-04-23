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
    public int kthSmallest(TreeNode root, int k) {
        if (root == null || k <= 0) {
            throw new RuntimeException("Invalid input"); // for simplicity
        }
        return helper(root, new int[] {k});
    }

    private int helper(TreeNode node, int[] k) {
        if (node == null) return -1;

        int l = helper(node.left, k);
        if (l != -1) return l;

        if (--k[0] == 0) return node.val;

        int r = helper(node.right, k);
        if (r != -1) return r;

        return -1;
    }
}
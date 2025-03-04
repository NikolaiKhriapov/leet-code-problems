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
    private int diffMin = Integer.MAX_VALUE;
    private TreeNode prev = null;

    public int getMinimumDifference(TreeNode root) {
        if (root == null) return Integer.MAX_VALUE;

        getMinimumDifference(root.left);

        if (prev != null) {
            diffMin = Math.min(diffMin, root.val - prev.val);
        }
        prev = root;

        getMinimumDifference(root.right);

        return diffMin;
    }
}
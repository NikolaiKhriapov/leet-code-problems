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
        if (k <= 0) {
            throw new IllegalArgumentException("Invalid input");
        }
        int kthSmallest = helper(root, new int[]{k});
        if (kthSmallest == -1) {
            throw new IllegalArgumentException("Invalid input");
        }
        return kthSmallest;
    }

    private int helper(TreeNode node, int[] count) {
        if (node == null) {
            return -1;
        }

        int left = helper(node.left, count);
        if (left != -1) {
            return left;
        }

        if (--count[0] == 0) {
            return node.val;
        }

        int right = helper(node.right, count);
        if (right != -1) {
            return right;
        }

        return -1;
    }
}
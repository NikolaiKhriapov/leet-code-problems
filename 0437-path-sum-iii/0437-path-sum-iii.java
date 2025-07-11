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
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        return countFromNode(root, targetSum) + pathSum(root.left, targetSum) + pathSum(root.right, targetSum);
    }

    private int countFromNode(TreeNode node, long targetSum) {
        if (node == null) {
            return 0;
        }
        long val = targetSum - node.val;
        int count = val == 0 ? 1 : 0;
        count += countFromNode(node.left, val);
        count += countFromNode(node.right, val);
        return count;
    }
}
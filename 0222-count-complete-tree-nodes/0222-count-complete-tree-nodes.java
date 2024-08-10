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
    public int countNodes(TreeNode root) {
        int count = 0;
        return handleNode(root, count);
    }

    private int handleNode(TreeNode node, int count) {
        if (node != null) {
            count++;
            count = handleNode(node.left, count);
            count = handleNode(node.right, count);
        }
        return count;
    }
}
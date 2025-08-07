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
        if (root == null) {
            return 0;
        }

        int depthLeft = getDepthLeft(root);
        int depthRight = getDepthRight(root);
        if (depthLeft == depthRight) {
            return (int) Math.pow(2, depthLeft) - 1;
        }

        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    private int getDepthLeft(TreeNode root) {
        int count = 0;
        while (root != null) {
            count++;
            root = root.left;
        }
        return count;
    }

    private int getDepthRight(TreeNode root) {
        int count = 0;
        while (root != null) {
            count++;
            root = root.right;
        }
        return count;
    }
}

// time  = O((log n) ^2)
// space = O(log n)
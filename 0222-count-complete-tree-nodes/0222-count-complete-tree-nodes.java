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

        // if left depth equals to right depth, we calculate number or nodes directly
        int depthLeft = getDepthLeft(root);
        int depthRight = getDepthRight(root);
        if (depthLeft == depthRight) {
            return (int) Math.pow(2, depthLeft) - 1;
        }

        // otherwise, we do generic BFS
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    private int getDepthLeft(TreeNode root) {
        int depth = 1;
        while (root.left != null) {
            root = root.left;
            depth++;
        }
        return depth;
    }

    private int getDepthRight(TreeNode root) {
        int depth = 1;
        while (root.right != null) {
            root = root.right;
            depth++;
        }
        return depth;
    }
}

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
        if (root == null) return 0;
        
        int hl = getHeight(root.left);
        int hr = getHeight(root.right);
        
        int n = 0;
        if (hl == hr) {
            n += Math.pow(2, hl) + countNodes(root.right);
        } else {
            n += Math.pow(2, hr) + countNodes(root.left);
        }

        return n;
    }

    private int getHeight(TreeNode node) {
        int h = 0;
        while (node != null) {
            node = node.left;
            h++;
        }
        return h;
    }
}
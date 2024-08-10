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

        int a = 0;

        a = handleNode(root, a);
        
        return a;
    }

    private int handleNode(TreeNode node, int a) {
        if (node != null) {
            a++;
            a = handleNode(node.left, a);
            a = handleNode(node.right, a);
        }
        return a;
    }
}
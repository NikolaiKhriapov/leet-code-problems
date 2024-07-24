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

    int sum = 0;

    public int findTilt(TreeNode root) {
        if (root == null) return 0;

        getSum(root);

        return sum;
    }

    private int getSum(TreeNode node) {
        if (node == null) return 0;

        int valL = getSum(node.left);
        int valR = getSum(node.right);

        sum += Math.abs(valL - valR);
        return node.val + valL + valR;
    }
}
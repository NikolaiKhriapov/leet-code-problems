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
    private int dMax = 0;
    private Map<TreeNode, Integer> map = new HashMap<>();

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        int d = helper(root.left) + helper(root.right);
        dMax = Math.max(dMax, d);

        diameterOfBinaryTree(root.left);
        diameterOfBinaryTree(root.right);

        return dMax;
    }

    private int helper(TreeNode node) {
        if (node == null) return 0;

        if (map.containsKey(node)) return map.get(node);

        int result = 1 + Math.max(helper(node.left), helper(node.right));
        map.put(node, result);
        return result;
    }
}
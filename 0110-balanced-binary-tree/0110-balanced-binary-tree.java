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
    Map<TreeNode, Integer> map = new HashMap<>();

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        
        if (!isBalanced(root.left) || !isBalanced(root.right)) return false;

        return Math.abs(helper(root.left) - helper(root.right)) <= 1;
    }

    private int helper(TreeNode node) {
        if (node == null) return 0;

        if (map.containsKey(node)) return map.get(node);

        int result = 1 + Math.max(helper(node.left), helper(node.right));
        map.put(node, result);
        return result;
    }
}

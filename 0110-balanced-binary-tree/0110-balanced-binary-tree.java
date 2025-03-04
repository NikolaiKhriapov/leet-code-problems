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
    public boolean isBalanced(TreeNode root) {
        return isBalanced(root, new HashMap<>());
    }

    private boolean isBalanced(TreeNode root, Map<TreeNode, Integer> map) {
        if (root == null) return true;
        
        if (!isBalanced(root.left) || !isBalanced(root.right)) return false;

        return Math.abs(helper(root.left, map) - helper(root.right, map)) <= 1;
    }

    private int helper(TreeNode node, Map<TreeNode, Integer> map) {
        if (node == null) return 0;

        if (map.containsKey(node)) return map.get(node);

        int result = 1 + Math.max(helper(node.left, map), helper(node.right, map));
        map.put(node, result);
        return result;
    }
}

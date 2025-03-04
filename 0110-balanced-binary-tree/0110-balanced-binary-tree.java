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

    private boolean isBalanced(TreeNode root, Map<TreeNode, Boolean> map) {
        if (root == null) return true;

        if (map.containsKey(root)) return map.get(root);

        if (!isBalanced(root.left, map) || !isBalanced(root.right, map)) return false;

        boolean result = Math.abs(helper(root.left) - helper(root.right)) <= 1;
        map.put(root, result);
        return result;
    }

    private int helper(TreeNode node) {
        if (node == null) return 0;
        return 1 + Math.max(helper(node.left), helper(node.right));
    }
}

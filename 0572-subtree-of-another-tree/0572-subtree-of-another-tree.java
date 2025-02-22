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
    Set<TreeNode> set = new HashSet<>();

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) return true;
        if (root == null || subRoot == null) return false;

        if (set.contains(root)) return false;
        boolean is = isSameTree(root, subRoot);
        if (is) return true;
        else set.add(root);

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isSameTree(TreeNode node, TreeNode subRoot) {
        if (node == null && subRoot == null) return true;
        if (node == null || subRoot == null) return false;

        return node.val == subRoot.val && isSameTree(node.left, subRoot.left) && isSameTree(node.right, subRoot.right);
    }
}
class Solution {
    private TreeNode prev = null;
    private int diffMin = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        helper(root);
        return diffMin;
    }

    private void helper(TreeNode node) {
        if (node == null) {
            return;
        }

        helper(node.left);

        if (prev != null) {
            diffMin = Math.min(diffMin, node.val - prev.val);
        }
        prev = node;

        helper(node.right);
    }
}
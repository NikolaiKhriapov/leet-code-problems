class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        return helper(root, 0, false);
    }

    private int helper(TreeNode node, int sum, boolean isLeft) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) {
            if (isLeft) return sum + node.val;
            else return 0;
        }

        return helper(node.left, sum, true) + helper(node.right, sum, false);
    }
}
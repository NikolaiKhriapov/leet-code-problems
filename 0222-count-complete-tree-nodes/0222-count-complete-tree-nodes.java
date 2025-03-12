class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;

        int l = getDepthLeft(root);
        int r = getDepthRight(root);
        if (l == r) return (int) Math.pow(2, l) - 1;

        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    private int getDepthLeft(TreeNode node) {
        int depth = 0;
        while (node != null) {
            depth++;
            node = node.left;
        }
        return depth;
    }

    private int getDepthRight(TreeNode node) {
        int depth = 0;
        while (node != null) {
            depth++;
            node = node.right;
        }
        return depth;
    }
}
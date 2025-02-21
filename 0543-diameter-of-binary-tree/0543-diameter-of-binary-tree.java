class Solution {
    private int dMax = 0;
    
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return dMax;
        
        int left = (root.left != null) ? helper(root.left) : 0;
        int right = (root.right != null) ? helper(root.right) : 0;

        int d = left + right;
        dMax = Math.max(dMax, d);

        diameterOfBinaryTree(root.left);
        diameterOfBinaryTree(root.right);

        return dMax;
    }

    private int helper(TreeNode node) {
        if (node == null) return 0;
        return 1 + Math.max(helper(node.left), helper(node.right));
    }
}
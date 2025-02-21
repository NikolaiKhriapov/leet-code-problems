class Solution {
    private int dMax = 0;
    
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return dMax;
        
        dMax = Math.max(dMax, helper(root.left) + helper(root.right));

        diameterOfBinaryTree(root.left);
        diameterOfBinaryTree(root.right);

        return dMax;
    }

    private int helper(TreeNode node) {
        if (node == null) return 0;
        return 1 + Math.max(helper(node.left), helper(node.right));
    }
}
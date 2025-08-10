class Solution {
    public void flatten(TreeNode root) {
        flattenAndReturnTail(root);        
    }

    private TreeNode flattenAndReturnTail(TreeNode node) {
        if (node == null) {
            return node;
        }

        TreeNode leftTail = flattenAndReturnTail(node.left);
        TreeNode rightTail = flattenAndReturnTail(node.right);

        if (leftTail != null) {
            leftTail.right = node.right;
            node.right = node.left;
            node.left = null;
        }

        if (rightTail != null) {
            return rightTail;
        } else if (leftTail != null) {
            return leftTail;
        }
        return node;
    }
}
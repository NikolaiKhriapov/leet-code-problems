class Solution {
    private TreeNode prev = null;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        
        boolean isLeftValid = isValidBST(root.left);
        if (prev != null && root.val <= prev.val) {
            return false;
        }
        prev = root;
        boolean isRightValid = isValidBST(root.right);

        return isLeftValid && isRightValid;
    }
}

// time  - O(n)
// space - O(d)
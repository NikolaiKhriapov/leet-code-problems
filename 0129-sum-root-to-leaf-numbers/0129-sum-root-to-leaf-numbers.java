class Solution {
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return visitNode(root, 0);
    }

    private int visitNode(TreeNode node, int currSum) {
        if (node == null) {
            return 0;
        }

        currSum = currSum * 10 + node.val;
        if (node.left == null && node.right == null) {
            return currSum;
        }
        return visitNode(node.left, currSum) + visitNode(node.right, currSum);
    }
}
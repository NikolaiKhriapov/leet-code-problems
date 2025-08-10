class Solution {
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] sum = new int[] {0};
        visitNode(root, 0, sum);
        return sum[0];
    }

    private void visitNode(TreeNode node, int currSum, int[] sum) {
        currSum = currSum * 10 + node.val;

        if (node.left == null && node.right == null) {
            sum[0] += currSum;
            return;
        }

        if (node.left != null) {
            visitNode(node.left, currSum, sum);
        }
        if (node.right != null) {
            visitNode(node.right, currSum, sum);
        }
    }
}
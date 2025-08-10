class Solution {
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] sum = new int[] {0};
        visitNode(root, new StringBuilder(), sum);
        return sum[0];
    }

    private void visitNode(TreeNode node, StringBuilder curr, int[] sum) {
        curr.append(String.valueOf(node.val));

        if (node.left == null && node.right == null) {
            sum[0] += Integer.parseInt(curr.toString());
            return;
        }

        int currLength = curr.length();
        if (node.left != null) {
            visitNode(node.left, curr, sum);
            curr.setLength(currLength);
        }
        if (node.right != null) {
            visitNode(node.right, curr, sum);
        }
    }
}
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();

        if (root != null) {
            helper(root, list, new StringBuilder());
        }

        return list;
    }

    private void helper(TreeNode node, List<String> list, StringBuilder sb) {
        if (sb.length() != 0) {
            sb.append("->");
        }
        sb.append(node.val);

        if (node.left == null && node.right == null) {
            list.add(sb.toString());
        }
        
        StringBuilder copy = new StringBuilder(sb.toString());

        if (node.left != null) helper(node.left, list, sb);
        if (node.right != null) helper(node.right, list, copy);
    }
}
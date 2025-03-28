class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        helper(root, list);
        return list;
    }

    private void helper(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }

        helper(node.left, list);
        helper(node.right, list);
        list.add(node.val);
    }
}